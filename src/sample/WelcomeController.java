package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class WelcomeController {
    @FXML
    AnchorPane anchor;
    private double xOffset=0;
    private double yOffset=0;


    @FXML
    Button next_button;

    @FXML
    void closeWindow(){
        Platform.exit();
    }

    @FXML
    void nextScene(){
        Main.changeScene(1);
    }

    @FXML
    void skipToClouds(){
        Main.changeScene(11);
    }

    @FXML
    void goooo(){
        Main.changeScene(14);
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
