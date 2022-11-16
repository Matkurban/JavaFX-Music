package com.kur.element.insert;

import com.kur.window.MainWindow;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class InsertMainWindow {

    private static Stage primaryStage;

    public static Stage getInsert() {
        if (primaryStage == null) {
            primaryStage = new Stage();
            primaryStage.setWidth(300);
            primaryStage.setHeight(400);
            primaryStage.setScene(InsertMainLayout.getScene());
            primaryStage.initStyle(StageStyle.TRANSPARENT);
            primaryStage.initOwner(MainWindow.getMainWindow());
            primaryStage.initModality(Modality.APPLICATION_MODAL);
        }

        return primaryStage;
    }
}
