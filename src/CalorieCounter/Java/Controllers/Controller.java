package CalorieCounter.Java.Controllers;

import CalorieCounter.Java.Model.DatabaseObjects.Food;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
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
            WebServicer webServicer = new WebServicer();
            Gson gson = new Gson();
            String json = webServicer.foodReport("01009");
            JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
            System.out.println(jsonObject);
            jsonObject = jsonObject.get("report").getAsJsonObject();
            System.out.println(jsonObject);
            jsonObject = jsonObject.get("food").getAsJsonObject();
            System.out.println(jsonObject);
            Food food = gson.fromJson(jsonObject,Food.class);
            textArea.setText(food.toString());
        });
    }
}
