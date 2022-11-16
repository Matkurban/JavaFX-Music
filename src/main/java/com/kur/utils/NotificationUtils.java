package com.kur.utils;

import io.github.palexdev.materialfx.enums.NotificationPos;
import io.github.palexdev.materialfx.notifications.MFXNotificationSystem;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;

public class NotificationUtils {

    private final MFXNotificationSystem notificationSystem;
    private final MyNotification notification;
    private final Label title;
    private final Label text;

    public NotificationUtils(Stage initOwner) {

        notificationSystem = MFXNotificationSystem.instance();
        notificationSystem.initOwner(initOwner);
        notificationSystem.setPosition(NotificationPos.BOTTOM_RIGHT);
        notification = new MyNotification();
        title = new Label();
        title.setFont(Font.font(24));
        text = new Label();
        text.setFont(Font.font(18));
        VBox root = new VBox(title, text);
        root.setId("root");
        root.getStylesheets().add("/css/root.css");
        notification.setContent(root);
        notificationSystem.setCloseAfter(Duration.seconds(0.5));
    }

    public void showNotification() {
        MFXNotificationSystem.instance().publish(notification);
        play();
    }

    public void setAfterClose(Duration afterClose) {
        notificationSystem.setCloseAfter(afterClose);
    }

    public void play() {
        URL url = this.getClass().getResource("/mp/提示音.wav");
        Media media = new Media(url.toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }

    public void showDefaultMsg(String title, String text) {
        setTitle(title);
        setText(text);
        showNotification();
    }


    public void setContent(Region content) {
        notification.setContent(content);
    }

    public String getTitle() {
        return title.getText();
    }

    public void setTitle(String title) {
        this.title.setText(title);
    }

    public String getText() {
        return text.getText();
    }

    public void setText(String text) {
        this.text.setText(text);
    }

    public void setTitleFontSize(Font fontSize) {
        title.setFont(fontSize);

    }

    public void setTextFontSize(Font fontSize) {
        text.setFont(fontSize);
    }


}
