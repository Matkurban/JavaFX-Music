package com.kur.app;

import com.dtflys.forest.Forest;
import com.kur.entity.DataBean;
import com.kur.entity.MediaMapper;
import com.kur.entity.Song;
import com.kur.pojo.SongList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.HashMap;
import java.util.Map;

public class ImportantParameters {
    public static final String key = "acf57863b6d644ceaea24972e4e6b0e0";
    public static String id;
    public static String type;
    public static int NumberOfPlaybackErrors = 0;
    private static Map<String, DataBean> map;
    private static MediaMapper client;
    //歌单listview
    private static ObservableList<Song> list;
    private static ObservableList<SongList> mylist;

    public static Map<String, DataBean> getMap() {
        if (map == null) {
            map = new HashMap<>();
        }
        return map;
    }

    public static MediaMapper getClient() {
        if (client == null) {
            client = Forest.client(MediaMapper.class);
        }
        return client;
    }

    public static ObservableList<Song> getList() {
        if (list == null) {
            list = FXCollections.observableArrayList();
        }
        return list;
    }

    public static ObservableList<SongList> getMylist() {
        if (mylist == null) {
            mylist = FXCollections.observableArrayList();
        }
        return mylist;
    }
}
