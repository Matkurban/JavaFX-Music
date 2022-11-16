package com.kur.element;

import com.kur.window.MainWindow;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import static com.kur.app.MediaApp.player;

public class ElementEvent {

    private static EventHandler<MouseEvent> progressClicked;
    private static EventHandler<MouseEvent> progressDragged;

    private static EventHandler<ActionEvent> systemTrayEvent;

    public static EventHandler<MouseEvent> getProgressClicked() {
        if (progressClicked == null) {
            progressClicked = new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    player.seek(ElementManage.getProgressBar().getCurrentTime());
                }
            };
        }
        return progressClicked;
    }

    public static EventHandler<MouseEvent> getProgressDragged() {
        if (progressDragged == null) {
            progressDragged = new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    player.seek(ElementManage.getProgressBar().getCurrentTime());
                }
            };
        }
        return progressDragged;
    }

    public static EventHandler<ActionEvent> getSystemTrayEvent() {
        if (systemTrayEvent == null) {
            systemTrayEvent = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    MainWindow.getMainWindow().setIconified(!MainWindow.getMainWindow().isIconified());
                }
            };
        }
        return systemTrayEvent;
    }
}
