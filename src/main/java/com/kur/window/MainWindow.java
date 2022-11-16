package com.kur.window;

import com.kur.layout.MainLayout;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainWindow {
    private static Stage stage;

    public static Stage getMainWindow() {
        if (stage == null) {
            stage = new Stage();
            stage.setHeight(900);
            stage.setWidth(1500);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(getMainScene());
            Image image = new Image("/img/音乐.png");
            stage.getIcons().add(image);
            stage.heightProperty().addListener(MainWindowListener.getHeightProperty());
            stage.widthProperty().addListener(MainWindowListener.getWidthProperty());
            stage.addEventFilter(KeyEvent.KEY_PRESSED, MainWindowEvent.getSpaceEvent());
            stage.addEventFilter(KeyEvent.KEY_PRESSED, MainWindowEvent.getRightEvent());
            stage.addEventFilter(KeyEvent.KEY_PRESSED, MainWindowEvent.getLeftEvent());
            stage.addEventFilter(KeyEvent.KEY_PRESSED, MainWindowEvent.getEscEvent());
            stage.addEventFilter(KeyEvent.KEY_PRESSED, MainWindowEvent.getEnterEvent());
            stage.focusedProperty().addListener(MainWindowListener.getFocusProperty());
        }
        return stage;
    }

    private static Scene getMainScene() {
        Scene scene = new Scene(MainLayout.getHome());
        scene.setFill(Paint.valueOf("1ECD9600"));
        scene.getStylesheets().addAll(
                "/css/slider.css",
                "/css/textFiled.css",
                "/css/All.css",
                "/css/region.css");

        //鼠标按压事件
        scene.setOnMousePressed(MainWindowEvent.getMousePressed());
        //鼠标拖动事件
        scene.setOnMouseDragged(MainWindowEvent.getMouseDragged());
        return scene;
    }
}
