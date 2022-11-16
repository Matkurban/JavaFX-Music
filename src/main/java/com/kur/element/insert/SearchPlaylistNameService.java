package com.kur.element.insert;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

import static com.kur.app.ImportantParameters.getClient;
import static com.kur.app.ImportantParameters.key;
import static com.kur.element.ComboBoxListener.insertType;

public class SearchPlaylistNameService extends Service<String> {
    @Override
    protected Task<String> createTask() {
        return new Task<String>() {
            @Override
            protected String call() throws Exception {
                return getClient().listName(key, InsertElementManage.getIdInput().getText(), insertType);
            }
        };
    }
}
