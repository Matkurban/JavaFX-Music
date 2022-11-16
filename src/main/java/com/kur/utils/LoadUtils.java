package com.kur.utils;

import com.alibaba.fastjson.JSON;
import com.kur.pojo.SongList;
import com.kur.pojo.TwoObject;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static com.kur.app.ImportantParameters.*;


public class LoadUtils {
    public static void load() {

        List<SongList> list = new ArrayList<>();
        File path = CreatFileUtils.writeDataPath();
        try {
            FileReader fileReader = new FileReader(path, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            char[] chars = new char[1024];
            int read = bufferedReader.read(chars);
            if (read > 0) {
                String s = new String(chars, 0, read);
                for (String s1 : s.trim().split("&")) {
                    SongList parseObject = JSON.parseObject(s1, SongList.class);
                    list.add(parseObject);
                }
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Service<TwoObject> insertList = new Service<>() {
            @Override
            protected Task<TwoObject> createTask() {
                return new Task<>() {
                    @Override
                    protected TwoObject call() {
                        for (SongList songList : list) {
                            updateValue(new TwoObject(getClient().insertSongList(key, songList.getSonglistid(), songList.getType()), songList));
                        }
                        return null;
                    }
                };
            }
        };
        insertList.start();
        insertList.valueProperty().addListener((obs, old, xin) -> {
            if (xin != null) {
                getMap().put(xin.getSongList().getSonglistid(), xin.getResults().getData());
                getMylist().addAll(xin.getSongList());
            }

        });
    }
}
