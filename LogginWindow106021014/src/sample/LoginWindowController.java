package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

/*========================
登入視窗的Controller
========================*/

public class LoginWindowController implements Initializable {

    @FXML Button login, exit;
    @FXML TextField account;
    @FXML PasswordField password;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                StageManager.stageArr.get("keyboardStage").show();
                SaveReference.addReference("password",password);
                SaveReference.addReference("login",login);
                login.setDisable(true);
            }
        });

        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });

    }

}
