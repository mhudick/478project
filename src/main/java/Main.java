import util.DataManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage)throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/views/main_screen.fxml"));

        Scene scene = new Scene(root, 1200, 800);
        primaryStage.setTitle("Nutrient Assistant");
        primaryStage.setScene(scene);
        primaryStage.show();
        DataManager.checkForDatabase();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
