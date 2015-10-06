package CalorieCounter.Java.Controllers;

import CalorieCounter.Java.Model.Food;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

public class Controller {

    @FXML
    private TextField searchField;

    @FXML
    private Button myButton;

    @FXML
    private TextArea textArea;
    /*
    This method is called after the Loader retrieves the FXML file and will handle the events.
     */
    @FXML
    private void initialize(){
        //Takes text from field and uses it as the search term. Then it sets textArea.
        myButton.setOnAction((event) ->{
            Food food = new WebManager().webFoodDetails("18541");
            DataManager dataManager = new DataManager();
            dataManager.saveFood(food);
        });
    }
}
