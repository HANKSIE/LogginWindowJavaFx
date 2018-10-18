package sample;

import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;

/*========================
管理Stage的static類別
========================*/

public class StageManager {

    //利用健值存放Stage
    private static HashMap<String ,Stage> stageArr = new HashMap<String, Stage>();
    private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private static int screenW = screenSize.width;
    private static int screenH = screenSize.height;


    public StageManager(){
        throw new Error("This is a static class");
    }
    
    //加入Stage
    public static void addStage(String name,String title,String resource,int width, int height){

        if (stageArr.containsKey(name)){
            System.out.println("使用了重複的名字");
        }else {

            Stage stage = new Stage();
            stage.setX(screenW/2 - width/2);
            stage.setY(screenH/2 - height/2);
            stage.setResizable(false);
            stage.setTitle(title);
            Scene scene = new Scene(loadStage(resource),width,height);
            stage.setScene(scene);
            stageArr.put(name,stage);

        }

    }
    //載入Stage
    private  static Parent loadStage(String resource) {
        Parent root = null;
        try {
            root = FXMLLoader.load(StageManager.class.getResource(resource));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return root;
    }

    public static Stage getStage(String name){
        return stageArr.get(name);
    }

    public static void deleteStage(String name){
        stageArr.remove(name);
    }

}
