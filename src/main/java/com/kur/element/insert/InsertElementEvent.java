package com.kur.element.insert;

import com.alibaba.fastjson.JSON;
import com.kur.element.ComboBoxManage;
import com.kur.entity.Results;
import com.kur.entity.kw.KwAll;
import com.kur.entity.qq.QQAll;
import com.kur.entity.wy.WyAll;
import com.kur.pojo.SongList;
import com.kur.utils.CreatFileUtils;
import com.kur.utils.NotificationUtils;
import com.kur.window.MainWindow;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import static com.kur.app.ImportantParameters.getMap;
import static com.kur.app.ImportantParameters.getMylist;
import static com.kur.element.ComboBoxListener.insertType;


public class InsertElementEvent {
    private static String list = "";
    private static String name;
    private static EventHandler<ActionEvent> insertClicked;
    private static EventHandler<ActionEvent> closeClicked;
    private static EventHandler<MouseEvent> mouseEntered;

    public static EventHandler<ActionEvent> getInsertClicked() {
        SearchPlaylistNameService searchPlaylistNameService = new SearchPlaylistNameService();
        SearchPlaylistService insertList = new SearchPlaylistService();
        if (insertClicked == null) {
            insertClicked = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    getMylist().forEach(songList -> list = list.concat(songList.getSonglistid()));
                    if (list.contains(InsertElementManage.getIdInput().getText())) {
                        new NotificationUtils(MainWindow.getMainWindow()).showDefaultMsg("此歌单已存在", "");
                    } else {
                        InsertElementManage.getIdInput().setDisable(true);
//                        pingTai.setDisable(true);
                        searchPlaylistNameService.start();
                        InsertElementManage.getInsertButton().setDisable(true);
                        InsertElementManage.getSpinner().setVisible(true);
                    }
                }
            };
        }
        searchPlaylistNameService.stateProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals(Worker.State.SUCCEEDED)) {
                searchPlaylistNameService.reset();
            }
        });
        searchPlaylistNameService.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                switch (insertType) {
                    case "wy" -> {
                        WyAll wyAll = JSON.parseObject(newValue, WyAll.class);
                        if (wyAll.getData().getCode() == 200 && wyAll.getData() != null) {
                            insertList.start();
                            name = wyAll.getData().getPlaylist().getName();
                        } else {
                            alert();
                        }
                    }
                    case "qq" -> {
                        QQAll qqAll = JSON.parseObject(newValue, QQAll.class);
                        if (qqAll.getData().getCode() == 0 && qqAll.getData().getData() != null) {
                            qqAll.getData().getData().getCdlist().stream().distinct().forEach(cdlistBean -> name = cdlistBean.getDissname());
                            insertList.start();
                        } else {
                            alert();
                        }
                    }
                    case "kw" -> {
                        KwAll kwAll = JSON.parseObject(newValue, KwAll.class);
                        if (kwAll.getData().getCode() == 200 && kwAll.getData().getData() != null) {
                            insertList.start();
                            name = kwAll.getData().getData().getName();
                        } else {
                            alert();
                        }
                    }
                    case "kg" -> {
                        Results results = JSON.parseObject(newValue, Results.class);
                        if (results.getCode() == 1 && results.getData() != null) {
                            getMylist().add(new SongList(InsertElementManage.getIdInput().getText(), InsertElementManage.getIdInput().getText(), insertType));
                            getMap().put(InsertElementManage.getIdInput().getText(), results.getData());
                            new NotificationUtils(MainWindow.getMainWindow()).showDefaultMsg("添加成功", "");
                            InsertMainWindow.getInsert().close();
                        } else {
                            alert();
                        }
                    }
                }
                InsertElementManage.getIdInput().setDisable(false);
                ComboBoxManage.getPlatformComboBox().setDisable(false);
                InsertElementManage.getInsertButton().setDisable(false);
                InsertElementManage.getSpinner().setVisible(false);
            }

        });
        insertList.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                if (newValue.getData() != null) {
                    getMap().put(InsertElementManage.getIdInput().getText(), newValue.getData());
                    getMylist().add(new SongList(name, InsertElementManage.getIdInput().getText(), insertType));
                    msg(InsertMainWindow.getInsert());
                    File file = CreatFileUtils.writeDataPath();
                    try {
                        FileWriter fileWriter = new FileWriter(file, StandardCharsets.UTF_8, true);
                        PrintWriter printWriter = new PrintWriter(fileWriter);
                        Object toJSON = JSON.toJSON(new SongList(name, InsertElementManage.getIdInput().getText(), insertType));
                        printWriter.println(toJSON + "&");
                        printWriter.close();
                        fileWriter.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    new NotificationUtils(MainWindow.getMainWindow()).showDefaultMsg("歌单里没有歌", "");
                }

            }
        });

        insertList.stateProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals(Worker.State.SUCCEEDED)) {
                insertList.reset();
            }
        });
        return insertClicked;
    }

    public static void msg(Stage primaryStage) {
        new NotificationUtils(MainWindow.getMainWindow()).showDefaultMsg("添加成功", "");
        primaryStage.close();
    }

    public static void alert() {
        new NotificationUtils(MainWindow.getMainWindow()).showDefaultMsg("无法获取此歌单", "");
    }

    public static EventHandler<MouseEvent> getMouseEntered() {
        if (mouseEntered == null) {
            mouseEntered = new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (InsertElementManage.getIdInput().getText().length() < 3) {
                        InsertElementManage.getInsertButton().setDisable(true);
                    }
                }
            };
        }
        return mouseEntered;
    }

    public static EventHandler<ActionEvent> getCloseClicked() {
        if (closeClicked == null) {
            closeClicked = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    InsertMainWindow.getInsert().close();
                }
            };
        }
        return closeClicked;
    }
}
