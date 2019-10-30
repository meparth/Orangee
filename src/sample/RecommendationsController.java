package sample;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.Duration;



public class RecommendationsController {
    int currZoom;
    FadeTransition ft;
    FadeTransition ftweb;

    private double xOffset=0;
    private double yOffset=0;

    @FXML
    AnchorPane anchor;

    @FXML
    Label label;

    @FXML
    Button btnImdb, btnGoodreads, btnQuora, btnBack;



    @FXML
    WebView browser;
    WebEngine engine;


    public void initialize(){
        currZoom = 1;
        engine = browser.getEngine();

        ftweb = new FadeTransition(Duration.millis(400), browser);
        ftweb.setCycleCount(1);
        ftweb.setAutoReverse(false);
        browser.setVisible(false);

        ft = new FadeTransition(Duration.millis(400), label);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        label.setVisible(false);
    }


    @FXML
    void enteredMouse(MouseEvent event){
        if(event.getSource().equals(btnQuora)){
            label.setText("read inspiring stories");
        }else if(event.getSource().equals(btnImdb)){
            label.setText("watch some awesome movies");
        }else{
            label.setText("immerse in these beautiful books");
        }
        label.setVisible(true);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.playFromStart();
    }
    @FXML
    void exitedMouse(){
        ft.setToValue(0.0);
        ft.playFromStart();
    }



    @FXML
    void toImdb(){
        setBrowserFade();
        engine.load("http://www.imdb.com/list/ls069754038/");
        browser.setZoom(0.85);
    }

    @FXML
    void toQuora(){
        setBrowserFade();
        engine.load("https://www.quora.com/topic/Inspiration");
        browser.setZoom(0.90);
    }

    @FXML
    void toGoodreads(){
        setBrowserFade();
        engine.load("https://www.goodreads.com/genres/self-help");
        browser.setZoom(0.90);
//        engine.loadContent("maincontent");

    }

    void setBrowserFade(){
        btnBack.setVisible(true);
        browser.setVisible(true);
        ftweb.setFromValue(0.0);
        ftweb.setToValue(1.0);
        ftweb.playFromStart();

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
    void closeLid(){
        browser.setVisible(false);
        btnBack.setVisible(false);
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
