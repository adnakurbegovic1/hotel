package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.domain.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

/**
 * JavaFX controller for registration management
 *
 * @author Adna Kurbegović
 */
public class RegistrationController {
    public Button cancelBtn;
    public Button btnRegistration;
    public TextField nameId;
    public TextField surnameId;
    public TextField emailId;
    public PasswordField passwordId;

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

    public void registrationForNewUser(ActionEvent actionEvent) {
        try {
            User u = new User();
            u.setName(nameId.getText());
            u.setSurname(surnameId.getText());
            u.setPassword(passwordId.getText());
            u.setEmail(emailId.getText());
            UserManager.registration(u);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Registracija");
            alert.setHeaderText("Rezultat:");
            alert.setContentText("Uspješno ste se registrovali! Molimo Vas da se prijavite!");
            alert.showAndWait();

            Stage stage = (Stage) btnRegistration.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
            fxmlLoader.setController(new LoginController());
            Parent root = fxmlLoader.load();
            stage.setTitle("Prijava");
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setResizable(false);
            stage.show();

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

}
