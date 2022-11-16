package com.kur.element;

import javafx.scene.layout.Region;

public class RegionManage {

    public static Region getPlayRegion() {
        Region play = new Region();
        play.setId("play");
        return play;
    }

    public static Region getStopRegion() {
        Region stop = new Region();
        stop.setId("stop");
        return stop;
    }
}
