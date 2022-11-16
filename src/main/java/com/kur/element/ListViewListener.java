package com.kur.element;

import com.kur.entity.DataBean;
import com.kur.entity.Song;
import com.kur.pojo.SongList;
import com.kur.utils.NotificationUtils;
import com.kur.window.MainWindow;
import javafx.application.Platform;
import javafx.collections.ListChangeListener;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import static com.kur.app.ImportantParameters.getList;
import static com.kur.app.ImportantParameters.getMap;


public class ListViewListener {

    public static SongList songList;
    private static ListChangeListener<SongList> playlistViewListener;
    private static EventHandler<MouseEvent> playlistEvent;

    public static ListChangeListener<SongList> getPlaylistViewListener() {
        if (playlistViewListener == null) {
            playlistViewListener = new ListChangeListener<SongList>() {
                @Override
                public void onChanged(Change<? extends SongList> change) {
                    for (SongList listed : change.getList()) {
                        songList = listed;
                    }
                }
            };
        }
        return playlistViewListener;
    }

    public static EventHandler<MouseEvent> getPlaylistEvent() {
        if (playlistEvent == null) {
            playlistEvent = new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    Platform.runLater(() -> {
                        getList().clear();
                        ListViewManage.getSongView().refresh();
                        DataBean dataBean = getMap().get(songList.getSonglistid());
                        if (dataBean != null) {
                            String[] songId = dataBean.getSongId();
                            String[] name = dataBean.getSongName();
                            String[] albumName = dataBean.getAlbumName();
                            String[] artistName = dataBean.getArtistName();
                            String[] type = dataBean.getType();
                            for (int i = 0; i < dataBean.getSongId().length; i++) {
                                getList().add(new Song(type[i], songId[i], name[i], albumName[i], artistName[i]));
                            }
                        } else {
                            new NotificationUtils(MainWindow.getMainWindow()).showDefaultMsg("歌单里没有歌", "");
                        }
                    });
                }
            };
        }

        return playlistEvent;
    }
}
