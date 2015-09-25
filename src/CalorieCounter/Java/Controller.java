package CalorieCounter.Java;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

public class Controller {

    UrlHandler urlHandler = new UrlHandler();

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
            try {
                textArea.setText(urlHandler.search(searchField.getText()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
