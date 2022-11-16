package com.kur.element.close;

import com.dustinredmond.fxtrayicon.FXTrayIcon;
import com.kur.element.ElementManage;
import com.kur.window.MainWindow;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;


public class CloseEvent {
    private static EventHandler<ActionEvent> closeEvent;
    private static EventHandler<ActionEvent> sureEvent;

    public static EventHandler<ActionEvent> getCloseEvent() {
        if (closeEvent == null) {
            closeEvent = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    CloseMain.getCloseStage().close();
                }
            };
        }
        return closeEvent;
    }

    public static EventHandler<ActionEvent> getSureEvent() {
        if (sureEvent == null) {
            sureEvent = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Stage stage = MainWindow.getMainWindow();
                    FXTrayIcon trayIcon = ElementManage.getTrayIcon();
                    if (CloseMain.getHide().isSelected()) {
                        Platform.setImplicitExit(false);
                        CloseMain.getCloseStage().close();
                        if (trayIcon.isShowing()) {
                            stage.setIconified(true);
                        } else {
                            stage.setIconified(true);
                            trayIcon.show();
                        }
                    } else {
                        CloseMain.getCloseStage().close();
                        stage.close();
                        trayIcon.clear();
                        trayIcon.hide();
                        Platform.exit();
                    }
                }
            };
        }
        return sureEvent;
    }
}
