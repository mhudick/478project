/* Developer: Mark Donile
** Date: 2015.10.18
** Configuration Version: 1.0.0
*/

package controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

public class WeighInVBox extends VBox {

    public WeighInVBox(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/weigh_in.fxml"));
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