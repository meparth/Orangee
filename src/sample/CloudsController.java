package sample;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class CloudsController {
    private double xOffset=0;
    private double yOffset=0;


    FadeTransition fadeLabel;
    FadeTransition fadeSplash;
    ScaleTransition scale, scale1, scale2, scale3, scale4;
    ScaleTransition scaleStart, scaleStart1, scaleStart2, scaleStart3, scaleStart4;

    @FXML
    AnchorPane anchor;
    @FXML
    Button btn, btn1, btn2, btn3, btn4;
    @FXML
    ImageView img, img1, img2, img3, img4;
    @FXML
    Button next_button;
    @FXML
    Label nameWhereToGo;
//    @FXML
//    ImageView splash;


    public void initialize(){
//        splash.setVisible(false);
//        fadeSplash = new FadeTransition(Duration.millis(400), splash);


        fadeLabel = new FadeTransition(Duration.millis(400), nameWhereToGo);
        fadeLabel.setCycleCount(1);
        fadeLabel.setAutoReverse(false);
        nameWhereToGo.setVisible(false);

        // for hover effect
        scale = new ScaleTransition(Duration.millis(200), img);
        scale.setToX(1);
        scale.setToY(1);
        scale.setCycleCount(1);
        scale.setAutoReverse(false);

        scale1 = new ScaleTransition(Duration.millis(200), img1);
        scale1.setToX(1);
        scale1.setToY(1);
        scale1.setCycleCount(1);
        scale1.setAutoReverse(false);

        scale2 = new ScaleTransition(Duration.millis(200), img2);
        scale2.setToX(1);
        scale2.setToY(1);
        scale2.setCycleCount(1);
        scale2.setAutoReverse(false);

        scale3 = new ScaleTransition(Duration.millis(200), img3);
        scale3.setToX(1);
        scale3.setToY(1);
        scale3.setCycleCount(1);
        scale3.setAutoReverse(false);

        scale4 = new ScaleTransition(Duration.millis(200), img4);
        scale4.setToX(1);
        scale4.setToY(1);
        scale4.setCycleCount(1);
        scale4.setAutoReverse(false);

        // after a click
        scaleStart = new ScaleTransition(Duration.millis(200), img);
        scaleStart.setToX(1);
        scaleStart.setToY(1);
        scaleStart.setCycleCount(2);
        scaleStart.setAutoReverse(true);

        scaleStart1 = new ScaleTransition(Duration.millis(200), img1);
        scaleStart1.setToX(1);
        scaleStart1.setToY(1);
        scaleStart1.setCycleCount(2);
        scaleStart1.setAutoReverse(true);

        scaleStart2 = new ScaleTransition(Duration.millis(200), img2);
        scaleStart2.setToX(1);
        scaleStart2.setToY(1);
        scaleStart2.setCycleCount(2);
        scaleStart2.setAutoReverse(true);

        scaleStart3 = new ScaleTransition(Duration.millis(200), img3);
        scaleStart3.setToX(1);
        scaleStart3.setToY(1);
        scaleStart3.setCycleCount(2);
        scaleStart3.setAutoReverse(true);

        scaleStart4 = new ScaleTransition(Duration.millis(200), img4);
        scaleStart4.setToX(1);
        scaleStart4.setToY(1);
        scaleStart4.setCycleCount(2);
        scaleStart4.setAutoReverse(true);
    }

//    public void splashEnter(){
//        fadeSplash.setCycleCount(1);
//        fadeSplash.setAutoReverse(true);
//        splash.setVisible(true);
//        fadeSplash.setToValue(1.0);
//        fadeSplash.playFromStart();
//    }

    @FXML
    void mouseEntered(MouseEvent event){
        if(event.getSource().equals(btn)){
            scale.setToX(1.2);
            scale.setToY(1.2);
            scale.playFromStart();

            nameWhereToGo.setText("take a survey");
        }else if(event.getSource().equals(btn1)){
            scale1.setToX(1.2);
            scale1.setToY(1.2);
            scale1.playFromStart();

            nameWhereToGo.setText("");
        }else if(event.getSource().equals(btn2)){
            scale2.setToX(1.2);
            scale2.setToY(1.2);
            scale2.playFromStart();

            nameWhereToGo.setText("talk to us");
        }else if(event.getSource().equals(btn3)){
            scale3.setToX(1.2);
            scale3.setToY(1.2);
            scale3.playFromStart();

            nameWhereToGo.setText("what's in your mind");
        }else{
            scale4.setToX(1.2);
            scale4.setToY(1.2);
            scale4.playFromStart();

            nameWhereToGo.setText("recommendations");
        }
        nameWhereToGo.setVisible(true);
        fadeLabel.setFromValue(0.0);
        fadeLabel.setToValue(1.0);
        fadeLabel.playFromStart();
    }
    @FXML
    void mouseExited(MouseEvent event){
        if(event.getSource().equals(btn)){
            scale.setToX(1);
            scale.setToY(1);
            scale.playFromStart();
        }else if(event.getSource().equals(btn1)){
            scale1.setToX(1);
            scale1.setToY(1);
            scale1.playFromStart();
        }else if(event.getSource().equals(btn2)){
            scale2.setToX(1);
            scale2.setToY(1);
            scale2.playFromStart();
        }else if(event.getSource().equals(btn3)){
            scale3.setToX(1);
            scale3.setToY(1);
            scale3.playFromStart();
        }else if(event.getSource().equals(btn4)){
            scale4.setToX(1);
            scale4.setToY(1);
            scale4.playFromStart();
        }

        fadeLabel.setFromValue(1.0);
        fadeLabel.setToValue(0.0);
        fadeLabel.playFromStart();
    }
    @FXML
    void mousePressed(MouseEvent event){
        if(event.getSource().equals(btn)){
            scaleStart.setToX(1.5);
            scaleStart.setToY(1.5);
            scaleStart.playFromStart();

            scaleStart.setOnFinished(new EventHandler<ActionEvent>(){

                @Override
                public void handle(ActionEvent arg0) {
                    // take a survey
                    Main.changeScene(0);
                }
            });
        }else if(event.getSource().equals(btn1)){
            scaleStart1.setToX(1.5);
            scaleStart1.setToY(1.5);
            scaleStart1.playFromStart();

            scaleStart1.setOnFinished(new EventHandler<ActionEvent>(){

                @Override
                public void handle(ActionEvent arg0) {
                    //
                    Main.changeScene(5);
                }
            });
        }else if(event.getSource().equals(btn2)){
            scaleStart2.setToX(1.5);
            scaleStart2.setToY(1.5);
            scaleStart2.playFromStart();

            scaleStart2.setOnFinished(new EventHandler<ActionEvent>(){

                @Override
                public void handle(ActionEvent arg0) {
                    // talk to us
                    Main.changeScene(16);
                }
            });
        }else if(event.getSource().equals(btn3)){
            scaleStart3.setToX(1.5);
            scaleStart3.setToY(1.5);
            scaleStart3.playFromStart();

            scaleStart3.setOnFinished(new EventHandler<ActionEvent>(){

                @Override
                public void handle(ActionEvent arg0) {
                    // challenges
                    Main.changeScene(17);
                }
            });
        }else if(event.getSource().equals(btn4)){
            scaleStart4.setToX(1.5);
            scaleStart4.setToY(1.5);
            scaleStart4.playFromStart();

            scaleStart4.setOnFinished(new EventHandler<ActionEvent>(){

                @Override
                public void handle(ActionEvent arg0) {
                    // recommendations
                    Main.changeScene(12);
                }
            });
        }
    }




    @FXML
    void closeWindow(){
        Platform.exit();
    }

    @FXML
    void nextScene(){
        Main.changeScene(1);
    }

    @FXML
    private void mouseDraggedWindow(MouseEvent event){
        Stage primaryStage = (Stage) anchor.getScene().getWindow();
        primaryStage.setX(event.getScreenX() - xOffset);
        primaryStage.setY(event.getScreenY() - yOffset);
    }

    @FXML
    private void mousePressedWindow(MouseEvent event){
        xOffset = event.getSceneX();
        yOffset = event.getSceneY();
    }

}
