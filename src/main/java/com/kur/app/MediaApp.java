package com.kur.app;

import com.kur.element.*;
import com.kur.entity.Song;
import com.kur.entity.SongMsg;
import com.kur.utils.LoadUtils;
import com.kur.utils.NotificationUtils;
import com.kur.window.MainWindow;
import com.leewyatt.rxcontrols.pojo.LrcDoc;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ListChangeListener;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;

import static com.kur.app.ImportantParameters.*;
import static com.kur.element.ControlPlay.disposeMediaPlayer;
import static com.kur.element.ControlPlay.playNextMusic;

public class MediaApp extends Application {
    public static MediaPlayer player;

    @Override
    public void start(Stage primaryStage) {
        Stage mainWindow = MainWindow.getMainWindow();
        mainWindow.show();

        SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss");

        Platform.setImplicitExit(true);
        //根据监听选择歌单时
        Service<SongMsg> songMsgService = new Service<>() {
            @Override
            protected Task<SongMsg> createTask() {
                return new Task<>() {
                    @Override
                    protected SongMsg call() {
                        return getClient().getMusic(key, id, type);
                    }
                };
            }
        };
        songMsgService.stateProperty().addListener((observableValue, state, t1) -> {
            if (t1.equals(Worker.State.SUCCEEDED)) {
                songMsgService.reset();
            }
        });

        ListViewManage.getSongView().getSelectionModel().getSelectedItems().addListener((ListChangeListener<Song>) change -> {
            for (Song s : change.getList()) {
                id = s.getId();
                type = s.getType();

                if (songMsgService.isRunning() || songMsgService.getState().equals(Worker.State.SCHEDULED) || songMsgService.getState().equals(Worker.State.FAILED)) {
                    songMsgService.cancel();
                    songMsgService.reset();
                }
                if (player != null) {
                    player.pause();
                }
                songMsgService.start();
            }
        });

        songMsgService.valueProperty().addListener((ob, ov, nv) -> {
            if (nv != null) {
                if (player != null) {
                    disposeMediaPlayer();
                }
                if (nv.getCode() == 1) {
                    if (nv.getData().getUrl() != null && !"".equals(nv.getData().getUrl())) {
                        NumberOfPlaybackErrors = 0;
                        player = new MediaPlayer(new Media(nv.getData().getUrl()));
                        LabelManage.getSongNameLabel().setText(nv.getData().getName());
                        player.volumeProperty().bind(ElementManage.getVolume().valueProperty());
                        ListViewManage.getLyricsView().setLrcDoc(LrcDoc.parseLrcDoc(nv.getData().getLrc()));
                        ListViewManage.getLyricsView().currentTimeProperty().bind(player.currentTimeProperty());
                        ElementManage.getProgressBar().durationProperty().bind(player.getMedia().durationProperty());
                        player.currentTimeProperty().addListener((observableValue, oldValue, newValue) -> {
                            ElementManage.getProgressBar().setCurrentTime(newValue);
                            LabelManage.getStartLabel().setText(dateFormat.format(newValue.toMillis()));
                        });

                        player.setOnReady(() -> {
                            LabelManage.getEndLabel().setText(dateFormat.format(player.getTotalDuration().toMillis()));
                            player.play();
                        });

                        player.statusProperty().addListener((observableValue, oldValue, newValue) -> {
                            if (newValue.equals(MediaPlayer.Status.PLAYING)) {
                                ButtonManage.getControlPlayButton().setGraphic(RegionManage.getStopRegion());
                            } else if (newValue.equals(MediaPlayer.Status.PAUSED)) {
                                ButtonManage.getControlPlayButton().setGraphic(RegionManage.getPlayRegion());
                            }
                        });
                        player.setOnEndOfMedia(() -> {
                            playNextMusic();
                            NumberOfPlaybackErrors = 0;
                        });

                        player.setOnError(ControlPlay::playNextMusic);
                    } else {

                        if (NumberOfPlaybackErrors <= 4) {
                            NumberOfPlaybackErrors++;
                            songMsgService.restart();
                            playNextMusic();
                            new NotificationUtils(MainWindow.getMainWindow()).showDefaultMsg("错误提示", "无法播放这首歌");
                        }
                    }
                } else {
                    new NotificationUtils(MainWindow.getMainWindow()).showDefaultMsg("错误提示", "请检查你的网络");
                }
            }
        });

        LoadUtils.load();

    }
}
