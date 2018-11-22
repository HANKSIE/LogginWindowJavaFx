package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;

public class Main extends Application {
    /*=========move的資料=========*/
    private int dir = 1;//一開始是往上跑
    private int value = 5;
    private boolean isStart = false;
    private Timer timer;
    /*============================*/
    /*============================*/

    @Override
    public void start(Stage primaryStage) throws Exception {

        String stageName[] = {"ooxxStage","recordStage","encryptStage","fileHandleStage","timingStage","moveStage"};

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
        StageManager.addStage("multipleObjectStage","multipleObject","multipleObject.fxml",600,400);


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




        setMoveWindowKeyEvent();

        setMutipleKeyEvent();
        //顯示登入視窗
//        StageManager.getStage("mainWindowStage").show();

        StageManager.getStage("multipleObjectStage").show();



    }

    public void setMutipleKeyEvent(){
        Scene thisScene = StageManager.getStage("multipleObjectStage").getScene();
        AnchorPane anchorPane = (AnchorPane) thisScene.lookup("#anchorPane");
        thisScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)){
                    Character newChar = new Character("white",50,50);
                    Thread newThread = new Thread(newChar);
                    newThread.start();
                    anchorPane.getChildren().add(newChar);
                }
            }
        });
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

                System.out.println("X:"+obj.getLayoutX()+",Y:"+obj.getLayoutY());
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

class Character extends Label implements Runnable{

    private Character thisCharacter = this;
    private Timer timer;
    private Random rand = new Random();
    private int value = 20;
    private int dir;

   public Character(String backgroundColor, double width, double height){

       this.setStyle(" -fx-background-color:white; ");
       this.setText("hello");
       this.setLayoutX(rand.nextInt(500));
       this.setLayoutY(rand.nextInt(300));
       this.setPrefSize(width,height);

       timer = new Timer(100, new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {

               dir = rand.nextInt(4);
               timer.setDelay((rand.nextInt(10)+1)*100);

               switch (dir){
                   case 0: //上
                       if (thisCharacter.getLayoutY() - value > 0){
                           thisCharacter.setLayoutY(thisCharacter.getLayoutY()-value);
                       }
                       break;
                   case 1: //下
                       if ( (thisCharacter.getLayoutY() + thisCharacter.getHeight()) + value < 400){
                           thisCharacter.setLayoutY(thisCharacter.getLayoutY()+value);
                       }
                       break;
                   case 2: //左
                       if (thisCharacter.getLayoutX() - value > 0){
                           thisCharacter.setLayoutX(thisCharacter.getLayoutX()-value);
                       }
                       break;
                   case 3: //右
                       if ( (thisCharacter.getLayoutX()+thisCharacter.getWidth() ) + value < 600){
                           thisCharacter.setLayoutX(thisCharacter.getLayoutX()+value);
                       }
                       break;
               }

           }
       });

   }



    @Override
    public void run() {
       timer.start();
    }
}