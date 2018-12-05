package sample;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;;
import java.net.Socket;

public class Client implements Runnable{

    private Socket s;

    private TextArea talkArea = (TextArea)SaveReference.getReference("talkArea");
    private boolean flag = false;

    private String outMessage = " ";
    private String inMessage = " ";

    private OutputStream out;
    private InputStream in;

    public Client(){}

    @Override
    public void run() {

        try {

            s = new Socket("",2525);
            System.out.println("等待連線...");

            StageManager.getStage("iTalkStage").close();
            StageManager.getStage("iTalkPaneStage").show();

            System.out.println("成功連線!");
            System.out.println("對方ip位址:"+s.getInetAddress());

            while (flag){
                out = s.getOutputStream();
                in = s.getInputStream();
                outMessage = talkArea.getText();
                out.write(outMessage.getBytes());
                in.read(inMessage.getBytes());
            }

            in.close();
            out.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getInMessage(){
        return inMessage;
    }

    public void setOutMessage(String message){
        outMessage = message;
    }

    public void setFlag(boolean bool){
        flag = bool;
    }

    public String getInfo(){
        InetAddress inetAddress = s.getInetAddress();
        String info = "------------------------\n"+"對方ip:"+inetAddress.getAddress()+"\n"+
                "對方hostName:"+inetAddress.getHostName()+"\n"+
                "對方hostAddress:"+inetAddress.getHostAddress()+"\n"+
                "------------------------\n";
        return info;
    }


}
