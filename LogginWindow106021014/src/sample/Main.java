package sample;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

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
        StageManager.getStage("mainWindowStage").show();

    }

    public void onCloseSet(String stageName){ //設定叉叉按鈕
        StageManager.getStage("mainWindowStage").show();
        StageManager.getStage(stageName).close();
    }

    public static void main(String[] args) {
        launch(args);
    }

}