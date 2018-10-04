package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.function.Function;

/*========================
小鍵盤視窗的Controller
========================*/

public class KeyboardController implements Initializable {

    @FXML private Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,delete,submit;
    @FXML private Label show;
    private Button btnArr[] = new Button[10];

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
        refresh();

    }

    public void refresh(){

        Random rand = new Random();
        int count = 0;
        boolean flag = false;

        for (int i=0; i<10; i++){
            btnArr[i].setText("");
        }

        while (count != 10){

            int r = rand.nextInt(10);

            for (int i=count; i>=0; i--){
                if (Integer.toString(r).equals(btnArr[i].getText())){
                    flag = false;
                    break;
                }else {
                    flag = true;
                }
            }

            if (flag){
                btnArr[count].setText(Integer.toString(r));
                count++;
            }

        }



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

                PasswordField p = (PasswordField) SaveReference.getReference("password");
                p.setText(show.getText());
                StageManager.getStage("keyboardStage").close();

            }
        });


    }

}
