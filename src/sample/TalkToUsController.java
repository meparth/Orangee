package sample;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TalkToUsController {
    FadeTransition ft;
    private double xOffset=0;
    private double yOffset=0;

    @FXML
    AnchorPane anchor;



    @FXML
    Label label1;


    @FXML
    void initialize(){
//        label1.setVisible(false);
//        ft = new FadeTransition(Duration.millis(2000), label1);
//        ft.setFromValue(0.0);
//        ft.setToValue(1.0);
//        ft.setAutoReverse(false);
//        ft.setCycleCount(1);
//        ft.playFromStart();
//        label1.setVisible(true);
    }

    @FXML
    void goServer(){
        Main.changeScene(14);
    }

    @FXML
    void goClient(){
        Main.changeScene(15);
    }






    @FXML
    void closeWindow(){
        Platform.exit();
    }

    @FXML
    void nextScene(){
        Main.changeScene(5);
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
