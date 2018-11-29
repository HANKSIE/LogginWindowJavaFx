package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class iTalkPaneController implements Initializable {

    @FXML
    private Button putMessage,getInfo;
    @FXML
    private TextField message;
    @FXML
    private TextArea talkArea;

    private ServerSocket server;
    private boolean flag = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        SaveReference.addReference("flag",flag);


        if (flag){
            String str = "Hello World";

            try {
                server = new ServerSocket(2525);
                System.out.println("與用戶端連線中...");
                Socket s = server.accept();
                System.out.println("連接上用戶端...");
                System.out.println("用戶端的ip位址:"+s.getInetAddress());
                OutputStream out = s.getOutputStream();
                out.write(str.getBytes());
                out.close();
                s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
