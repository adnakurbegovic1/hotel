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

public class LoginController {

    public Button cancelBtn;
    public TextField emailFld;
    public PasswordField passwordFld;
    public Button btnLogin;
    User u = new User();
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
            u.setPassword(passwordFld.getText());
            u.setEmail(emailFld.getText());
            UserManager.login(u.getEmail(), u.getPassword());
            Stage stage = (Stage) btnLogin.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
            MainController cont = new MainController();
            fxmlLoader.setController(cont);
            stage.setTitle("*");
            stage.setScene(new Scene(fxmlLoader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setResizable(false);
            stage.show();
        }
        catch (Exception e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
}
