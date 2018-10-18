package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class EncryptController implements Initializable {

    @FXML
    private Button run, close, clear;
    @FXML
    private MenuButton methodMenu; //選擇加密法的MenuButton
    @FXML
    private MenuItem caesar, xor; //凱薩加密法選項的MenuItem
    @FXML
    private RadioButton encrypt, decrypt; //解密或加密的單選按鈕
    @FXML
    private TextArea input, output; //輸入要加密的文字和輸出要解密的文字的TextArea
    @FXML
    private TextField num; //要加密多少
    @FXML
    private MenuItem open, save;

    private JFileChooser jfc = new JFileChooser(); //檔案選擇器
    private Alert alert = new Alert(Alert.AlertType.INFORMATION);
    private boolean isCaesar = false; //是否有選擇凱薩加密法
    private boolean isXor = false; //是否有選擇XOR加密法
    private boolean isChoosedMethod = false; //是否有選擇任何加密法


    public void showAlertWindow(String title,String message){
        alert.setHeaderText(message);
        alert.setTitle(title);
        alert.setWidth(250);
        alert.setHeight(90);
        alert.show();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        run.setOnAction(new EventHandler<ActionEvent>() {
            @Override

            public void handle(ActionEvent event) {
                if (isChoosedMethod){

                    //==========================XOR==========================
                    if (isXor){ //選擇XOR加密法

                        //捕捉例外
                        try {
                            String str = "";
                            char key[] = num.getText().toCharArray();

                            if (encrypt.isSelected()) { //單選按鈕encrypt被選擇.

                                //取得加密後文字
                                for (int i = 0; i < input.getText().length(); i++) {
                                    if (input.getText().charAt(i) == '\n') {
                                        str += '\n'; //換行
                                    } else {
                                        //加密
                                        str += (char) ((int) input.getText().charAt(i)  ^ (int) key[i % key.length]);
                                    }
                                }


                            } else { //單選按鈕decrypt被選擇

                                //取得加密後文字
                                for (int i = 0; i < input.getText().length(); i++) {
                                    if (input.getText().charAt(i) == '\n') {
                                        str += '\n'; //換行
                                    } else {
                                        //加密
                                        str += (char) ((int) input.getText().charAt(i)  ^ (int) key[i % key.length]);
                                    }
                                }
                            }

                            output.setText(str);

                        }catch (Exception e){
                            //顯示警告訊息彈出視窗
                            showAlertWindow("警告", "Error:"+e.getMessage());
                        }

                    }
                    //==========================Caesar==========================
                    if (isCaesar){ //選擇Caesar加密法

                        String str = "";

                        //捕捉例外
                        try {
                            if (encrypt.isSelected()){ //單選按鈕encrypt被選擇
                                //取得加密後文字
                                for (int i=0; i<input.getText().length(); i++){
                                    //如果輸入文字讀取字元時遇到換行字元
                                    if (input.getText().charAt(i) =='\n') {
                                        str+='\n'; //換行
                                    }else {
                                        //加密
                                        str += (char)((int)(input.getText().charAt(i)) + Integer.parseInt(num.getText()));
                                    }

                                }

                            }else { //單選按鈕decrypt被選擇
                                //取得解密後文字

                                for (int i=0; i<input.getText().length(); i++){
                                    if (input.getText().charAt(i) =='\n') {
                                        str+='\n'; //換行
                                    }else {
                                        //加密
                                        str += (char)((int)(input.getText().charAt(i)) - Integer.parseInt(num.getText()));
                                    }

                                }
                            }
                            //設定加密後文字在output
                            output.setText(str);
                        }catch (NumberFormatException e){
                            //顯示警告訊息彈出視窗
                            showAlertWindow("警告","輸入的加密文字1.不是數字2.未輸入3.超出範圍");
                        }
                    }

                }else {
                    //顯示警告訊息彈出視窗
                    showAlertWindow("警告","未選擇加密法");
                }

            }

        });

        close.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //關密加密視窗
                StageManager.getStage("encryptStage").close();
            }
        });

        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                input.setText("");
                output.setText("");
            }
        });

        caesar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                methodMenu.setText("caesar");
                isCaesar = true;
                isChoosedMethod = true;
            }
        });

        xor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                methodMenu.setText("XOR");
                isXor = true;
                isChoosedMethod = true;
            }
        });

        open.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                //當檔案選擇器jfc裡的檔案被選擇
                if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){

                    String str = ""; //儲存文字檔用的空字串

                    try {

                        //讀檔案用的FileReader，jfc.getSelectedFile()為File
                        FileReader fr = new FileReader(jfc.getSelectedFile());
                        //建立一個讀取緩衝區
                        BufferedReader bfr = new BufferedReader(fr);

                        while ((str = bfr.readLine())!= null){
                            input.appendText(str + '\n');
                        }

                        fr.close();

                    }catch (IOException e){
                        //丟錯誤訊息
                        JOptionPane.showMessageDialog(null,"ERROR:"+e.getMessage(),"警告",JOptionPane.INFORMATION_MESSAGE);
                    }catch (Exception e){
                        JOptionPane.showMessageDialog(null,"ERROR:"+e.getMessage(),"警告",JOptionPane.INFORMATION_MESSAGE );
                    }

                }

            }
        });

        save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                try{

                    if (output.getText().length() > 0){
                        if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
                            FileWriter fw = new FileWriter(jfc.getSelectedFile());
                            BufferedWriter bfw = new BufferedWriter(fw);
                            bfw.write(output.getText());

                            bfw.close();
                        }
                    }else {
                        showAlertWindow("警告","沒有文字");
                    }

                }catch (IOException e){
                    JOptionPane.showMessageDialog(null,"ERROR:"+e.getMessage(),"警告",JOptionPane.INFORMATION_MESSAGE );
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null,"ERROR:"+e.getMessage(),"警告",JOptionPane.INFORMATION_MESSAGE );
                }
            }
        });

    }

}
