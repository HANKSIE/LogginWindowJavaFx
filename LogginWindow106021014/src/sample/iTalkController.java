package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class iTalkController implements Initializable {

    @FXML
    private Button startTalk;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        startTalk.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                StageManager.getStage("iTalkStage").close();
                StageManager.getStage("iTalkPaneStage").show();
                boolean flag = (boolean)SaveReference.getReference("flag");
                flag = true;

            }
        });

    }

}
