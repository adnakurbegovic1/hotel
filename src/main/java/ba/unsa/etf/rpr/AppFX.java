package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.controllers.HomeController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

/**
 * Hello world!
 *
 */
public class AppFX extends Application {
    @Override
    public void start(Stage stage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/home.fxml"));
        HomeController homeController = new HomeController();
        fxmlLoader.setController(homeController);
        Parent root = fxmlLoader.load();

        stage.setTitle("Hotel \"50 zvjezdica\"");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(false);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

}
