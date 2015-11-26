package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

/**
 * Created by Phil on 11/24/2015.
 */
public class WeighInScreen extends VBox implements HomeControl {

    private HomeScreen homeScreen;

    public WeighInScreen(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/weigh_in_screen.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try{
            fxmlLoader.load();
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }

    @FXML
    public void handleCancelButton(ActionEvent event){
        homeScreen.getMenuChoiceBox().setValue("Home");
    }

    @Override
    public void setHomeScreen(HomeScreen homeScreen) {
        this.homeScreen = homeScreen;
    }
}
