package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.*;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class EncryptController implements Initializable {

    @FXML
    private Button run, close;
    @FXML
    private MenuButton methodMenu; //選擇加密法的MenuButton
    @FXML
    private MenuItem caesar; //凱薩加密法選項的MenuItem
    @FXML
    private RadioButton encrypt, decrypt; //解密或加密的單選按鈕
    @FXML
    private TextArea input, output; //輸入要加密的文字和輸出要解密的文字的TextArea
    @FXML
    private TextField num; //要加密多少

    private boolean isCaesar; //是否有選擇任何加密法
    private boolean isChoosedMethod = false; //是否有選擇凱薩加密法

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        run.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {


                if (isChoosedMethod){

                    if (isCaesar){

                        String str = "";

                        //捕捉例外
                        try {

                            //取得加密後文字
                            for (int i=0; i<input.getText().length(); i++){
                                str += (char)((int)(input.getText().charAt(i)) + Integer.parseInt(num.getText()));
                            }
                            //設定加密後文字在output
                            output.setText(str);

                        }catch (NumberFormatException e){
                            //顯示警告訊息彈出視窗
                            JOptionPane.showMessageDialog(null,"輸入的加密文字1.不是數字2.未輸入3.超出範圍","警告",JOptionPane.INFORMATION_MESSAGE );
                        }
                    }

                }else {
                    //顯示警告訊息彈出視窗
                    JOptionPane.showMessageDialog(null,"未選擇加密法","警告",JOptionPane.INFORMATION_MESSAGE );
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

        caesar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                methodMenu.setText("caesar");
                isCaesar = true;
                isChoosedMethod = true;
            }
        });

    }

}
