package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Stream;

public class LoginWindowController implements Initializable {

    @FXML Button login, exit;
    @FXML TextField account;
    @FXML PasswordField password;
    StageManager stageManager = new StageManager();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stageManager.getStage("keyboardStage").show();
                login.setDisable(true);
            }
        });
    }

}
