/* Developer: Mark Donile
** Date: 2015.10.31
** Configuration Version: 1.0.0
*/

package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;


public class RecipesVBox extends VBox implements ManagedScreen, UserControl{
    private ScreenManager screenManager;
    private UserManager userManager;

    @FXML TextArea textArea;

    @FXML
    Button button;

    @FXML
    public void initialize(){
        System.out.println("Recipe initialize");

    }

    public RecipesVBox(){
        System.out.println("Recipe Constructor");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/recipes.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try{
            fxmlLoader.load();
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }

    public void handleButton(){
        System.out.println("Pressed");
        textArea.setText(userManager.getUser().getName());
    }

    @Override
    public void setScreenManager(ScreenManager screenManager) {
        this.screenManager = screenManager;
    }

    @Override
    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }
}
