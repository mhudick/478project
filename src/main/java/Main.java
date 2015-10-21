import util.database.DatabaseManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage)throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/main_screen.fxml"));

        Scene scene = new Scene(root, 1200, 800);
        primaryStage.setTitle("Nutrient Assistant");
        primaryStage.setScene(scene);
        primaryStage.show();
        DatabaseManager.checkForDatabase();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
