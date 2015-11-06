/* Developer: Mark Donile
** Date: 2015.10.31
** Configuration Version: 1.0.0
*/

package controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class UserSummaryVBox extends VBox implements UserControl{

    UserManager userManager;

    @FXML
    private Label nameLabel;

    public UserSummaryVBox(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/user_summary.fxml"));
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
    public void initialize(){

    }

    @FXML
    public void handleEditButton(ActionEvent event){
        System.out.println(userManager.getUser().getName());
        nameLabel.setText(userManager.getUser().getName());
    }

    @Override
    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }
    public void setLabels(){
        nameLabel.setText(userManager.getUser().getName());
    }
}
