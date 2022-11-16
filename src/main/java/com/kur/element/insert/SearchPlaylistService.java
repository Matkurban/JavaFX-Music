package com.kur.element.insert;

import com.kur.entity.Results;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

import static com.kur.app.ImportantParameters.getClient;
import static com.kur.app.ImportantParameters.key;
import static com.kur.element.ComboBoxListener.insertType;

public class SearchPlaylistService extends Service<Results> {
    @Override
    protected Task<Results> createTask() {
        return new Task<Results>() {
            @Override
            protected Results call() throws Exception {
                return getClient().insertSongList(key, InsertElementManage.getIdInput().getText(), insertType);
            }
        };
    }
}
