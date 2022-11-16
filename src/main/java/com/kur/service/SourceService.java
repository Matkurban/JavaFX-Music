package com.kur.service;

import com.kur.element.TextFieldManage;
import com.kur.entity.SourceResult;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

import static com.kur.app.ImportantParameters.getClient;
import static com.kur.app.ImportantParameters.key;
import static com.kur.element.ComboBoxListener.sourceType;


public class SourceService extends Service<SourceResult> {
    @Override
    protected Task<SourceResult> createTask() {
        return new Task<SourceResult>() {
            @Override
            protected SourceResult call() throws Exception {
                return getClient().sourceSong(key, TextFieldManage.getSearchInput().getText(), sourceType);
            }
        };
    }
}
