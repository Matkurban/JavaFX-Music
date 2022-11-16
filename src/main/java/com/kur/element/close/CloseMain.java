package com.kur.element.close;

import com.kur.window.MainWindow;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CloseMain {
    private static Stage closeStage;
    private static RadioButton hide;
    private static RadioButton close;

    public static Stage getCloseStage() {

        if (closeStage == null) {
            closeStage = new Stage();
            closeStage.setWidth(300);
            closeStage.setHeight(200);
            closeStage.initOwner(MainWindow.getMainWindow());
            closeStage.initStyle(StageStyle.UTILITY);
            closeStage.initModality(Modality.APPLICATION_MODAL);
            closeStage.setScene(getCloseScene());
        }
        return closeStage;
    }

    private static Scene getCloseScene() {
        Scene closeScene = new Scene(getCloseHome());
        closeScene.getStylesheets().add("/css/dialog.css");
        return closeScene;
    }

    private static VBox getCloseHome() {
        VBox home = new VBox();
        home.setStyle("-fx-background-color: rgba(177,184,190,0.53)");
        home.getChildren().addAll(getRadio(), getBottom());
        home.setAlignment(Pos.CENTER_RIGHT);
        return home;
    }

    private static VBox getRadio() {
        VBox radio = new VBox();
        radio.setMaxWidth(240);
        radio.setMinHeight(120);
        ToggleGroup group = new ToggleGroup();
        getHide().setToggleGroup(group);
        getClose().setToggleGroup(group);
        group.selectToggle(getHide());
        radio.setAlignment(Pos.CENTER_LEFT);
        radio.getChildren().addAll(getHide(), getClose());
        return radio;
    }

    public static RadioButton getHide() {
        if (hide == null) {
            hide = new RadioButton("最小化到系统托盘");
        }
        return hide;
    }

    public static RadioButton getClose() {
        if (close == null) {
            close = new RadioButton("退出音乐播放器");
        }
        return close;
    }


    private static HBox getBottom() {
        HBox bottom = new HBox();
        bottom.setAlignment(Pos.BOTTOM_RIGHT);
        bottom.setSpacing(5);
        bottom.getChildren().addAll(getSure(), getCancel());
        return bottom;
    }

    private static Button getCancel() {
        Button cancel = new Button("取消");
        cancel.setId("cancel");
        cancel.setOnAction(CloseEvent.getCloseEvent());
        return cancel;
    }

    private static Button getSure() {
        Button sure = new Button("确定");
        sure.setOnAction(CloseEvent.getSureEvent());
        sure.setId("sure");
        return sure;
    }
}
