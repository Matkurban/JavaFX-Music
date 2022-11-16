package com.kur.element.insert;

import com.kur.element.ComboBoxManage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;

public class InsertMainLayout {

    public static Scene getScene() {
        Scene scene = new Scene(getHome());
        scene.setFill(Paint.valueOf("FFFFFF00"));
        scene.getStylesheets().add("/css/insertHome.css");
        return scene;
    }

    private static VBox getHome() {
        VBox home = new VBox();
        home.setId("insertHome");
        home.getChildren().addAll(getTop(), InsertElementManage.getIdInput(), ComboBoxManage.getPlatformComboBox(), getBottom(), getSpinnerPane());
        return home;
    }

    private static HBox getTop() {
        HBox top = new HBox();
        top.setAlignment(Pos.CENTER_RIGHT);
        top.getChildren().add(InsertElementManage.getClose());
        return top;
    }

    private static HBox getBottom() {
        HBox bottom = new HBox();
        bottom.getChildren().add(InsertElementManage.getInsertButton());
        bottom.setAlignment(Pos.CENTER_RIGHT);
        return bottom;
    }

    private static AnchorPane getSpinnerPane() {
        AnchorPane anchorPane = new AnchorPane(InsertElementManage.getSpinner());
        AnchorPane.setLeftAnchor(InsertElementManage.getSpinner(), 90.0);
        return anchorPane;
    }
}
