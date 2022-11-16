package com.kur.element;

import com.dustinredmond.fxtrayicon.FXTrayIcon;
import com.kur.app.MediaApp;
import com.kur.window.MainWindow;
import com.leewyatt.rxcontrols.controls.RXMediaProgressBar;
import javafx.geometry.Orientation;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;

import java.util.Objects;

public class ElementManage {

    private static ContextMenu contextMenu;

    private static Slider volume;
    private static RXMediaProgressBar progressBar;
    private static FXTrayIcon trayIcon;

    public static FXTrayIcon getTrayIcon() {
        if (trayIcon == null) {
            trayIcon = new FXTrayIcon(MainWindow.getMainWindow(), Objects.requireNonNull(MediaApp.class.getResource("/img/音乐.png")));
            trayIcon.setOnAction(ElementEvent.getSystemTrayEvent());
        }
        return trayIcon;
    }

    public static Slider getVolume() {
        if (volume == null) {
            volume = new Slider(0, 1, 0.2);
            volume.setOrientation(Orientation.VERTICAL);
        }
        return volume;
    }

    public static ContextMenu getVolumeContextMenu() {
        if (contextMenu == null) {
            contextMenu = new ContextMenu(new SeparatorMenuItem());
            AnchorPane volumeDialog = new AnchorPane();
            volumeDialog.setPrefWidth(20);
            volumeDialog.setPrefHeight(150);

            volumeDialog.getChildren().add(getVolume());
            contextMenu.getScene().setRoot(volumeDialog);
        }
        return contextMenu;
    }

    public static RXMediaProgressBar getProgressBar() {
        if (progressBar == null) {
            progressBar = new RXMediaProgressBar();
            progressBar.setId("RXMediaProgressBar");
            progressBar.setPrefWidth(1300);

            ElementManage.getProgressBar().setOnMouseClicked(ElementEvent.getProgressClicked());
            ElementManage.getProgressBar().setOnMouseDragged(ElementEvent.getProgressDragged());
        }
        return progressBar;
    }
}
