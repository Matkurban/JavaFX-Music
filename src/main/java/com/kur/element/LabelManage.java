package com.kur.element;

import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class LabelManage {

    private static Label start;
    private static Label end;
    private static Label songNameLabel;


    public static Label getStartLabel() {
        if (start == null) {
            start = new Label("00:00");
            start.setFont(Font.font(20));
        }
        return start;
    }

    public static Label getEndLabel() {
        if (end == null) {
            end = new Label("00:00");
            end.setFont(Font.font(20));
        }
        return end;
    }

    public static Label getSongNameLabel() {
        if (songNameLabel == null) {
            songNameLabel = new Label();

            songNameLabel.setId("songNameLabel");
        }
        return songNameLabel;
    }
}
