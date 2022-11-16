package com.kur.element;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;


public class TextFieldListener {

    private static ChangeListener<String> sourceListener;

    public static ChangeListener<String> getSourceListener() {
        if (sourceListener == null) {
            sourceListener = new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {

                    if (newValue.trim().length() > 0) {
                        ButtonManage.getSourceButton().setDisable(false);
                    }
                }
            };
        }

        return sourceListener;
    }

}
