package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.dao.DaoFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

/**
 * This class handles events for home page
 */
public class HomeController {

    public Button loginBtn;
    public Button registrationBtn;

    public void showLoginPage(ActionEvent event){
        try {
            Stage stage = (Stage) loginBtn.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
            LoginController c = new LoginController();
            fxmlLoader.setController(c);
            stage.setTitle("Prijava");
            stage.setScene(new Scene(fxmlLoader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setResizable(false);
            stage.show();

        }
        catch (Exception e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    public void showRegistrationPage(ActionEvent event){
        try {
            Stage stage = (Stage) registrationBtn.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/registration.fxml"));
            RegistrationController c = new RegistrationController();
            fxmlLoader.setController(c);
            stage.setTitle("Registracija");
            stage.setScene(new Scene(fxmlLoader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setResizable(false);
            stage.setResizable(false);
            stage.show();

        }
        catch (Exception e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

}
