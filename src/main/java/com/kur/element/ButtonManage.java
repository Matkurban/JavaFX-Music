package com.kur.element;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.layout.Region;

public class ButtonManage {
    private static Button controlPlay;
    private static Button volumeButton;

    public static Button getMinButton() {
        Button min = new Button();
        Region minRegion = new Region();
        minRegion.setId("minRegion");
        min.setGraphic(minRegion);
        min.setOnAction(ButtonEvent.getMinEvent());
        return min;
    }

    public static Button getMaxButton() {
        Button max = new Button();
        Region maxRegion = new Region();
        maxRegion.setId("maxRegion");

        Region notMaxRegion = new Region();
        notMaxRegion.setId("notMaxRegion");

        max.setGraphic(notMaxRegion);

        max.setOnAction(ButtonEvent.getMaxEvent());

        return max;

    }

    public static Button getCloseButton() {
        Button close = new Button();
        Region closeRegion = new Region();
        closeRegion.setId("closeRegion");
        close.setGraphic(closeRegion);

        close.setOnAction(ButtonEvent.getCloseEvent());

        return close;
    }


    public static Button getSourceButton() {
        Button sourceButton = new Button();
        Region sourceRegion = new Region();
        sourceRegion.setId("sourceRegion");
        sourceButton.setGraphic(sourceRegion);
        sourceButton.setCursor(Cursor.HAND);

        sourceButton.setOnAction(ButtonEvent.getSourceEvent());

        sourceButton.setOnMouseEntered(ButtonEvent.getSourceEnteredEvent());

        return sourceButton;
    }

    public static Button getPreviousButton() {
        Button previous = new Button();
        Region previousRegion = new Region();
        previousRegion.setId("previousRegion");
        previous.setGraphic(previousRegion);
        previous.setOnAction(ButtonEvent.getPreviousEvent());
        return previous;
    }

    public static Button getNextButton() {
        Button next = new Button();
        Region nextRegion = new Region();
        nextRegion.setId("nextRegion");
        next.setGraphic(nextRegion);
        next.setOnAction(ButtonEvent.getNextEvent());
        return next;
    }

    /**
     * 控制播放按钮
     *
     * @return {@link Button}
     */
    public static Button getControlPlayButton() {
        if (controlPlay == null) {
            controlPlay = new Button();
            controlPlay.setGraphic(RegionManage.getPlayRegion());
            controlPlay.setOnAction(ButtonEvent.getControlPlayEvent());
        }
        return controlPlay;
    }


    /**
     * 获取音量按钮
     *
     * @return {@link Button}
     */
    public static Button getVolumeButton() {
        if (volumeButton == null) {
            volumeButton = new Button();
            Region region = new Region();
            region.setId("region");
            volumeButton.setGraphic(region);
            volumeButton.setOnAction(ButtonEvent.getVolumeEvent());
        }
        return volumeButton;
    }

}
