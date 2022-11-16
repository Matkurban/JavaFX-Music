package com.kur.element;

import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import org.controlsfx.control.textfield.CustomTextField;


public class TextFieldManage {

    private static CustomTextField textField;
    private static TextField listIdTextField;

    //搜索输入框
    public static CustomTextField getSearchInput() {

        if (textField == null) {

            textField = new CustomTextField();

            HBox rightNode = new HBox(ComboBoxManage.getSourceComboBox(), ButtonManage.getSourceButton());
            rightNode.setAlignment(Pos.CENTER);

            textField.setId("textField");
            textField.setPrefHeight(36);
            textField.setRight(rightNode);

            Tooltip sourceTooltip = new Tooltip("歌名|歌手|专辑");
            textField.setTooltip(sourceTooltip);

            textField.textProperty().addListener(TextFieldListener.getSourceListener());

        }
        return textField;

    }

    public static TextField getListIdTextField() {
        if (listIdTextField == null) {
            listIdTextField = new TextField();
            Tooltip insertTooltip = new Tooltip("请输入歌单ID");
            listIdTextField.setTooltip(insertTooltip);
            listIdTextField.setPrefHeight(40);
            listIdTextField.setMaxWidth(120);
            listIdTextField.setFont(Font.font(18));
        }
        return listIdTextField;
    }

}
