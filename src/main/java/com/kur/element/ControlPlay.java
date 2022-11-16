package com.kur.element;

import javafx.util.Duration;

import static com.kur.app.MediaApp.player;

public class ControlPlay {
    public static void playNextMusic() {
        int size = ListViewManage.getSongView().getItems().size();
        if (size < 2) {
            return;
        }
        int index = ListViewManage.getSongView().getSelectionModel().getSelectedIndex();
        //如果是最后一首歌, 那么下一首歌曲就是播放第一首歌曲
        index = (index == size - 1) ? 0 : index + 1;
        ListViewManage.getSongView().getSelectionModel().select(index);
        ListViewManage.getSongView().requestFocus();
    }

    public static void playPreviousMusic() {
        int size = ListViewManage.getSongView().getItems().size();
        if (size < 2) {
            return;
        }
        int index = ListViewManage.getSongView().getSelectionModel().getSelectedIndex();
        //如果是最后一首歌, 那么下一首歌曲就是播放第一首歌曲
        index = (index == size - 1) ? 0 : index - 1;
        ListViewManage.getSongView().getSelectionModel().select(index);
        ListViewManage.getSongView().requestFocus();
    }

    public static void disposeMediaPlayer() {
        player.stop();
        ListViewManage.getLyricsView().setLrcDoc(null);
        ListViewManage.getLyricsView().currentTimeProperty().unbind();
        ListViewManage.getLyricsView().setCurrentTime(Duration.ZERO);
        player.setAudioSpectrumListener(null);
        LabelManage.getStartLabel().setText("00:00");
        LabelManage.getEndLabel().setText("00:00");
        player.setOnEndOfMedia(null);
        player.dispose();
        player = null;
    }
}
