package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

/*========================
登入視窗的Controller
========================*/

public class LoginWindowController implements Initializable {

    @FXML private Button login, exit;
    @FXML private TextField account;
    @FXML private PasswordField password;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        password.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                StageManager.getStage("keyboardStage").show();
                SaveReference.addReference("password",password);
            }
        });

        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (password.getText().equals("520520") && account.getText().equals("hello@gmail.com")){
                    StageManager.getStage("mainWindowStage").show();
                    account.setText("");
                    password.setText("");
                }else {
                    JOptionPane.showMessageDialog(null, "帳號錯誤或密碼錯誤", "警告", JOptionPane.INFORMATION_MESSAGE );;
                }

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
