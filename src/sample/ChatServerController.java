package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServerController {
    private String host;
    private int port;
    private Socket socket;
    private ServerSocket serverSocket;
    private DataInputStream dis;
    private DataOutputStream dos;

    private boolean stop=false;
    private String str1="", str2="";
    private String username = "Server";

    private double xOffset=0;
    private double yOffset=0;


    @FXML
    private TextField msgInput;
    @FXML
    private TextArea msgView;
    @FXML
    private AnchorPane anchor;
    @FXML
    private AnchorPane anchorpre;
    @FXML
    private TextField usernamefield;


    @FXML
    void initialize(){
        port = 3333;
        // move it to another method

    }

    private class LetsHear extends Thread{
        @Override
        public void run() {
            try{
                serverSocket = new ServerSocket(port);
                socket = serverSocket.accept();
                dis = new DataInputStream(socket.getInputStream());
                dos = new DataOutputStream(socket.getOutputStream());
            }catch (Exception e){
//                display("error creating socket");
            }



            while(!stop){
                try{
                    str1 = dis.readUTF();
                    display(str1);

                }catch (Exception e){
//                    display("cant read");
                }
            }



            try {
                dos.close();
                socket.close();
            } catch (IOException e) {
//                display("cant close");
            }
        }
    }


    @FXML
    void closeWindow(){
//        stop=false;
//        try {
//            dos.close();
//            socket.close();
//        } catch (IOException e) {
//            display("cant close");
//        }
        Platform.exit();
    }


    @FXML
    void entered(KeyEvent event){
        if(event.getCode()== KeyCode.ENTER){
            sendMsg();
            event.consume();
        }
    }

    @FXML
    void sendMsg(){
        str2 = msgInput.getText();
        str2 = username + ": " + str2 + "\n";
        msgInput.setText("");
        display(str2);
        try{
            dos.writeUTF(str2);
            dos.flush();
        }catch (Exception e){}
    }

    @FXML
    void usernameEntered(KeyEvent event){
        if(event.getCode()== KeyCode.ENTER){
            startServer();
            event.consume();
        }
    }


    @FXML
    void startServer(){
        anchorpre.setVisible(false);
        anchor.setVisible(true);
        new LetsHear().start();
        username = usernamefield.getText();
    }


    private void display(String s){
        msgView.appendText(s);
    }


    @FXML
    private void closeConnection(){
        stop=true;
    }

    @FXML
    void goHome(){
        Main.changeScene(11);
    }


    @FXML
    private void mouseDragged(MouseEvent event){
        Stage primaryStage = (Stage) anchor.getScene().getWindow();
        primaryStage.setX(event.getScreenX() - xOffset);
        primaryStage.setY(event.getScreenY() - yOffset);
    }
    @FXML
    private void mousePressed(MouseEvent event){
        xOffset = event.getSceneX();
        yOffset = event.getSceneY();
    }

}
