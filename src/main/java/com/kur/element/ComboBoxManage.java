package com.kur.element;

import io.github.palexdev.materialfx.controls.legacy.MFXLegacyComboBox;
import javafx.scene.Cursor;

public class ComboBoxManage {

    private static MFXLegacyComboBox<String> sourceComboBox;
    private static MFXLegacyComboBox<String> platformComboBox;
    //平台

    public static MFXLegacyComboBox<String> getSourceComboBox() {
        if (sourceComboBox == null) {
            sourceComboBox = new MFXLegacyComboBox<>();
            sourceComboBox.setPrefWidth(60);
            sourceComboBox.setPrefHeight(40);
            sourceComboBox.getSelectionModel().select(0);
            sourceComboBox.setLineStrokeWidth(0);
            sourceComboBox.setCursor(Cursor.HAND);
            sourceComboBox.setValue("网易");
            sourceComboBox.getItems().add("网易");
            sourceComboBox.getItems().add("QQ");
            sourceComboBox.getItems().add("酷我");
            sourceComboBox.getItems().add("酷狗");
            sourceComboBox.getItems().add("咪咕");
            sourceComboBox.getItems().add("千千");
            sourceComboBox.valueProperty().addListener(ComboBoxListener.getSearchListener());
        }
        return sourceComboBox;
    }

    public static MFXLegacyComboBox<String> getPlatformComboBox() {
        if (platformComboBox == null) {
            platformComboBox = new MFXLegacyComboBox<>();
            platformComboBox.setId("pingTai");
            platformComboBox.setValue("网易云音乐");
            platformComboBox.getItems().add("网易云音乐");
            platformComboBox.getItems().add("QQ音乐");
            platformComboBox.getItems().add("酷我音乐");
            platformComboBox.getItems().add("酷狗音乐");
            platformComboBox.valueProperty().addListener(ComboBoxListener.getPlatformListener());
        }
        return platformComboBox;
    }
}
