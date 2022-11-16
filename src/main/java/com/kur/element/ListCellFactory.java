package com.kur.element;


import com.kur.entity.Song;
import com.kur.entity.SongPic;
import com.kur.pojo.SongList;
import com.kur.utils.DownloadUtils;
import com.kur.utils.NotificationUtils;
import com.kur.window.MainWindow;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.text.Font;
import javafx.util.Callback;

import java.io.File;

import static com.kur.app.ImportantParameters.getClient;
import static com.kur.app.ImportantParameters.key;

public class ListCellFactory {

    private static Callback<ListView<Song>, ListCell<Song>> songCallBack;

    private static SongPic result;
    private static int ready = 0;

    //歌单
    private static Callback<ListView<SongList>, ListCell<SongList>> playlistCallBack;

    public static Callback<ListView<Song>, ListCell<Song>> getSongCallBack() {
        if (songCallBack == null) {
            File file = new File(new File("").getAbsolutePath() + File.separator + "download");
            if (!file.exists()) {
                file.mkdirs();
            }
            Region download = new Region();
            download.setId("download");
            songCallBack = new Callback<ListView<Song>, ListCell<Song>>() {
                @Override
                public ListCell<Song> call(ListView<Song> songListView) {
                    return new ListCell<>() {
                        @Override
                        protected void updateItem(Song item, boolean empty) {
                            super.updateItem(item, empty);
                            if (!empty) {
                                AnchorPane pane = new AnchorPane();
                                HBox cellHBox = new HBox();
                                Label name = new Label();
                                name.setFont(Font.font(16));
                                name.setPrefWidth(200);
                                name.setMaxWidth(200);
                                Label artist = new Label();
                                artist.setFont(Font.font(14));
                                artist.setPrefWidth(130);
                                artist.setMaxWidth(130);
                                name.setText(item.getName());
                                artist.setText(item.getArtist());
                                name.setId(item.getId());
                                Button downloadButton = new Button();
                                Region download = new Region();
                                download.setId("download");
                                downloadButton.setGraphic(download);

                                cellHBox.getChildren().addAll(name, artist, downloadButton);
                                cellHBox.setAlignment(Pos.CENTER);
                                setTooltip(new Tooltip(item.getName()));
                                ProgressBar progressBar = new ProgressBar();
                                progressBar.setPrefWidth(340);
                                progressBar.setPrefHeight(40);
                                progressBar.setVisible(false);

                                downloadButton.setOnAction(actionEvent -> {

                                    if (ready < 1) {
                                        new Task<>() {
                                            @Override
                                            protected Object call() {
                                                result = getClient().downloadMp3(key, item.getId(), item.getType());
                                                return null;
                                            }
                                        }.run();
                                        ListViewManage.getSongView().requestFocus();

                                        if (result.getCode() != -1 && result.getData() != null || !result.getData().equals("")) {
                                            DownloadUtils downloadUtils = new DownloadUtils();
                                            downloadUtils.setUrl(result.getData());
                                            downloadUtils.setSaveFile(new File(file + File.separator + item.getName() + ".mp3"));
                                            progressBar.setVisible(true);
                                            downloadUtils.start();
                                            ready++;

                                            downloadUtils.progressProperty().addListener((observableValue, number, t1) -> {
                                                progressBar.setProgress(t1.doubleValue());
                                                if (t1.doubleValue() >= 1) {
                                                    progressBar.setVisible(false);
                                                    ready--;
                                                    new NotificationUtils(MainWindow.getMainWindow()).showDefaultMsg("", "下载完成");
                                                }
                                            });
                                            downloadUtils.stateProperty().addListener((obs, old, xin) -> {
                                                if (xin.equals(Worker.State.SUCCEEDED)) {
                                                    downloadUtils.reset();
                                                }
                                            });
                                        } else {
                                            new NotificationUtils(MainWindow.getMainWindow()).showDefaultMsg("无法下载这首歌", "");
                                        }

                                    } else {
                                        new NotificationUtils(MainWindow.getMainWindow()).showDefaultMsg("", "请稍后!");
                                    }
                                });
                                pane.getChildren().addAll(progressBar, cellHBox);
                                this.setGraphic(pane);

                            } else {
                                this.setGraphic(null);
                            }
                        }
                    };
                }
            };
        }

        return songCallBack;
    }


    public static Callback<ListView<SongList>, ListCell<SongList>> getPlaylistCallBack() {
        if (playlistCallBack == null) {
            playlistCallBack = new Callback<ListView<SongList>, ListCell<SongList>>() {
                @Override
                public ListCell<SongList> call(ListView<SongList> songListListView) {
                    return new ListCell<>() {
                        @Override
                        protected void updateItem(SongList item, boolean empty) {
                            super.updateItem(item, empty);
                            if (!empty && item != null) {
                                Label name = new Label(item.getSonglistname());
                                name.setFont(Font.font(16));
                                name.setId(item.getSonglistid());
                                name.setMaxWidth(175);
                                this.setGraphic(name);
                            }
                        }
                    };
                }
            };
        }
        return playlistCallBack;
    }
}
