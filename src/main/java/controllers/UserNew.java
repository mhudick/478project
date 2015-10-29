package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import models.User;
import util.database.DataAccess;
import util.database.DataAccessImpl;




/**
 * Created by Philip on 10/27/2015.
 */
public class UserNew implements ScreenControl{
    ScreenManager myController = new ScreenManager();
    DataAccess dataAccess = new DataAccessImpl();
    @FXML TextField fieldName,fieldAge;

    public void handleBackButton(ActionEvent e){
        myController.setScreen("user_login");
    }

    public void handleCreateButton(ActionEvent e){
        User user = new User();
        user.setName(fieldName.getText());
        user.setAge(fieldAge.getText());
        dataAccess.saveUser(user);
        myController.reloadScreen("user_login");
    }

    @Override
    public void setScreenParent(ScreenManager screenParent) {
        myController = screenParent;
    }

    @Override
    public void setComponents() {

    }
}
