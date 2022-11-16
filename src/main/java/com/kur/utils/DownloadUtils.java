package com.kur.utils;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadUtils extends Service<Double> {
    private final StringProperty url = new SimpleStringProperty();
    private File saveFile;

    public String getUrl() {
        return url.get();
    }

    public void setUrl(String url) {
        this.url.set(url);
    }

    public File getSaveFile() {
        return saveFile;
    }

    public void setSaveFile(File saveFile) {
        this.saveFile = saveFile;
    }

    protected Task<Double> createTask() {
        final String newLoc = getUrl();
        final File saveFile = getSaveFile();
        return new Task<>() {
            protected Double call() throws Exception {
                HttpURLConnection urlConnection = (HttpURLConnection) new URL(newLoc).openConnection();
                InputStream inputStream = urlConnection.getInputStream();
                FileOutputStream outputStream = new FileOutputStream(saveFile);
                int length = urlConnection.getContentLength();
                int sum;
                long downloadSize = 0;
                double progress = 0;
                byte[] bytes = new byte[4096];
                while ((sum = inputStream.read(bytes)) != -1) {

                    downloadSize += sum;
                    outputStream.write(bytes, 0, sum);
                    this.updateProgress(downloadSize, length);

                }
                inputStream.close();
                outputStream.close();
                return progress;
            }
        };
    }

}
