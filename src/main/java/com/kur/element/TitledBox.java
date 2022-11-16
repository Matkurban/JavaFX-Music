package com.kur.element;

import com.kur.element.insert.InsertMainWindow;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.text.Font;

public class TitledBox {
    public static HBox myPane() {
        Label label = new Label("我的歌单");
        label.setPrefWidth(100);
        label.setFont(Font.font(24));
        Button addSongList = new Button();
        Region addRegion = new Region();
        addRegion.setId("addSongList");
        addSongList.setGraphic(addRegion);

        HBox hBox = new HBox();
        hBox.getChildren().addAll(label, addSongList);
        hBox.setAlignment(Pos.CENTER);

        addSongList.setOnAction(actionEvent -> {
            InsertMainWindow.getInsert().show();
        });
        return hBox;
    }
}
