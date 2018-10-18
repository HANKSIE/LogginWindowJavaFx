package sample;

import javafx.application.Application;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        //將Stage載入StageManager
        StageManager.addStage("keyboardStage","小鍵盤","keyboard.fxml",225,232);
        StageManager.addStage("loginStage","登入","loginWindow.fxml",500,500);
        StageManager.addStage("mainWindowStage","井字遊戲","mainWindow.fxml",380,400);
        StageManager.addStage("ooxxStage","ooxx","ooxxWindow.fxml",300,300);
        StageManager.addStage("recordStage","record","recordWindow.fxml",300,300);
        StageManager.addStage("encryptStage","encrypt","encrypt.fxml",485,390);

        //設置ooxx視窗的關閉按鈕行為
        StageManager.getStage("ooxxStage").setOnCloseRequest(event -> {
            StageManager.getStage("mainWindowStage").show();
        });

        //顯示登入視窗
        //StageManager.getStage("loginStage").show();
        StageManager.getStage("encryptStage").show();

    }


    public static void main(String[] args) {
        launch(args);
    }

}