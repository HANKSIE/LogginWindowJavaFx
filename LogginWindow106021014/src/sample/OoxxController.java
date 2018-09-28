package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javax.swing.*;

public class OoxxController { //控制元件行為的類別

    //----------資料成員----------

    @FXML private Button button1,button2,button3,button4,
                 button5,button6,button7,button8,
                 button9,start,oPriority,xPriority;



    private boolean flag = true;
    private boolean choosePriority = false;

    private boolean temp;
    private int winnerFlag = 0;
    private int count = 0;

    private int owinCount, xwinCount, flatCount;

    //==========函式成員==========

    //----------$flag設置----------

    public void set$flag (boolean bool){
        if (bool){
            flag = true;
        }else {
            flag = false;
        }
    }

    public void convert$flag(){ //轉換flag布林值
        flag = !flag;
    }

    public void tempEqual$flag(){
        flag = temp;
    }

    public void $flagEqualTemp(){
        temp = flag;
    }


    //----------玩家先後順序按鈕設置----------

    public void o_Priority(){ //o先開始
        start.setDisable(false);
        dialogWindow("o先開始");
        set$flag(true);
        $flagEqualTemp();
        setAllPriorityDisable();
        $choosePriorityChoosed();
    }

    public void x_Priority(){ //x先開始
        start.setDisable(false);
        dialogWindow("x先開始");
        set$flag(false);
        $flagEqualTemp();
        setAllPriorityDisable();
        $choosePriorityChoosed();
    }

    public void $choosePriorityChoosed(){
        choosePriority = true;
    }

    public void setAllPriorityDisable(){
        oPriority.setDisable(true);
        xPriority.setDisable(true);
    }

    public void priorityValueUsable(){
        oPriority.setDisable(false);
        xPriority.setDisable(false);
    }

    //----------按鈕設置----------

    public void startOnAction(){ //start按鈕的onAction

        start.setDisable(true);

        if(choosePriority){
            init();
            dialogWindow("Game Start!!!");
            addButtonOnAction();
            setAllButtonUsable();
            tempEqual$flag();
        }

    }

    public void exit(){
        StageManager.getStage("ooxxStage").close();
    }

    public void clicked(Button btn){ //被點擊
        setButton(btn);
        count++;
        convert$flag();
        judge();
    }

