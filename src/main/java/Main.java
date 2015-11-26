import controllers.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.database.DatabaseManager;
import util.database.UserData;
import util.database.UserDataImpl;

public class Main extends Application {

    //CONSTANTS
    private static final int APP_WIDTH = 400; //pixels
    private static final int APP_HEIGHT = 600; //pixels

    @Override
    public void start(Stage primaryStage)throws Exception {

        //load app screens

        AppManager appManager = new AppManager();

        //appManager.loadScreen(Screen.HOME, Screen.HOME.getResourcePath());
        appManager.loadScreen(Screen.USER_LOG_IN, Screen.USER_LOG_IN.getResourcePath());
        appManager.loadScreen(Screen.CREATE_USER, Screen.CREATE_USER.getResourcePath());

        //Check if user already exist
        if(getUserCount() == 0){
            appManager.show(Screen.CREATE_USER);
        }
        else{
            appManager.show(Screen.USER_LOG_IN);
        }

        //Setup application stage
        Scene scene = new Scene(appManager,APP_WIDTH,APP_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Calorie Counter");
        primaryStage.show();
    }

    public static void main(String[] args) {
        //If database does not exist it get created.
        DatabaseManager.checkForDatabase();

        launch(args);
    }

    private int getUserCount(){
        UserData userData = new UserDataImpl();
        return userData.getUserMap().size();
    }
}