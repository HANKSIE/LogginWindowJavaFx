package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ResourceBundle;

public class TimingController implements Initializable {

    @FXML
    private Button start,restart,stop;
    @FXML
    private ImageView hour1,hour2,min1,min2,second1,second2,colon1,colon2;

    private Image imgArr[] = new Image[12];
    private Timer timing, colonTimer;
    private int count = 0;
    private boolean flag = true;

    int testH1,testH2,testMin1,testMin2,testSecond1,testSecond2,hour,min,second;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //-------把需要的圖片放入圖片陣列-------
        for (int i=0; i<imgArr.length; i++){
            imgArr[i] = new Image("\\timingSrc\\"+Integer.toString(i)+".png");
        }
        //----------------------------------

        //------------timing定義------------
        timing = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                int tempCount = count;

                hour= tempCount/3600;
                tempCount = tempCount%3600;
                min= tempCount/60;
                tempCount = tempCount%60;
                second = tempCount;


                if (count <= 359999){ //當小於99:59:59時

                    testH1 = hour/10;
                    testH2 = hour%10;
                    testMin1 = min/10;
                    testMin2 = min%10;
                    testSecond1 = second/10;
                    testSecond2 = second%10;

                    hour1.setImage(imgArr[testH1]);
                    hour2.setImage(imgArr[testH2]);
                    min1.setImage(imgArr[testMin1]);
                    min2.setImage(imgArr[testMin2]);
                    second1.setImage(imgArr[testSecond1]);
                    second2.setImage(imgArr[testSecond2]);

                }else{

                    JOptionPane.showMessageDialog(null, "ERROR:超出計時器範圍","警告", JOptionPane.INFORMATION_MESSAGE);
                    timing.stop();
                }



            }
        });
        //----------------------------------

        //----------colonTimer定義-----------
        colonTimer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag = !flag;

                if (flag){
                    colon1.setImage(imgArr[11]);
                    colon2.setImage(imgArr[11]);
                }else {
                    colon1.setImage(imgArr[10]);
                    colon2.setImage(imgArr[10]);
                }
            }
        });
        //----------------------------------

        //---------------start--------------
        start.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                timing.start();
            }
        });
        //----------------------------------

        //--------------restart-------------
        restart.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                timing.stop();
                count = 0;
                timing.start();
            }
        });
        //----------------------------------

        //--------------stop----------------
        stop.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                timing.stop();
            }
        });
        //----------------------------------

       
        //-----------啟用冒號計時器----------
        colonTimer.start();
        //----------------------------------
    }

}
