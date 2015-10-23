package controllers;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

import javafx.stage.Stage;

/**
 * Created by Philip on 10/18/2015.
 * Could be a useful class used to output messages to user.
 * Just use constructor to pass string to a new info box.
 * Its ugly right now.
 */
public class MessageBox extends Stage {
    Button ok;
    Scene scene;
    public MessageBox(String message){
        Label messageLabel = new Label(message);
        ok = new Button("Ok");
        ok.setOnAction(event -> close());
        BorderPane borderPane = new BorderPane();
        borderPane.setBottom(ok);
        borderPane.setCenter(messageLabel);
        borderPane.setStyle("../../resources/css/Login.css");
        scene = new Scene(borderPane,200,150);
        setScene(scene);
        show();
    }
}
