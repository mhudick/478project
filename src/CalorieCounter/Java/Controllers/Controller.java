package CalorieCounter.Java.Controllers;

import CalorieCounter.Java.Model.Food;
import CalorieCounter.Java.Model.SearchResponse;
import CalorieCounter.Java.Model.SearchResponseItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.text.TabableView;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Controller {

    SearchResponse currentSearchList;
    Food currentFood;
    @FXML
    private TextField searchField;

    @FXML
    private Button myButton;

    @FXML
    private TableView<SearchResponseItem> listView;

    @FXML
    private TextArea textArea;

    @FXML
    private TextField details;

    @FXML
    private Button getDetails;

    @FXML
    private Button refreshButton;

    @FXML
    private Button saveButton;

    @FXML
    private ListView<String> databaseList;

    @FXML
    private Button deleteButton;

    @FXML
    private TextField deleteField;
    /*
    This method is called after the Loader retrieves the FXML file and will handle the events.
     */
    @FXML
    private void initialize(){
        //Takes text from field and uses it as the search term. Then it sets textArea.
        myButton.setOnAction((event) ->{

            currentSearchList = WebManager.webSearchFoods(searchField.getText());
            System.out.println(currentSearchList.toString());

            TableColumn<SearchResponseItem, String> idColumn = new TableColumn<SearchResponseItem,String>("NDB no");
            TableColumn<SearchResponseItem, String> nameColumn = new TableColumn<SearchResponseItem,String>("Name");
            TableColumn<SearchResponseItem, String> groupColumn = new TableColumn<SearchResponseItem,String>("Food Group");

            idColumn.setCellValueFactory(new PropertyValueFactory<SearchResponseItem, String>("ndbno"));
            nameColumn.setCellValueFactory(new PropertyValueFactory<SearchResponseItem, String>("name"));
            groupColumn.setCellValueFactory(new PropertyValueFactory<SearchResponseItem, String>("group"));

            listView.getColumns().addAll(idColumn,nameColumn,groupColumn);
            ObservableList<SearchResponseItem> data = FXCollections.observableArrayList(currentSearchList.getItem());
            listView.setItems(data);
        });

        getDetails.setOnAction(event -> {
            currentFood = WebManager.webFoodDetails(details.getText());
            textArea.setText(currentFood.toString());
        });

        saveButton.setOnAction(event1 -> {
            currentFood.saveFood();
        });

        refreshButton.setOnAction(event -> {
            String sql = "SELECT name FROM food;";
            List<String> list = new ArrayList();
            ResultSet rs = DataManager.retrieveData(sql);
            try {
                while(!rs.isAfterLast()){
                    list.add(rs.getString("name"));
                    rs.next();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ObservableList<String> observableList = FXCollections.observableArrayList(list);
            databaseList.setItems(observableList);
        });

        deleteButton.setOnAction(event -> {

        });
    }
}
