package com.kur.window;

import com.kur.element.TextFieldManage;
import com.kur.service.SourceService;
import com.kur.utils.NotificationUtils;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.event.EventHandler;
import javafx.scene.input.*;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import static com.kur.app.ImportantParameters.getList;
import static com.kur.app.MediaApp.player;

public class MainWindowEvent {

    private static EventHandler<KeyEvent> spaceEvent;
    private static EventHandler<KeyEvent> rightEvent;
    private static EventHandler<KeyEvent> leftEvent;
    private static EventHandler<KeyEvent> escEvent;
    private static EventHandler<KeyEvent> enterEvent;

    private static double x = 0;
    private static double y = 0;
    private static EventHandler<MouseEvent> mousePressed;
    private static EventHandler<MouseEvent> mouseDragged;

    public static EventHandler<KeyEvent> getSpaceEvent() {
        KeyCombination space = new KeyCodeCombination(KeyCode.SPACE);
        if (spaceEvent == null) {
            spaceEvent = keyEvent -> {
                if (space.match(keyEvent)) {
                    if (player != null) {
                        if (player.getStatus().equals(MediaPlayer.Status.PLAYING)) {
                            player.pause();
                        } else {
                            player.play();
                        }
                    }
                }
            };
        }
        return spaceEvent;
    }

    public static EventHandler<KeyEvent> getRightEvent() {
        KeyCombination right = new KeyCodeCombination(KeyCode.RIGHT);
        if (rightEvent == null) {
            rightEvent = keyEvent -> {
                if (right.match(keyEvent)) {
                    if (player != null) {
                        player.seek(Duration.seconds(player.getCurrentTime().toSeconds() + 5));
                    }
                }
            };
        }
        return rightEvent;
    }

    public static EventHandler<KeyEvent> getLeftEvent() {
        KeyCombination left = new KeyCodeCombination(KeyCode.LEFT);
        if (leftEvent == null) {
            leftEvent = new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    if (left.match(keyEvent)) {
                        if (player != null) {
                            if (player.getCurrentTime().toSeconds() > 5) {
                                player.seek(Duration.seconds(player.getCurrentTime().toSeconds() - 5));
                            } else {
                                player.seek(Duration.seconds(player.getCurrentTime().toSeconds() - player.getCurrentTime().toSeconds()));
                            }
                        }
                    }
                }
            };
        }
        return leftEvent;
    }

    public static EventHandler<KeyEvent> getEscEvent() {
        KeyCombination esc = new KeyCodeCombination(KeyCode.ESCAPE);
        if (escEvent == null) {
            escEvent = new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    if (esc.match(keyEvent)) {
                        if (MainWindow.getMainWindow().isMaximized()) {
                            MainWindow.getMainWindow().setMaximized(false);
                        }
                    }
                }
            };
        }
        return escEvent;
    }

    public static EventHandler<KeyEvent> getEnterEvent() {
        KeyCombination enter = new KeyCodeCombination(KeyCode.ENTER);
        SourceService sourceService = new SourceService();
        if (enterEvent == null) {
            enterEvent = new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {
                    if (enter.match(event)) {

                        if (TextFieldManage.getSearchInput().getText().length() < 1) {
                            new NotificationUtils(MainWindow.getMainWindow()).showDefaultMsg("请输入内容后再进行搜索", "");
                        } else {
                            if (sourceService.getState().equals(Worker.State.RUNNING) || sourceService.getState().equals(Worker.State.FAILED) || sourceService.getState().equals(Worker.State.SCHEDULED)) {
                                sourceService.restart();
                            } else {
                                sourceService.start();
                            }
                        }
                    }
                }
            };
        }
        sourceService.valueProperty().addListener((ob, ov, nv) -> {
            if (nv != null && nv.getCode() != -1) {
                getList().clear();
                getList().addAll(nv.getData());
                new NotificationUtils(MainWindow.getMainWindow()).showDefaultMsg("搜索成功", "总共搜索到 " + getList().size() + " 首歌");
            }
        });

        sourceService.stateProperty().addListener(new ChangeListener<Worker.State>() {
            @Override
            public void changed(ObservableValue<? extends Worker.State> observableValue, Worker.State oldValue, Worker.State newValue) {
                if (newValue.equals(Worker.State.SUCCEEDED)) {
                    sourceService.reset();
                }
            }
        });
        return enterEvent;
    }

    public static EventHandler<MouseEvent> getMousePressed() {
        if (mousePressed == null) {
            mousePressed = new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    x = event.getScreenX() - MainWindow.getMainWindow().getX();
                    y = event.getScreenY() - MainWindow.getMainWindow().getY();
                }
            };
        }
        return mousePressed;
    }

    public static EventHandler<MouseEvent> getMouseDragged() {
        if (mouseDragged == null) {
            mouseDragged = new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    MainWindow.getMainWindow().setX(event.getScreenX() - x);
                    MainWindow.getMainWindow().setY(event.getScreenY() - y);
                }
            };
        }
        return mouseDragged;
    }
}
