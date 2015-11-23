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
        UserManager userManager = new UserManager();
        ScreenManager appScreenManager = new ScreenManager();
        appScreenManager.setUserManager(userManager);

        //appScreenManager.loadScreen(Screen.HOME, Screen.HOME.getResourcePath());
        appScreenManager.loadScreen(Screen.USER_LOG_IN, Screen.USER_LOG_IN.getResourcePath());
        appScreenManager.loadScreen(Screen.CREATE_USER, Screen.CREATE_USER.getResourcePath());



        //Check if user already exist
        if(getUserCount() == 0){
            appScreenManager.show(Screen.CREATE_USER);
        }
        else{
            appScreenManager.show(Screen.USER_LOG_IN);
        }

        //Setup application stage
        Scene scene = new Scene(appScreenManager,APP_WIDTH,APP_HEIGHT);
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