import controllers.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.database.DatabaseManager;

public class Main extends Application {

    public static final String USER_LOG_SCREEN = "user_login";
    public final String USER_LOG_SCREEN_FXML = "/views/user_login.fxml";
    public static final String NEW_USER_SCREEN = "new_user";
    public static final String NEW_USER_SCREEN_FXML = "/views/new_user.fxml";
    public static final String USER_SUMMARY_SCREEN = "user_summary";
    public static final String USER_SUMMARY_SCREEN_FXML = "/views/user_summary.fxml";

    private static final int APP_WIDTH = 400; //pixels
    private static final int APP_HEIGHT = 600; //pixels

    @Override
    public void start(Stage primaryStage)throws Exception {

        ScreenManager mainContainer = new ScreenManager();
        mainContainer.loadScreen(USER_LOG_SCREEN,USER_LOG_SCREEN_FXML);
        mainContainer.loadScreen(NEW_USER_SCREEN,NEW_USER_SCREEN_FXML);
        //mainContainer.loadScreen(USER_SUMMARY_SCREEN,USER_SUMMARY_SCREEN_FXML);
        mainContainer.setScreen(USER_LOG_SCREEN);

        //load user interface
        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root,APP_WIDTH,APP_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        //load application database
        DatabaseManager.checkForDatabase();

        //load user interface
        launch(args);
    }
}