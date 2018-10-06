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

    @FXML private Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,delete,submit; //亂數鍵盤按鈕0~9
    @FXML private Label show; //顯示文字Label
    private Button btnArr[] = new Button[10]; //儲存btn0~92的Button陣列

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

        setComps(); //設置好元件
        refresh(); //刷新按鈕0~9

    }


    public void refresh(){

        Random rand = new Random();
        int count = 0; //已經設置好的按鈕數量
        boolean flag = false; //判斷和已設定好的按鈕們文字是否相同

        //清空按鈕文字
        for (int i=0; i<10; i++){
            btnArr[i].setText("");
        }

        //隨機生成按鈕文字
        while (count != 10){

            int r = rand.nextInt(10);

            for (int i=count; i>=0; i--){
                //判斷和已設定好的按鈕們文字是否相同
                if (Integer.toString(r).equals(btnArr[i].getText())){
                    flag = false;
                    break;
                }else {
                    flag = true;
                }
            }
            //如果未與設定好的按鈕的文字相同，就讓r當作現在設定的按鈕的文字
            if (flag){
                btnArr[count].setText(Integer.toString(r));
                count++;
            }

        }



    }

    public void setComps() {

        //依序設定0~9按鈕事件
        for (int i = 0; i < btnArr.length; i++) {
            int finalI = i;
            btnArr[i].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    //當這個按鈕被按下，將這個按鈕的文字顯示到顯示標籤
                    show.setText(show.getText() + btnArr[finalI].getText());
                }
            });
        }
        //Backspace鍵功能
        delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String str = show.getText();
                char charArr[]= new char[str.length()];

                //把文字從字源陣列取出
                for (int i=0; i<str.length(); i++){
                    charArr[i] = str.charAt(i);
                }
                //清空顯示標籤
                show.setText("");
                //將除了字元陣列最後一個文字以外的文字依序放回顯示標籤
                for (int i=0; i<str.length()-1; i++){
                    show.setText(show.getText()+charArr[i]);
                }
            }
        });
        //提交鍵功能
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //取得LoginWindowController的password物件參考值
                PasswordField p = (PasswordField) SaveReference.getReference("password");
                //將password文字設定為顯示標籤文字
                p.setText(show.getText());
                //關掉亂數鍵盤視窗
                StageManager.getStage("keyboardStage").close();

            }
        });


    }

}
