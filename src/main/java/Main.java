import controllers.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.database.DatabaseManager;
import util.database.UserData;

public class Main extends Application {

    //CONSTANTS
    private static final int APP_WIDTH = 400; //pixels
    private static final int APP_HEIGHT = 600; //pixels

    @Override
    public void start(Stage primaryStage)throws Exception {
        //load app screens
        ScreenManager appScreenManager = new ScreenManager();
        appScreenManager.loadScreen(Screen.HOME, Screen.HOME.getResourcePath());
        appScreenManager.loadScreen(Screen.USER_LOG_IN, Screen.USER_LOG_IN.getResourcePath());
        appScreenManager.loadScreen(Screen.CREATE_USER, Screen.CREATE_USER.getResourcePath());
        if(getUserCount() == 0){//there are no users, show the create_user screen
            appScreenManager.show(Screen.CREATE_USER);
        }
        else{
            appScreenManager.show(Screen.USER_LOG_IN);
        }

        //load user interface
        Scene scene = new Scene(appScreenManager,APP_WIDTH,APP_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        //load application database
        DatabaseManager.checkForDatabase();

        //load user interface
        launch(args);
    }

    private int getUserCount(){
        UserData userData = new UserData();
        return userData.getAllUsers().size();
    }
}