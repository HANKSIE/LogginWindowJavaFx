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

    @FXML private MenuItem play, close, record;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        play.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                StageManager.getStage("ooxxStage").show();
                StageManager.getStage("mainWindowStage").hide();
            }
        });

        close.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                StageManager.getStage("mainWindowStage").close();
            }
        });

        record.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                StageManager.getStage("recordStage").show();
            }
        });

    }

}