    public void addButtonOnAction(){
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Button _temp = (Button)event.getSource(); //取得案發地點(哪個按鈕)
                clicked(_temp);
            }
        });
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Button _temp = (Button)event.getSource();
                clicked(_temp);
            }
        });
        button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Button _temp = (Button)event.getSource();
                clicked(_temp);
            }
        });
        button4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Button _temp = (Button)event.getSource();
                clicked(_temp);
            }
        });
        button5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Button _temp = (Button)event.getSource();
                clicked(_temp);
            }
        });
        button6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Button _temp = (Button)event.getSource();
                clicked(_temp);
            }
        });
        button7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Button _temp = (Button)event.getSource();
                clicked(_temp);
            }
        });
        button8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Button _temp = (Button)event.getSource();
                clicked(_temp);
            }
        });
        button9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Button _temp = (Button)event.getSource();
                clicked(_temp);
            }
        });

    }

    public void setButton(Button btn){ //按鈕設置
        setButtonText(btn);
        setButtonDisable(btn);
    }

    public void setButtonText(Button btn){ //設置按鈕文字
        if (flag){
            btn.setText("o");
        }else {
            btn.setText("x");
        }
    }

    public void setButtonDisable(Button btn){ //設定按鈕不可使用
        btn.setDisable(true);
    }

    public void setAllButtonDisable(){ //禁用Button1~Button9
        button1.setDisable(true);
        button2.setDisable(true);
        button3.setDisable(true);
        button4.setDisable(true);
        button5.setDisable(true);
        button6.setDisable(true);
        button7.setDisable(true);
        button8.setDisable(true);
        button9.setDisable(true);
    }

    public void setAllButtonUsable(){ //允許使用Button1~Button9
        button1.setDisable(false);
        button2.setDisable(false);
        button3.setDisable(false);
        button4.setDisable(false);
        button5.setDisable(false);
        button6.setDisable(false);
        button7.setDisable(false);
        button8.setDisable(false);
        button9.setDisable(false);
    }

    //----------winnerFlag設置----------

    public void oWin(){ //o勝利的情況下將winnerFlag設為1
        winnerFlag = 1;
    }

    public void xWin(){ //x勝利的情況下將winnerFlag設為2
        winnerFlag = 2;
    }

    //----------判斷程序&遊戲結束----------

    public void judge(){ //判斷輸贏
        if ((button1.getText() == "o")&(button2.getText() == "o")&(button3.getText() == "o")){
            oWin();
        }else if ((button4.getText() == "o")&(button5.getText() == "o")&(button6.getText() == "o")){
            oWin();
        }else if ((button7.getText() == "o")&(button8.getText() == "o")&(button9.getText() == "o")){
            oWin();
        }else if ((button1.getText() == "o")&(button4.getText() == "o")&(button7.getText() == "o")){
            oWin();
        }else if ((button2.getText() == "o")&(button5.getText() == "o")&(button8.getText() == "o")){
            oWin();
        }else if ((button3.getText() == "o")&(button6.getText() == "o")&(button9.getText() == "o")){
            oWin();
        }else if ((button1.getText() == "o")&(button5.getText() == "o")&(button9.getText() == "o")){
            oWin();
        }else if ((button3.getText() == "o")&(button5.getText() == "o")&(button7.getText() == "o")){
            oWin();
        }else if ((button1.getText() == "x")&(button2.getText() == "x")&(button3.getText() == "x")){
            xWin();
        }else if ((button4.getText() == "x")&(button5.getText() == "x")&(button6.getText() == "x")){
            xWin();
        }else if ((button7.getText() == "x")&(button8.getText() == "x")&(button9.getText() == "x")){
            xWin();
        }else if ((button1.getText() == "x")&(button4.getText() == "x")&(button7.getText() == "x")){
            xWin();
        }else if ((button2.getText() == "x")&(button5.getText() == "x")&(button8.getText() == "x")){
            xWin();
        }else if ((button3.getText() == "x")&(button6.getText() == "x")&(button9.getText() == "x")){
            xWin();
        }else if ((button1.getText() == "x")&(button5.getText() == "x")&(button9.getText() == "x")){
            xWin();
        }else if ((button3.getText() == "x")&(button5.getText() == "x")&(button7.getText() == "x")) {
            xWin();
        }

        showResult();
    }

    public void showResult(){ //設定Label物件showResult的文字

        switch (winnerFlag){
            case 0:
                if (count == 9){
                   endProcess("平手");
                   flatCount++;
                }
                break;
            case 1:
                endProcess("o獲勝!");
                owinCount++;
                break;
            case 2:
                endProcess("x獲勝!");
                xwinCount++;
                break;

        }

        Label oCount = (Label) SaveReference.getReference("owinCount");
        Label xCount = (Label) SaveReference.getReference("xwinCount");
        Label fCount = (Label) SaveReference.getReference("flatCount");

        oCount.setText(owinCount + "次");
        xCount.setText(xwinCount + "次");
        fCount.setText(flatCount + "次");

    }

    public void endProcess(String winnerText){
        setAllButtonDisable();
        priorityValueUsable();
        dialogWindow(winnerText);
    }

    //----------init----------

    public void init(){ //重新開始
        valueInit();
        buttonInit();
    }

    public void valueInit(){ //變數初始化
        count = 0;
        flag = true;
        choosePriority = false;
        winnerFlag = 0;
    }

    public void buttonInit(){ //按鈕初始化
        button1.setText("?");
        button2.setText("?");
        button3.setText("?");
        button4.setText("?");
        button5.setText("?");
        button6.setText("?");
        button7.setText("?");
        button8.setText("?");
        button9.setText("?");
    }

    //----------彈出視窗----------

    public void dialogWindow(String dialogText){
        JOptionPane.showMessageDialog(null,
                dialogText, "", JOptionPane.INFORMATION_MESSAGE);
    }

    //=========================

}
