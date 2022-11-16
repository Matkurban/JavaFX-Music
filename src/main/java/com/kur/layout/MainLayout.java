package com.kur.layout;

import com.kur.element.*;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class MainLayout {
    public static BorderPane getHome() {
        BorderPane home = new BorderPane();
        home.setId("home");
        home.setTop(topPane());
        home.setCenter(gridPane());
        home.setBottom(getBottomLayout());
        home.setOnMouseClicked(MainEvent.getMaxEvent());
        return home;
    }

    private static BorderPane topPane() {
        BorderPane topPane = new BorderPane();
        topPane.setRight(getTopButton());
        topPane.setCenter(TextFieldManage.getSearchInput());
        topPane.setLeft(getPlaceholder());
        topPane.setMaxHeight(40);
        return topPane;
    }

    //占位
    private static HBox getPlaceholder() {
        Text text = new Text("");
        text.setFont(Font.font(30));
        HBox hBox = new HBox(text);
        hBox.setPrefWidth(200);
        return hBox;
    }

    private static GridPane gridPane() {
        GridPane gridPane = new GridPane();
        gridPane.setId("gridPane");
        gridPane.add(getPlaylistLayout(), 0, 0);
        gridPane.add(getLrcVBox(), 1, 0);
        gridPane.add(ListViewManage.getSongView(), 2, 0);
        return gridPane;
    }

    private static HBox getBottomLayout() {
        HBox bottomBox = new HBox();
        bottomBox.getChildren().addAll(LabelManage.getStartLabel(), ElementManage.getProgressBar(), LabelManage.getEndLabel(), ButtonManage.getVolumeButton());
        bottomBox.setSpacing(10);
        bottomBox.setAlignment(Pos.CENTER);
        return bottomBox;
    }

    private static VBox getLrcVBox() {
        VBox lrcVBox = new VBox();
        lrcVBox.setId("lrcVBox");
        lrcVBox.getChildren().addAll(LabelManage.getSongNameLabel(), ListViewManage.getLyricsView(), getControlLayout());
        return lrcVBox;
    }

    private static HBox getControlLayout() {
        HBox buttonHBox = new HBox();
        buttonHBox.setAlignment(Pos.CENTER);
        buttonHBox.getChildren().addAll(ButtonManage.getPreviousButton(), ButtonManage.getControlPlayButton(), ButtonManage.getNextButton());
        return buttonHBox;
    }

    private static HBox getTopButton() {
        HBox topButton = new HBox();
        topButton.getChildren().addAll(ButtonManage.getMinButton(), ButtonManage.getMaxButton(), ButtonManage.getCloseButton());
        topButton.setPrefWidth(404);
        topButton.setAlignment(Pos.CENTER_RIGHT);
        return topButton;
    }

    private static VBox getPlaylistLayout() {
        VBox songListBox = new VBox();
        songListBox.setPrefWidth(200);
        songListBox.setMinWidth(200);
        songListBox.setPrefHeight(816);

        songListBox.getChildren().addAll(TitledBox.myPane(), ListViewManage.getMylistView());
        return songListBox;
    }
}
