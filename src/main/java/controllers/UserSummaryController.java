/* Developer: Mark Donile
** Date: 2015.10.31
** Configuration Version: 1.0.0
*/

package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class UserSummaryController implements ManagedScreen{

    private ScreenManager screenManager;

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
