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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.Node;

public class HomeScreen extends GridPane implements ManagedScreen, UserControl{

    private ScreenManager screenManager;
    private UserManager userManager;
    private HomeScreen homeScreen;


    private Node previousContent;
    //private ScreenManager homeViewManager;
    @FXML private ChoiceBox menuChoiceBox;
    @FXML private TextField searchTextField;
    @FXML private StackPane contentStackPane;
    private FoodsVBox foodsVBox;
    private UserSummaryScreen userSummaryVBox;
    private SearchScreen searchScreen;
    private UserWeighIn weighInScreen;
    private UserEditScreen userEditScreen;

    public HomeScreen(){
        System.out.println("HomeScreen Constructor");
        this.homeScreen = this;
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
        menuChoiceBox.setValue("Search");
        searchScreen.getSearchResults(searchTextField.getText());
    }

    public void handleMenuChoiceBox(ActionEvent actionEvent){
        System.out.println(menuChoiceBox.getValue().toString() + " was selected.");
        removeContent();
        contentStackPane.getChildren().removeAll();
        String selectedContent = menuChoiceBox.getValue().toString();
        switch(selectedContent){
            case "Home":
                contentStackPane.getChildren().add(0, userSummaryVBox);
                userSummaryVBox.setLabels();
                break;
            case "Search":
                contentStackPane.getChildren().add(0, searchScreen);
                break;
            case "Foods":
                foodsVBox.setFoodListView();
                contentStackPane.getChildren().add(0, foodsVBox);
                break;
            case "Weigh-In":
                contentStackPane.getChildren().add(0, weighInScreen);
                break;
            case "Edit Profile":
                contentStackPane.getChildren().add(0, userEditScreen);
                break;
            case "Change User":
                screenManager.show(Screen.USER_LOG_IN);
                break;
            default:
                System.out.println("default case executed in handleMenuChoiceBox method of HomeScreen");
                contentStackPane.getChildren().add(0, userSummaryVBox);
                break;
        }
    }

    public void loadMenuChoiceBox(){
        //TODO create contentView enum and use it to populate the menuChoiceBox
        ObservableList<String> list = FXCollections.observableArrayList("Home", "Foods", "Weigh-In", "Search", "Edit Profile","Change User");
        menuChoiceBox.setItems(list);
        menuChoiceBox.setValue("Home");
    }

    @FXML
    private void initialize(){
        System.out.println("HomeScreen initialized.");

        loadContent();


        //This is needed
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                System.out.println("Run later");
                userManager = screenManager.getUserManager();
                System.out.println(userManager.getUser().getName());
                foodsVBox.setUserManager(userManager);
                userSummaryVBox.setUserManager(userManager);
                //userSummaryVBox.setLabels();//call label setup here.
                weighInScreen.sethomeScreen(homeScreen);
                userSummaryVBox.sethomeScreen(homeScreen);
                userEditScreen.sethomeScreen(homeScreen);
                userEditScreen.setUserManager(userManager);
                loadMenuChoiceBox();
            }
        });
    }

    public ChoiceBox getMenuChoiceBox(){
        return menuChoiceBox;
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
        searchScreen = new SearchScreen();
        foodsVBox = new FoodsVBox();
        userSummaryVBox = new UserSummaryScreen();
        weighInScreen = new UserWeighIn();
        userEditScreen = new UserEditScreen();
    }


}
