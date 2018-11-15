package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.Window;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MoveController extends KeyAdapter implements Initializable {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Label obj;
//    private Scene scene = (Scene) SaveReference.getReference("moveScene");

    private int dir = 1;
    private double value = 5;
    private boolean isStart = false;
    private Timer timer;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        obj.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                System.out.println("handle!");
                switch (event.getCode()){

                    case SPACE:
                        System.out.println("space!");
                        isStart = true;
                        timer.start();
                        break;
                    case UP:
                        if (isStart){
                            dir = 1;
                        }
                        System.out.println("up!");
                        break;
                    case DOWN:
                        if (isStart){
                            dir = 2;
                        }
                        break;
                    case LEFT:
                        if (isStart){
                            dir = 3;
                        }
                        break;
                    case RIGHT:
                        if (isStart){
                            dir = 4;
                        }
                        break;


                }

            }
        });

        timer = new Timer(300, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (dir){
                    case 1:
                        obj.setLayoutY(obj.getLayoutY() - value);
                        break;
                    case 2:
                        obj.setLayoutY(obj.getLayoutY() + value);
                        break;
                    case 3:
                        obj.setLayoutX(obj.getLayoutX() - value);
                        break;
                    case 4:
                        obj.setLayoutX(obj.getLayoutX() + value);
                        break;
                }
            }
        });

    }



}

class Ball extends Circle{

    private int g = 1;
    private int v = 0;

    public Ball(int radius, int centerX,int centerY){
        this.setRadius(radius);
        this.setCenterX(centerX);
        this.setCenterY(centerY);
        this.setStyle("-fx-background-color:blue");
        this.setVisible(true);
    }

    private void update(){
        v += g;
        this.setLayoutX(this.getLayoutX()+v);
    }


}