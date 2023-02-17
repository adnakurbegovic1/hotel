package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class LoginController {

    public Button cancelBtn;
    public void backToHome(ActionEvent actionEvent) {
        try{
            Stage stage = (Stage) cancelBtn.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/home.fxml"));
            fxmlLoader.setController(new HomeController());
            Parent root = fxmlLoader.load();
            stage.setTitle("Hotel \"50 zvjezdica\"");
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
