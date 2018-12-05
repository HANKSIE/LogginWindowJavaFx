package sample;

import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Server implements Runnable{

    private ServerSocket server;
    private Socket s;

    private TextArea talkArea = (TextArea) SaveReference.getReference("talkArea");
    private TextArea message = (TextArea) SaveReference.getReference("message");

    private OutputStream out;
    private InputStream in;

    private boolean receiveIsConnect = true,sendIsConnect = true;


    public Server(){}

    @Override
    public void run() {

        try {
            server = new ServerSocket(2525);

            System.out.println("等待連線...");
            s = server.accept();

            Alert alert = (Alert)SaveReference.getReference("tip");
            alert.close();

            StageManager.getStage("iTalkServerStage").close();
            StageManager.getStage("iTalkPaneServerStage").show();

            System.out.println("成功連線!");
            System.out.println("對方ip位址:"+s.getInetAddress());

            out = s.getOutputStream();
            in = s.getInputStream();

            ReceiveMessage receive = new ReceiveMessage(talkArea,in);
            SendMessage send = new SendMessage(talkArea,message,out);

            SaveReference.addReference("send",send);

            Thread receiveThread = new Thread(receive);
            Thread sendThread = new Thread(send);

            receiveThread.start();
            sendThread.start();

            while (receiveIsConnect && sendIsConnect){
                receiveIsConnect = receive.isConnect();
                sendIsConnect = send.isConnect();
            }

            in.close();
            out.close();
            s.close();
            server.close();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public String getInfo(){
        InetAddress inetAddress = s.getInetAddress();
        String info = "------------------------\n"+"對方ip:"+inetAddress.getAddress()+"\n"+
                      "對方hostName:"+inetAddress.getHostName()+"\n"+
                      "對方hostAddress:"+inetAddress.getHostAddress()+"\n"+
                      "------------------------\n";
        return info;
    }

    public void setReceiveIsConnect(boolean flag){
        receiveIsConnect = flag;
    }

    public void setSendIsConnect(boolean flag){
        sendIsConnect = flag;
    }

}

class ReceiveMessage implements Runnable{

    private InputStream in;
    private byte messageIn[] = new byte[1028];
    private boolean isConnect = true;
    private String receiveMessage;
    private TextArea t;

    public ReceiveMessage(TextArea textArea,InputStream inputStream){
        t = textArea;
        in = inputStream;
    }

    @Override
    public void run() {

        while (isConnect){
            try {

                int length = in.read(messageIn);
                receiveMessage = new String(messageIn,0,length,"UTF-8");
                if (length!=0){
                    t.setText(t.getText()+receiveMessage+"\n");
                }

            }catch (SocketException e){
                isConnect = false;
                e.printStackTrace();
            }catch (IOException e){
                isConnect = false;
                e.printStackTrace();
            }
        }

    }

    public boolean isConnect(){
        return isConnect;
    }

}

class SendMessage implements Runnable{

    private TextArea m,t;
    private OutputStream out;
    private String messageOut;
    private boolean isConnect = true;
    private boolean canSend = false;

    public SendMessage(TextArea talkArea,TextArea message,OutputStream outputStream){
        t = talkArea;
        m = message;
        out = outputStream;
    }

    @Override
    public void run() {

        while (isConnect){
            try {

                if (canSend){
                    messageOut = m.getText();
                    out.write(messageOut.getBytes("UTF-8"));
                    canSend = false;
                }

            }catch (SocketException e){
                isConnect = false;
                e.printStackTrace();
            }catch (IOException e){
                isConnect = false;
                e.printStackTrace();
            }
        }

    }

    public void isCanSend(boolean flag){
        canSend = flag;
    }

    public boolean isConnect(){
        return isConnect;
    }

}