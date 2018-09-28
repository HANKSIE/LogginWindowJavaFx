package sample;

import java.util.HashMap;

/*========================
管理Reference的static類別
========================*/

public class SaveReference{

    static HashMap<String, Object> objArr = new HashMap<String, Object> ();

    public static void addReference(String name, Object obj){
        objArr.put(name, obj);
    }

    public static Object getReference(String name){
        return objArr.get(name);
    }

}