package sample;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        //將Stage載入StageManager
        StageManager.addStage("loginStage","loginWindow.fxml",500,500);
        StageManager.addStage("keyboardStage","keyboard.fxml",225,232);
        StageManager.addStage("mainWindowStage","mainWindow.fxml",250,250);
        //顯示登入視窗
        StageManager.stageArr.get("loginStage").show();


    }


    public static void main(String[] args) {
        launch(args);
    }

}