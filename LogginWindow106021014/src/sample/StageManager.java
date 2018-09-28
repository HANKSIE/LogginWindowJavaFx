package sample;

import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;
import java.util.HashMap;

public class StageManager {

    static HashMap<String ,Stage> stageArr = new HashMap<String, Stage>();
//    static String message;
//    static boolean messageTransfer = false;
//    static boolean keyboardOpened = false;

//    public void saveMessage(String content){
//        message = content;
//        messageTransfer = true;
//    }

    public void addStage(String name,String resource,int width, int height){
        Stage stage = new Stage();
        Scene scene = new Scene(loadStage(resource),width,height);
        stage.setScene(scene);
        stageArr.put(name,stage);
    }


    public Parent loadStage(String resource) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(resource));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return root;
    }


    public Stage getStage(String name){
        return stageArr.get(name);
    }

    public void deleteStage(String name){
        stageArr.remove(stageArr.get(name));
    }


}
