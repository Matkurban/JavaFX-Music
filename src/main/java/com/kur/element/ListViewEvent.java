package com.kur.element;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import static com.kur.app.ImportantParameters.NumberOfPlaybackErrors;

public class ListViewEvent {

    private static EventHandler<MouseEvent> mouseClicked;

    public static EventHandler<MouseEvent> getMouseClicked() {
        if (mouseClicked == null) {
            mouseClicked = new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    NumberOfPlaybackErrors = 0;
                }
            };
        }
        return mouseClicked;
    }
}
