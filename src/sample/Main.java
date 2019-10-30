package sample;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    Stage primaryStage;
    static AnchorPane root;
    static List<AnchorPane> panes = new ArrayList<>();
    private static int indCurr=0;

    @Override
    public void start(Stage ps) throws Exception{
        this.primaryStage = ps;
        root = FXMLLoader.load(getClass().getResource("clouds.fxml"));


        panes.add(FXMLLoader.load(getClass().getResource("welcome.fxml")));
        panes.add(FXMLLoader.load(getClass().getResource("survey1.fxml")));
        panes.add(FXMLLoader.load(getClass().getResource("noneedhelp.fxml")));
        panes.add(FXMLLoader.load(getClass().getResource("needhelp.fxml")));
        panes.add(FXMLLoader.load(getClass().getResource("clouds.fxml")));
        panes.add(FXMLLoader.load(getClass().getResource("task1.fxml")));
        panes.add(FXMLLoader.load(getClass().getResource("task2.fxml")));
        panes.add(FXMLLoader.load(getClass().getResource("task3.fxml")));
        panes.add(FXMLLoader.load(getClass().getResource("task4.fxml")));

        panes.add(FXMLLoader.load(getClass().getResource("survey2.fxml")));
        panes.add(FXMLLoader.load(getClass().getResource("survey3.fxml")));

        panes.add(FXMLLoader.load(getClass().getResource("clouds.fxml")));
        panes.add(FXMLLoader.load(getClass().getResource("recommendations.fxml")));
        panes.add(FXMLLoader.load(getClass().getResource("talkToUs.fxml")));

        panes.add(FXMLLoader.load(getClass().getResource("chatServer.fxml")));
        panes.add(FXMLLoader.load(getClass().getResource("chatClient.fxml")));
        panes.add(FXMLLoader.load(getClass().getResource("talkToUs.fxml")));
        panes.add(FXMLLoader.load(getClass().getResource("notepad.fxml")));



//        new CloudsController().splashEnter();


        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void changeScene(int ind){
            root.getChildren().remove(panes.get(indCurr));
            root.getChildren().add(panes.get(ind));
            indCurr = ind;
    }

//    public static void removeScene(int ind){
//        root.getChildren().remove(panes.get(indCurr));
//    }

    public static void main(String[] args) {
        launch(args);
    }
}

/**
scene list
0 - welcome
1 - survey1
2 - noneedhelp
3 - needhelp
4 - clouds
5 - task1 (think about the things that are intimidating you)
6 - task2 (now write down...)
7 - task3 (your frnd)
8 - task4 (now write down...)
9 - survey2
10 - survey3
11 - clouds
12 - recommendations
13 - talkToUs
14 - chatServer
15 - chatClient
16 - talkToUs
17 - notepad

**/
