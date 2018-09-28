package sample;

import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {

    StageManager stageManager = new StageManager();
    ObjectManager objectManager = new ObjectManager();

    @Override
    public void start(Stage primaryStage) throws Exception {

        stageManager.addStage("loginStage","loginWindow.fxml",700,700);
        stageManager.getStage("loginStage").show();
        stageManager.addStage("keyboardStage","keyboard.fxml",250,250);
//        objectManager.add("password",stageManager.loadStage("loginWindow.fxml"));
//        objectManager.add("submit",stageManager.loadStage("keyboard.fxml"));

    }


    public static void main(String[] args) {
        launch(args);
    }

}