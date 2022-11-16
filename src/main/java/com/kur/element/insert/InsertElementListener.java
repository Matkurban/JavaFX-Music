package com.kur.element.insert;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class InsertElementListener {
    private static ChangeListener<String> idProperty;

    public static ChangeListener<String> getIdProperty() {
        if (idProperty == null) {
            idProperty = new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    if (newValue.length() > 1) {
                        InsertElementManage.getInsertButton().setDisable(false);
                    }
                }
            };
        }
        return idProperty;
    }


}
