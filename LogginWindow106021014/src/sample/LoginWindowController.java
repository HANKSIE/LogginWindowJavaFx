package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.WindowEvent;

import javax.swing.*;
import java.awt.*;
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
                //將Main中取得的keyboardStage刪掉
                StageManager.deleteStage("keyboardStage");
                //重新增加一個keyboardStage
                StageManager.addStage("keyboardStage","小鍵盤","keyboard.fxml",225,232);
                //取得並顯示出keyboardStage
                StageManager.getStage("keyboardStage").show();
                //將password物件參考值傳給SaveReference中的objArr
                SaveReference.addReference("password",password);
            }
        });

        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                //如果密碼&帳號輸入正確
                if (password.getText().equals("520520") && account.getText().equals("hello@gmail.com")){
                    //顯示主視窗
                    StageManager.getStage("mainWindowStage").show();
                    //關掉登入視窗
                    StageManager.getStage("loginStage").close();
                }else {
                    //彈出警告視窗
                    JOptionPane.showMessageDialog(null, "帳號錯誤或密碼錯誤", "警告", JOptionPane.INFORMATION_MESSAGE );
                }

            }
        });

        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //關掉整個程式
                System.exit(0);
            }
        });


    }

}
