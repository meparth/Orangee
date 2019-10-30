package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.time.LocalDate;

public class NotepadController {
    private double xOffset=0;
    private double yOffset=0;
    private ObservableList<String>allEntry;


    @FXML
    AnchorPane anchor;
    @FXML
    TextArea inputArea;
    @FXML
    TextField title;
    @FXML
    ListView list;
    @FXML
    DatePicker datePicker;


    public void initialize(){
        allEntry = FXCollections.observableArrayList();
        datePicker.setValue(LocalDate.now());

    }

    @FXML
    void entered(KeyEvent event){
        if(event.getCode()== KeyCode.ENTER){
            addEntry();
            event.consume();
        }
    }
    @FXML
    void addEntry(){
        if(inputArea.getText()=="") return;

        String entry =  "_______________________________________________________________\n" +
                        title.getText() + "\n" +
                        datePicker.getValue() + "\n" +
                        inputArea.getText() + "\n" ;


        allEntry.add(entry);
        list.setItems(allEntry);

        datePicker.setValue(LocalDate.now());
        title.setText("Title");
        inputArea.setText("");
    }

    @FXML
    void ansOut(){
        Main.changeScene(5);
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
