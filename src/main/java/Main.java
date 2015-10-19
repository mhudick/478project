import controllers.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.DataManager;

public class Main extends Application {

    private static final int APP_WIDTH = 400; //pixels
    private static final int APP_HEIGHT = 600; //pixels

    @Override
    public void start(Stage primaryStage)throws Exception {
        //load user interface
        Home root = new Home();
        Scene scene = new Scene(root, APP_WIDTH, APP_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        //load application database
        DataManager.checkForDatabase();

        //load user interface
        launch(args);
    }
}
