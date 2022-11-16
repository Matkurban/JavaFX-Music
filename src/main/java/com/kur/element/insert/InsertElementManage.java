package com.kur.element.insert;

import io.github.palexdev.materialfx.controls.MFXProgressSpinner;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.scene.control.Button;
import javafx.scene.layout.Region;

public class InsertElementManage {
    private static MFXTextField ids;

    private static MFXProgressSpinner spinner;

    public static Button getClose() {
        Button close = new Button();
        Region closeRegion = new Region();
        closeRegion.setId("closeRegion");
        closeRegion.getStylesheets().add("/css/closeRegion.css");
        close.setGraphic(closeRegion);
        close.setOnAction(InsertElementEvent.getCloseClicked());
        close.setStyle("-fx-background-color: null");
        return close;
    }

    public static Button getInsertButton() {
        Button insert = new Button("搜索");
        insert.setId("insert");
        insert.setOnAction(InsertElementEvent.getInsertClicked());
        insert.setOnMouseEntered(InsertElementEvent.getMouseEntered());
        return insert;
    }

    public static MFXTextField getIdInput() {
        if (ids == null) {
            ids = new MFXTextField();
            ids.setFloatingText("请输入歌单id(网易/QQ/酷狗/酷我):");
            ids.setId("ids");
            ids.textProperty().addListener(InsertElementListener.getIdProperty());
        }
        return ids;
    }

    public static MFXProgressSpinner getSpinner() {
        if (spinner == null) {
            spinner = new MFXProgressSpinner();
            spinner.setPrefSize(100, 100);
            spinner.setVisible(false);
        }
        return spinner;
    }
}
