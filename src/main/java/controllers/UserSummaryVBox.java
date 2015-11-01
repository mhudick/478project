/* Developer: Mark Donile
** Date: 2015.10.31
** Configuration Version: 1.0.0
*/

package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

public class UserSummaryVBox extends VBox implements ManagedScreen{

    private ScreenManager screenManager;

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
    public void handleSearchButton(ActionEvent actionEvent){
        System.out.println("Search button pressed!");
    }

    @FXML
    public void handleRecipeButton(ActionEvent actionEvent){
        System.out.println("Recipe button pressed!");
    }

    public void setScreenManager(ScreenManager screenManager){
        this.screenManager = screenManager;
    }
}
