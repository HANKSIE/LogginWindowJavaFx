package sample;

import javafx.scene.Node;
import javafx.scene.Parent;
import java.util.HashMap;

public class ObjectManager{

    static HashMap<String, Parent> parentArr = new HashMap<String, Parent>();

    public void add(String name,Parent p){
        parentArr.put(name, p);
    }

    public Node getComp(String name){

        return parentArr.get(name).lookup("#"+name);
    }

}
