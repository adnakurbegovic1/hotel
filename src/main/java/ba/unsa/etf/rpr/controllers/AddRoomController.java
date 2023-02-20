package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.RoomManager;
import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.domain.Room;
import ba.unsa.etf.rpr.domain.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

/**
 * JavaFX controller for creation and alteration of Room object
 *
 * @author Adna Kurbegović
 */
public class AddRoomController {

    public Button btnAdd;
    public Button btnBack;
    public TextField capacityId;
    public TextField priceId;

    public void addNewRoom(ActionEvent actionEvent) {
        try {
            Room r = new Room();
            r.setCapacity(Integer.parseInt(capacityId.getText()));
            r.setPrice(Integer.parseInt(priceId.getText()));
            RoomManager.addRoom(r);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Nova soba");
            alert.setHeaderText("Rezultat:");
            alert.setContentText("Soba uspješno dodana u bazu!");
            alert.showAndWait();

            Stage stage = (Stage) btnAdd.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
            fxmlLoader.setController(new MainController());
            Parent root = fxmlLoader.load();
            stage.setTitle("*****");
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setResizable(false);
            stage.show();

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    /**
     * back button event handler
     * @param event
     */
    public void goBack(ActionEvent event){
        try {
            Stage stage = (Stage) btnBack.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
            MainController cont = new MainController();
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
