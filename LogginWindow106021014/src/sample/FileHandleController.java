package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class FileHandleController implements Initializable {

    @FXML
    private TextField input, output, key;
    @FXML
    private Button inputChoose, outputChoose,run,close;
    @FXML
    private MenuButton method;
    @FXML
    private MenuItem caesar, xor;
    @FXML
    private ProgressBar progressBar;

    private JFileChooser jfc = new JFileChooser(); //檔案選擇器
    private Alert alert = new Alert(Alert.AlertType.INFORMATION);


    private String inputFileName = " "; //選擇的檔案的"路徑+檔名"
    private int chooseMethod = 0;
    private boolean isChoosedMethod = false; //是否有選擇任何加密法

    //==============================================================

    public void showAlertWindow(String title,String message){
        alert.setHeaderText(message);
        alert.setTitle(title);
        alert.setWidth(250);
        alert.setHeight(90);
        alert.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        //讀原始檔
        inputChoose.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                progressBar.setProgress(0);

                if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

                    inputFileName = jfc.getSelectedFile().getPath();
                    input.setText(inputFileName);

                }
            }
        });

        //執行
        run.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (isChoosedMethod) {

                    switch (chooseMethod) {
                        case 1: //caesar

                            //捕捉例外
                            try {

                                File file = new File(inputFileName);
                                FileInputStream fis = new FileInputStream(file);

                                int length = fis.available();
                                int data[] = new int[length];

                                for (int i=0; i<length; i++){
                                    data[i] = fis.read();
                                    data[i] = data[i] + Integer.parseInt(key.getText());
//                                    System.out.print((char)data[i]);

                                    progressBar.setProgress((double) i / length);
                                }

                                fis.close();
                                showAlertWindow("訊息","success!");

                            } catch (NumberFormatException e) {
                                //顯示警告訊息彈出視窗
                                showAlertWindow("警告", "輸入的加密文字1.不是數字2.未輸入3.超出範圍");
                            } catch (IOException e) {
                                JOptionPane.showMessageDialog(null, "ERROR:" + e.getMessage(), "警告", JOptionPane.INFORMATION_MESSAGE);
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "ERROR:" + e.toString(), "未知的錯誤", JOptionPane.INFORMATION_MESSAGE);
                            }

                            break;

                        case 2: //XOR

                            //捕捉例外
                            try {

                                char keyArr[] = key.getText().toCharArray();
                                File file = new File(inputFileName);
                                FileInputStream fis = new FileInputStream(file);

                                int length = fis.available();
                                int data[] = new int[length];

                                for (int i=0; i<length; i++){
                                    data[i] = fis.read();
                                    data[i] = data[i] ^ (int) keyArr[i % keyArr.length];
                                    System.out.print((char)data[i]);

                                    progressBar.setProgress((double) i / length);
                                }

                                fis.close();
                                showAlertWindow("訊息","success!");

                            } catch (IOException e) {
                                JOptionPane.showMessageDialog(null, "ERROR:" + e.getMessage(), "警告", JOptionPane.INFORMATION_MESSAGE);
                            } catch (Exception e) {
                                //顯示警告訊息彈出視窗
                                showAlertWindow("警告", "Error:" + e.getMessage());
                            }

                            break;
                    }

                } else {
                    //顯示警告訊息彈出視窗
                    showAlertWindow("警告", "未選擇加密法");
                }

            }


        });

        caesar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                isChoosedMethod = true;
                chooseMethod = 1;
                method.setText("caesar");
            }
        });

        xor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                isChoosedMethod = true;
                chooseMethod = 2;
                method.setText("XOR");
            }
        });



    }

}
