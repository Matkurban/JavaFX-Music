package com.kur.element;

import com.kur.entity.Song;
import com.kur.pojo.SongList;
import com.leewyatt.rxcontrols.controls.RXLrcView;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import static com.kur.app.ImportantParameters.getList;
import static com.kur.app.ImportantParameters.getMylist;

public class ListViewManage {

    private static ListView<Song> listView;

    private static ListView<SongList> playlistView;
    private static RXLrcView lrcView;

    public static ListView<Song> getSongView() {
        if (listView == null) {
            listView = new ListView<>();
            listView.setItems(getList());
            listView.setPrefWidth(404);
            listView.setMinWidth(404);
            listView.setPrefHeight(816);
            listView.setCellFactory(ListCellFactory.getSongCallBack());
            listView.setOnMouseClicked(ListViewEvent.getMouseClicked());
            listView.getStylesheets().add("/css/listView.css");
        }
        return listView;
    }

    public static ListView<SongList> getMylistView() {
        if (playlistView == null) {
            playlistView = new ListView<>();
            playlistView.setItems(getMylist());
            playlistView.setPrefHeight(800);
            playlistView.setPrefWidth(200);
            playlistView.setCellFactory(ListCellFactory.getPlaylistCallBack());
            playlistView.getSelectionModel().getSelectedItems().addListener(ListViewListener.getPlaylistViewListener());
            playlistView.addEventFilter(MouseEvent.MOUSE_CLICKED, ListViewListener.getPlaylistEvent());
            playlistView.getStylesheets().add("/css/listView.css");
        }
        return playlistView;
    }

    //歌词
    public static RXLrcView getLyricsView() {
        if (lrcView == null) {
            lrcView = new RXLrcView();
            lrcView.setTipString("");
        }
        lrcView.setId("lrcView");
        lrcView.setPrefWidth(890);
        lrcView.setPrefHeight(750);
        lrcView.setOnMouseClicked(event -> ListViewManage.getSongView().requestFocus());
        return lrcView;
    }
}
