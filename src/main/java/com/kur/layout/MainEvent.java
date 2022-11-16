package com.kur.layout;

import com.kur.window.MainWindow;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MainEvent {

    private static EventHandler<MouseEvent> maxEvent;

    public static EventHandler<MouseEvent> getMaxEvent() {
        if (maxEvent == null) {
            maxEvent = new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (event.getClickCount() == 2) {
                        MainWindow.getMainWindow().setMaximized(!MainWindow.getMainWindow().isMaximized());
                    }
                }
            };
        }
        return maxEvent;
    }
}
