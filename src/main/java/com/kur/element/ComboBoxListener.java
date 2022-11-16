package com.kur.element;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class ComboBoxListener {
    public static String sourceType = "wy";
    public static String insertType = "wy";
    private static ChangeListener<String> searchListener;
    private static ChangeListener<String> platformListener;

    public static ChangeListener<String> getSearchListener() {
        if (searchListener == null) {
            searchListener = new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                    switch (newValue) {
                        case "qq" -> sourceType = "QQ";
                        case "酷我" -> sourceType = "kw";
                        case "酷狗" -> sourceType = "kg";
                        case "咪咕" -> sourceType = "mg";
                        case "千千" -> sourceType = "qi";
                        default -> sourceType = "wy";
                    }
                }
            };
        }
        return searchListener;
    }

    public static ChangeListener<String> getPlatformListener() {
        if (platformListener == null) {
            platformListener = new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    switch (newValue) {
                        case "网易云音乐" -> insertType = "wy";
                        case "QQ音乐" -> insertType = "qq";
                        case "酷我音乐" -> insertType = "kw";
                        case "酷狗音乐" -> insertType = "kg";
                    }
                }
            };
        }
        return platformListener;
    }

}
