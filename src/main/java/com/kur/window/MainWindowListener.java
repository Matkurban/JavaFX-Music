package com.kur.window;

import com.kur.element.ElementManage;
import com.kur.element.ListViewManage;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class MainWindowListener {

    private static ChangeListener<Number> widthProperty;
    private static ChangeListener<Number> heightProperty;

    private static ChangeListener<Boolean> focusProperty;

    public static ChangeListener<Number> getWidthProperty() {
        if (widthProperty == null) {
            widthProperty = new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
                    ListViewManage.getLyricsView().setMinWidth(newValue.doubleValue() - 604);
                    ElementManage.getProgressBar().setPrefWidth(newValue.doubleValue() - 200);
                }
            };
        }
        return widthProperty;
    }

    public static ChangeListener<Number> getHeightProperty() {
        if (heightProperty == null) {
            heightProperty = new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
                    ListViewManage.getSongView().setPrefHeight(newValue.doubleValue() - 72);
                    ListViewManage.getLyricsView().setMinHeight(newValue.doubleValue() - 150);
                }
            };
        }
        return heightProperty;
    }

    public static ChangeListener<Boolean> getFocusProperty() {
        if (focusProperty == null) {
            focusProperty = new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (newValue) {
                        ListViewManage.getSongView().requestFocus();
                    }
                }
            };
        }
        return focusProperty;
    }

}
