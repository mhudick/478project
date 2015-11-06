/* Developer: Mark Donile
** Date: 2015.10.31
** Configuration Version: 1.0.0
*/

package controllers;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.Node;
import util.web.WebAccess;
import util.web.WebAccessImpl;

public class HomeController extends GridPane implements ManagedScreen, UserControl{

    private ScreenManager screenManager;
    private UserManager userManager;

    private WebAccess webAccess = new WebAccessImpl();

    private Node previousContent;
    //private ScreenManager homeViewManager;
    @FXML private ChoiceBox menuChoiceBox;
    @FXML private TextField searchTextField;
    @FXML private StackPane contentStackPane;
    private FoodsVBox foodsVBox;
    private UserSummaryVBox userSummaryVBox;
    private RecipesVBox recipesVBox;
    private DailyTrackerVBox dailyTrackerVBox;
    private SearchController searchController;

    public HomeController(){
        System.out.println("HomeController Constructor");
    }

    @Override
    public void setScreenManager(ScreenManager screenManager){
        this.screenManager = screenManager;
    }

    @Override
    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    public void handleSearchButton(ActionEvent actionEvent){
        System.out.println("Search button clicked!");
        removeContent();
        contentStackPane.getChildren().add(0, searchController);
        ObservableList<String> data = FXCollections.observableArrayList(webAccess.searchForFood(searchTextField.getText()));
        System.out.println(data.toString());
        //searchController.searchListView.setItems(data);
    }

    public void handleMenuChoiceBox(ActionEvent actionEvent){
        System.out.println(menuChoiceBox.getValue().toString() + " was selected.");
        removeContent();
        String selectedContent = menuChoiceBox.getValue().toString();
        switch(selectedContent){
            case "Home":
                contentStackPane.getChildren().add(0, userSummaryVBox);
                break;
            case "Foods":
                contentStackPane.getChildren().add(0, foodsVBox);
                break;
            case "Recipes":
                contentStackPane.getChildren().add(0, recipesVBox);
                break;
            case "Daily Tracker":
                contentStackPane.getChildren().add(0, dailyTrackerVBox);
                break;
            case "Change User":
                screenManager.show(Screen.USER_LOG_IN);
                break;
            default:
                System.out.println("default case executed in handleMenuChoiceBox method of HomeController");
                contentStackPane.getChildren().add(0, userSummaryVBox);
                break;
        }
    }

    public void loadMenuChoiceBox(){
        //TODO create contentView enum and use it to populate the menuChoiceBox
        ObservableList<String> list = FXCollections.observableArrayList("Home",
                                                                        "Foods",
                                                                        "Recipes",
                                                                        "Daily Tracker",
                                                                        "Weigh-In",
                                                                        "Exercise",
                                                                        "Change User");
        menuChoiceBox.setItems(list);
        menuChoiceBox.setValue("Home");
    }

    @FXML
    private void initialize(){
        System.out.println("HomeController initialized.");

        loadContent();
        loadMenuChoiceBox();

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                System.out.println("Run later");
                userManager = screenManager.getUserManager();
                System.out.println(userManager.getUser().getName());
                recipesVBox.setUserManager(userManager);
            }
        });
        //TODO show user_summary.fxml in contentStackPane
    }



    public void removeContent(){
        if(contentStackPane.getChildren().size() != 0){
            setPreviousContent((Node) contentStackPane.getChildren().remove(0));
        }
    }

    public void setPreviousContent(Node previousContent){
        this.previousContent = previousContent;
    }

    public void loadContent(){
        searchController = new SearchController();
        foodsVBox = new FoodsVBox();
        userSummaryVBox = new UserSummaryVBox();
        recipesVBox = new RecipesVBox();
        dailyTrackerVBox = new DailyTrackerVBox();
    }

    public void search(){
        String searchString = searchTextField.getText();
    }


}
