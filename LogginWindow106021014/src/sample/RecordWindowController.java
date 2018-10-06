package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class RecordWindowController implements Initializable{

    @FXML private Label owinCount, xwinCount, flatCount;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //將owinCount, xwinCount, flatCount參考值傳給SaveReference中的objArr
        SaveReference.addReference("owinCount",owinCount);
        SaveReference.addReference("xwinCount",xwinCount);
        SaveReference.addReference("flatCount",flatCount);
    }
}
