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
 * JavaFX controller for login management
 *
 * @author Adna Kurbegović
 */
public class LoginController {

    public Button cancelBtn;
    public TextField emailId;
    public PasswordField passwordId;
    public Button BtnLogin;
    User u = new User();

    /**
     * This method returns user from login page to home page.
     * @param actionEvent
     */
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

    public void goToMain(ActionEvent event){
        try {
            u.setPassword(passwordId.getText());
            u.setEmail(emailId.getText());
            User user = UserManager.login(u.getEmail(), u.getPassword());
            Stage stage = (Stage) BtnLogin.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
            MainController cont = new MainController(user);
            fxmlLoader.setController(cont);
            stage.setTitle("*****");
            stage.setScene(new Scene(fxmlLoader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setResizable(false);
            stage.show();
        }
        catch (Exception e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
}
