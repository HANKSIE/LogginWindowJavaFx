package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class iTalkServerController implements Initializable {

    @FXML
    private Button serverConnect;

    private Server server = new Server();
    private Thread serverThread = new Thread(server);

    private Alert alert = new Alert(Alert.AlertType.INFORMATION); // 實體化Alert對話框物件，並直接在建構子設定對話框的訊息類型

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        SaveReference.addReference("server",server);
        SaveReference.addReference("serverThread",serverThread);

        serverConnect.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                alert.setTitle("提示"); //設定對話框視窗的標題列文字
                alert.setHeaderText("等待連線中，請稍後.."); //設定對話框視窗裡的標頭文字。若設為空字串，則表示無標頭
                alert.setContentText("按下「確定」按鈕後開始連線"); //設定對話框的訊息文字
                alert.showAndWait(); //顯示對話框，並等待對話框被關閉時才繼續執行之後的程式
                SaveReference.addReference("tip",alert);
                serverThread.start();
                serverConnect.setDisable(true);
            }
        });

    }

}
