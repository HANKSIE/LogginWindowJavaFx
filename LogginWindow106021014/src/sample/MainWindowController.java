package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

import java.net.URL;
import java.util.ResourceBundle;

/*========================
主要視窗的Controller
========================*/


public class MainWindowController implements Initializable {

    @FXML private MenuItem ooxx, close, record, encrypt,move,timing,fileHandle;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        move.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        timing.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                openWindow("timingStage");
            }
        });

        ooxx.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                openWindow("ooxxStage");
            }
        });

        close.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               System.exit(0);
            }
        });

        record.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                openWindow("recordStage");
            }
        });

        encrypt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                openWindow("encryptStage");
            }
        });

        fileHandle.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                openWindow("fileHandleStage");
            }
        });

    }

    private void openWindow(String stageName){
        StageManager.getStage(stageName).show();
        //隱藏主要視窗
        StageManager.getStage("mainWindowStage").hide();
    }

}
