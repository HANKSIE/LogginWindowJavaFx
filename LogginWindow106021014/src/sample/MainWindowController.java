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

    @FXML private MenuItem play, close, record, encrypt;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        play.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //打開遊戲視窗
                StageManager.getStage("ooxxStage").show();
                //隱藏主要視窗
                StageManager.getStage("mainWindowStage").hide();
            }
        });

        close.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //關閉主視窗
                StageManager.getStage("mainWindowStage").close();
                //隱藏主要視窗
                StageManager.getStage("mainWindowStage").hide();
            }
        });

        record.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //顯示紀錄視窗
                StageManager.getStage("recordStage").show();
                //隱藏主要視窗
                StageManager.getStage("mainWindowStage").hide();
            }
        });

        encrypt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                StageManager.getStage("encryptStage").show();
                //隱藏主要視窗
                StageManager.getStage("mainWindowStage").hide();
            }
        });

    }

}
