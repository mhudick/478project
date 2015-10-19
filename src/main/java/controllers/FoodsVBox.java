/* Developer: Mark Donile
** Date: 2015.10.18
** Configuration Version: 1.0.0
*/

package controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

public class FoodsVBox extends VBox {

    public FoodsVBox(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/foods.fxml"));
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
