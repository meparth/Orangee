package sample;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Survey1Controller {
    private double totalCounter;
    private double xOffset=0;
    private double yOffset=0;



    @FXML
    AnchorPane question_01, question_02, question_03, anchor;

    private FadeTransition fadein_next_button = new FadeTransition(Duration.millis(500));
    private FadeTransition fadein_02 = new FadeTransition(Duration.millis(500));
    private FadeTransition fadein_03 = new FadeTransition(Duration.millis(500));

    @FXML
    Button next_button;

    @FXML
    Slider slider_01, slider_02, slider_03;

    public void initialize(){
        totalCounter = 150;

        fadein_next_button.setNode(next_button);
        fadein_next_button.setFromValue(0);
        fadein_next_button.setToValue(1);
        fadein_next_button.setCycleCount(1);
        fadein_next_button.setAutoReverse(false);
        fadein_02.setNode(question_02);
        fadein_02.setFromValue(0);
        fadein_02.setToValue(1);
        fadein_02.setCycleCount(1);
        fadein_02.setAutoReverse(false);
        fadein_03.setNode(question_03);
        fadein_03.setFromValue(0);
        fadein_03.setToValue(1);
        fadein_03.setCycleCount(1);
        fadein_03.setAutoReverse(false);

        question_02.setVisible(false);
        question_03.setVisible(false);
        next_button.setVisible(false);

//        boolean one=false, two=false, three=false;

        slider_01.valueProperty().addListener(((observable, oldValue, newValue) -> {
            if(!question_02.isVisible()){
                question_02.setVisible(true);
                fadein_02.playFromStart();
            }
//            totalCounter +=(newValue-oldValue);
            totalCounter += (newValue.intValue()-oldValue.intValue());
//            System.out.println(totalCounter);

        }));
        slider_02.valueProperty().addListener(((observable, oldValue, newValue) -> {
            if(!question_03.isVisible()){
                question_03.setVisible(true);
                fadein_03.playFromStart();
            }
            totalCounter += (newValue.intValue()-oldValue.intValue());
//            System.out.println(totalCounter);

        }));
        slider_03.valueProperty().addListener(((observable, oldValue, newValue) -> {
            if(!next_button.isVisible()){
                next_button.setVisible(true);
                fadein_next_button.playFromStart();
            }
            totalCounter += (newValue.intValue()-oldValue.intValue());
//            System.out.println(totalCounter);

        }));
//        info.data = totalCounter;
//        int x = WelcomeController.hello;
    }



    @FXML
    protected void nextScene(){
        Info.survey1res = totalCounter;
        Main.changeScene(9);
    }

    @FXML
    void closeWindow(){
        Platform.exit();
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
