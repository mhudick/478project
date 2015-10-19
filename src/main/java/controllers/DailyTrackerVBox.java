/* Developer: Mark Donile
** Date: 2015.10.18
** Configuration Version: 1.0.0
*/

package controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

public class DailyTrackerVBox extends VBox {

    public DailyTrackerVBox(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/daily_tracker.fxml"));
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
