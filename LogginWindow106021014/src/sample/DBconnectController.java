package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ResourceBundle;

public class DBconnectController implements Initializable {

    @FXML
    Button connect,showInfo,exit;
    TextArea textArea;

    ResultSet rs;
    ResultSetMetaData meta;
    DBconnection dbconn;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        connect.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dbconnection();
                if (dbconn != null){
                    System.out.println("連線成功!");
                }
                System.out.println("here");
            }
        });

        showInfo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showData();
            }
        });

        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });

    }

    public void dbconnection(){
        dbconn = new DBconnection("s106021014","RHNjh7pc");
    }

    public void showData(){
        try{
            rs = dbconn.getData();

            int colCount = 0;
            if (rs != null){

                meta = rs.getMetaData();
                colCount = meta.getColumnCount();

                while (rs.next()){
                    String record[] = new String[colCount];
                    for (int i=0; i<colCount; i++){
                        record[i] = rs.getString(i+1);
                        textArea.appendText(record[i]+"\t");
                    }
                    textArea.appendText("\n");
                }

            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
