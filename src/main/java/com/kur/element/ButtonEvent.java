package com.kur.element;

import com.kur.element.close.CloseMain;
import com.kur.service.SourceService;
import com.kur.utils.NotificationUtils;
import com.kur.window.MainWindow;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import static com.kur.app.ImportantParameters.getList;
import static com.kur.app.MediaApp.player;


public class ButtonEvent {

    private static EventHandler<ActionEvent> minEvent;

    private static EventHandler<ActionEvent> maxEvent;
    private static EventHandler<ActionEvent> closeEvent;
    private static EventHandler<ActionEvent> sourceEvent;
    private static EventHandler<MouseEvent> sourceEnteredEvent;
    private static EventHandler<ActionEvent> previousEvent;
    private static EventHandler<ActionEvent> nextEvent;
    private static EventHandler<ActionEvent> controlPlayEvent;
    private static EventHandler<ActionEvent> volumeEvent;


    public static EventHandler<ActionEvent> getMinEvent() {

        if (minEvent == null) {
            minEvent = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    MainWindow.getMainWindow().setIconified(true);
                }
            };
        }
        return minEvent;
    }

    public static EventHandler<ActionEvent> getMaxEvent() {
        if (maxEvent == null) {
            maxEvent = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Stage stage = MainWindow.getMainWindow();
                    stage.setMaximized(!stage.isMaximized());
                    ListViewManage.getSongView().requestFocus();
                }
            };
        }
        return maxEvent;
    }

    public static EventHandler<ActionEvent> getCloseEvent() {
        if (closeEvent == null) {
            closeEvent = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    CloseMain.getCloseStage().show();
                }
            };
        }
        return closeEvent;
    }

    public static EventHandler<ActionEvent> getSourceEvent() {

        SourceService sourceService = new SourceService();

        if (sourceEvent == null) {
            sourceEvent = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {

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
            };

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
        }
        return sourceEvent;
    }

    public static EventHandler<MouseEvent> getSourceEnteredEvent() {
        if (sourceEnteredEvent == null) {
            sourceEnteredEvent = new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (TextFieldManage.getSearchInput().getText().length() < 1) {
                        ButtonManage.getSourceButton().setDisable(true);
                    }
                }
            };
        }

        return sourceEnteredEvent;
    }

    public static EventHandler<ActionEvent> getPreviousEvent() {
        if (previousEvent == null) {
            previousEvent = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    ControlPlay.playPreviousMusic();
                }
            };
        }
        return previousEvent;
    }

    public static EventHandler<ActionEvent> getNextEvent() {
        if (nextEvent == null) {
            nextEvent = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    ControlPlay.playNextMusic();
                }
            };
        }
        return nextEvent;
    }

    public static EventHandler<ActionEvent> getControlPlayEvent() {
        if (controlPlayEvent == null) {
            controlPlayEvent = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    if (player != null) {
                        if (player.getStatus().equals(MediaPlayer.Status.PLAYING)) {
                            player.pause();
                        } else if (player.getStatus().equals(MediaPlayer.Status.PAUSED)) {
                            player.play();
                        }
                    }
                }
            };
        }
        return controlPlayEvent;
    }

    public static EventHandler<ActionEvent> getVolumeEvent() {
        if (volumeEvent == null) {
            volumeEvent = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Bounds bounds = ButtonManage.getVolumeButton().localToScreen(ButtonManage.getVolumeButton().getBoundsInLocal());

                    ElementManage.getVolumeContextMenu().show(MainWindow.getMainWindow(), bounds.getMinX() + 10, bounds.getMinY() - 135);
                }
            };
        }
        return volumeEvent;
    }


}
