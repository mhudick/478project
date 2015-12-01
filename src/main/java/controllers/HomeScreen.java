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

    private AppManager appManager;
    private SessionManager sessionManager;
    private HomeScreen homeScreen;


    private Node previousContent;
    //private AppManager homeViewManager;
    @FXML private ChoiceBox menuChoiceBox;
    @FXML private TextField searchTextField;
    @FXML private StackPane contentStackPane;

    //These are the controllers for each screen in the contentStackPane.
    private SummaryScreen summaryScreen;
    private SearchScreen searchScreen;
    private FoodScreen foodScreen;
    private WeighInScreen weighInScreen;
    private ProfileScreen profileScreen;
    private HistoryScreen historyScreen;


    public HomeScreen(){
        System.out.println("HomeScreen Constructor");
        this.homeScreen = this;
    }

    @FXML
    private void initialize(){
        System.out.println("HomeScreen initialized.");
        //This is needed
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                System.out.println("Run later");
                sessionManager = appManager.getSessionManager();
                loadScreenControllers();
                setupHomeSession();
                loadMenuChoiceBox();
            }
        });
    }

    public void handleSearchButton(ActionEvent actionEvent){
        System.out.println("Search button clicked!");
        menuChoiceBox.setValue("Search");
        searchScreen.getSearchResults(searchTextField.getText());
        searchTextField.setText("");
    }

    public void handleMenuChoiceBox(ActionEvent actionEvent){
        System.out.println(menuChoiceBox.getValue().toString() + " was selected.");
        removeContent();
        contentStackPane.getChildren().removeAll();
        String selectedContent = menuChoiceBox.getValue().toString();
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
        //TODO create contentView enum and use it to populate the menuChoiceBox
        ObservableList<String> list = FXCollections.observableArrayList("Home", "Foods", "Weigh-In", "Search", "History", "Edit Profile","Change User");
        menuChoiceBox.setItems(list);
        menuChoiceBox.setValue("Home");
    }

    public void removeContent(){
        if(contentStackPane.getChildren().size() != 0){
            setPreviousContent((Node) contentStackPane.getChildren().remove(0));
        }
    }

    public void setPreviousContent(Node previousContent){
        this.previousContent = previousContent;
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
        searchScreen.setHomeScreen(homeScreen);
        searchScreen.setSessionManager(sessionManager);
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
