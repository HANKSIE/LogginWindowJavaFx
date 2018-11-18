package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Main extends Application {
    /*move的資料*/
    private int dir = 1;//一開始是往上跑
    private int value = 5;
    private boolean isStart = false;
    private Timer timer;
    /*=========*/
    @Override
    public void start(Stage primaryStage) throws Exception {

        String stageName[] = {"ooxxStage","recordStage","encryptStage","fileHandleStage","timingStage"};

        //將Stage載入StageManager
        StageManager.addStage("keyboardStage","小鍵盤","keyboard.fxml",225,232);
        StageManager.addStage("loginStage","登入","loginWindow.fxml",500,500);
        StageManager.addStage("mainWindowStage","井字遊戲","mainWindow.fxml",380,400);
        StageManager.addStage("ooxxStage","ooxx","ooxxWindow.fxml",300,300);
        StageManager.addStage("recordStage","record","recordWindow.fxml",300,300);
        StageManager.addStage("encryptStage","encrypt","encrypt.fxml",485,390);
        StageManager.addStage("fileHandleStage","fileHandle","fileHandle.fxml",450,140);
        StageManager.addStage("timingStage","Timing","timing.fxml",600,400);
        StageManager.addStage("moveStage","Move","moveWindow.fxml",600,400);


        //設置視窗的關閉按鈕行為
        for (int i=0; i<stageName.length; i++){
            int finalI = i;
            StageManager.getStage(stageName[i]).setOnCloseRequest(event -> {
                onCloseSet(stageName[finalI]);
            });
        }

        StageManager.getStage("mainWindowStage").setOnCloseRequest(event -> {
            System.exit(0);
        });

        StageManager.getStage("loginStage").setOnCloseRequest(event -> {
            System.exit(0);
        });




        //顯示登入視窗
//        StageManager.getStage("mainWindowStage").show();

        StageManager.getStage("moveStage").show();

        setMoveWindowKeyEvent();

    }

    public void setMoveWindowKeyEvent(){
        Label obj = (Label) StageManager.getStage("moveStage").getScene().lookup("#obj");
        obj.setStyle("-fx-background-image: url(images/傷害物件.png)");
        StageManager.getStage("moveStage").getScene().setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                switch (event.getCode()){

                    case ENTER:
                        System.out.println("enter!");
                        isStart = true;
                        System.out.println("timer啟動!");
                        timer.start();
                        break;
                    case UP:
                        System.out.println("up!");
                        if (isStart){
                            dir = 1;
                        }
                        break;
                    case DOWN:
                        System.out.println("down!");
                        if (isStart){
                            dir = 2;
                        }
                        break;
                    case LEFT:
                        System.out.println("left!");
                        if (isStart){
                            dir = 3;
                        }
                        break;
                    case RIGHT:
                        System.out.println("right!");
                        if (isStart){
                            dir = 4;
                        }
                        break;


                }

            }
        });

        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                switch (dir){
                    case 1:
                        obj.setLayoutY(obj.getLayoutY() - value);
                        break;
                    case 2:
                        obj.setLayoutY(obj.getLayoutY() + value);
                        break;
                    case 3:
                        obj.setLayoutX(obj.getLayoutX() - value);
                        break;
                    case 4:
                        obj.setLayoutX(obj.getLayoutX() + value);
                        break;
                }
            }
        });

    }

    public void onCloseSet(String stageName){ //設定叉叉按鈕
        StageManager.getStage("mainWindowStage").show();
        StageManager.getStage(stageName).close();
    }

    public static void main(String[] args) {
        launch(args);
    }

}