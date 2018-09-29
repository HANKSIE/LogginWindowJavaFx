package sample;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        //將Stage載入StageManager
        StageManager.addStage("loginStage","登入","loginWindow.fxml",500,500);
        StageManager.addStage("keyboardStage","小鍵盤","keyboard.fxml",225,232);
        StageManager.addStage("mainWindowStage","井字遊戲","mainWindow.fxml",380,400);
        StageManager.addStage("ooxxStage","ooxx","ooxxWindow.fxml",300,300);
        StageManager.addStage("recordStage","record","recordWindow.fxml",300,300);
        //顯示登入視窗
        StageManager.getStage("loginStage").show();

    }


    public static void main(String[] args) {
        launch(args);
    }

}