package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class iTalkPaneServerController implements Initializable {

    @FXML
    private Button putMessage,getInfo,exit;
    @FXML
    private TextArea talkArea,message;

    private Server server = (Server)SaveReference.getReference("server");

//    private Client client = (Client) SaveReference.getReference("client");
    private SendMessage send = (SendMessage) SaveReference.getReference("send");

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        SaveReference.addReference("talkArea",talkArea);
        SaveReference.addReference("message",message);
        SaveReference.addReference("exit",exit);

        putMessage.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                send.isCanSend(true);
                talkArea.setText(talkArea.getText()+"\n"+message.getText());
                message.setText("");
            }
        });

        getInfo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                talkArea.setText(talkArea.getText()+server.getInfo());
            }
        });

        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                server.setReceiveIsConnect(false);
                server.setSendIsConnect(false);
                StageManager.getStage("mainWindowStage").show();
                StageManager.getStage("iTalkPaneServerStage").close();
            }
        });

    }
}

