package controllers;

/* Developer: Mark Donile
** Date: 2015.10.31
** Configuration Version: 1.0.0
*/

/**
 * This class is the homeScreen that contains a stackPane. The other screens
 * are then switched in and out of view by this Controller. Each sub-screen
 * will maintain a reference to the HomeScreen.
 */

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.Node;

public class HomeScreen extends GridPane implements AppControl {

    //Objects used to maintain references.
    private AppManager appManager;
    private SessionManager sessionManager;
    private HomeScreen homeScreen;
    private Node previousContent;

    //These are the controllers for each screen in the contentStackPane.
    private SummaryScreen summaryScreen;
    private SearchScreen searchScreen;
    private FoodScreen foodScreen;
    private WeighInScreen weighInScreen;
    private ProfileScreen profileScreen;
    private HistoryScreen historyScreen;

    //FXML Controls
    @FXML private ChoiceBox menuChoiceBox;
    @FXML private TextField searchTextField;
    @FXML private StackPane contentStackPane;

    public HomeScreen(){
        this.homeScreen = this;
    }

    @FXML
    private void initialize(){
        //This is needed
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                sessionManager = appManager.getSessionManager();
                loadScreenControllers();
                setupHomeSession();
                loadMenuChoiceBox();
            }
        });
    }

    @FXML
    public void handleSearchButton(ActionEvent actionEvent){
        System.out.println("Search button clicked!");
        menuChoiceBox.setValue("Search");
        searchScreen.getSearchResults(searchTextField.getText());
        searchTextField.setText("");
    }

    @FXML
    public void handleMenuChoiceBox(ActionEvent actionEvent){
        System.out.println(menuChoiceBox.getValue().toString() + " was selected.");
        contentStackPane.getChildren().clear();
        String selectedContent = menuChoiceBox.getValue().toString();

        /**
         * A navigation menu should allow the user access to all screens
         * (Requirement 9.0.0)
         */
        switch(selectedContent){
            case "Home":
                summaryScreen.setLabels();
                contentStackPane.getChildren().add(0, summaryScreen);
                break;
            case "Search":
                contentStackPane.getChildren().add(0, searchScreen);
                break;
            case "Foods":
                foodScreen.setFoodListView();
                contentStackPane.getChildren().add(0, foodScreen);
                break;
            case "Weigh-In":
                weighInScreen.setLabel();
                contentStackPane.getChildren().add(0, weighInScreen);
                break;
            case "History":
                historyScreen.setTables();
                contentStackPane.getChildren().add(0, historyScreen);
                break;
            case "Edit Profile":
                profileScreen.setTextFields();
                contentStackPane.getChildren().add(0, profileScreen);
                break;
            case "Change User":
                appManager.unloadScreen(Screen.USER_LOG_IN);
                appManager.loadScreen(Screen.USER_LOG_IN, Screen.USER_LOG_IN.getResourcePath());
                appManager.show(Screen.USER_LOG_IN);
                break;
            default:
                System.out.println("default case executed in handleMenuChoiceBox method of HomeScreen");
                contentStackPane.getChildren().add(0, summaryScreen);
                break;
        }
    }

    public void loadMenuChoiceBox(){
        ObservableList<String> list = FXCollections.observableArrayList("Home", "Foods", "Weigh-In", "Search",
                                                                        "History", "Edit Profile","Change User");

        menuChoiceBox.setItems(list);
        menuChoiceBox.setValue("Home");
    }

    public ChoiceBox getMenuChoiceBox(){
        return menuChoiceBox;
    }

    public void loadScreenControllers(){
        summaryScreen = new SummaryScreen();
        searchScreen = new SearchScreen();
        foodScreen = new FoodScreen();
        weighInScreen = new WeighInScreen();
        profileScreen = new ProfileScreen();
        historyScreen = new HistoryScreen();
    }

    public void setupHomeSession(){
        summaryScreen.setHomeScreen(homeScreen);
        summaryScreen.setSessionManager(sessionManager);
        foodScreen.setSessionManager(sessionManager);
        weighInScreen.setHomeScreen(homeScreen);
        weighInScreen.setSessionManager(sessionManager);
        profileScreen.setSessionManager(sessionManager);
        profileScreen.setHomeScreen(homeScreen);
        historyScreen.setSessionManager(sessionManager);
    }

    @Override
    public void setAppManager(AppManager appManager){
        this.appManager = appManager;
    }

}
