package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class KeyboardController implements Initializable {

    @FXML Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,delete,submit;
    @FXML Label show;
    Button btnArr[] = new Button[10];
    StageManager stageManager = new StageManager();
    Parent uploadLoginWindowFxml = FXMLLoader.load(getClass().getResource("loginWindow.fxml"));
    PasswordField temp = (PasswordField) uploadLoginWindowFxml.lookup("#password");

    public KeyboardController() throws IOException {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        btnArr[0] = btn0;
        btnArr[1] = btn1;
        btnArr[2] = btn2;
        btnArr[3] = btn3;
        btnArr[4] = btn4;
        btnArr[5] = btn5;
        btnArr[6] = btn6;
        btnArr[7] = btn7;
        btnArr[8] = btn8;
        btnArr[9] = btn9;

        setComps();

    }

    public void setComps() {

        for (int i = 0; i < btnArr.length; i++) {
            int finalI = i;
            btnArr[i].setText(Integer.toString(i));
            btnArr[i].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    show.setText(show.getText() + btnArr[finalI].getText());
                }
            });
        }

        delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String str = show.getText();
                char charArr[]= new char[str.length()];

                for (int i=0; i<str.length(); i++){
                    charArr[i] = str.charAt(i);
                }
                show.setText("");
                for (int i=0; i<str.length()-1; i++){
                    show.setText(show.getText()+charArr[i]);
                }
            }
        });

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                temp.setText(show.getText());
                //System.out.println(temp.getText());
                //show.setText("");
                stageManager.getStage("keyboardStage").close();

            }
        });


    }

}
