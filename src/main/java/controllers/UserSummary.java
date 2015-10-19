/* Developer: Mark Donile
** Date: 2015.10.18
** Configuration Version: 1.0.0
*/

package controllers;

import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;

public class UserSummary extends VBox {

    public UserSummary(){
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

}
