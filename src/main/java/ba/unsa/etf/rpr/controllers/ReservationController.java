package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.ReservationManager;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Reservation;
import ba.unsa.etf.rpr.domain.Room;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.HotelException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.skin.ChoiceBoxSkin;
import javafx.stage.Stage;


import java.util.ArrayList;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

/**
 * JavaFX controller for creation and alteration of Reservation object
 *
 * @author Adna Kurbegović
 */

public class ReservationController {

    public Button btnRezervisi;

    public Button btnBack;

    public ChoiceBox<Room> choiseBoxId ;


    public DatePicker arrivalDateId;
    public DatePicker departudeDateId;

    public User user;

    public void initialize() throws HotelException {
        ObservableList<Room> rooms = DaoFactory.roomDao().allRooms();
        choiseBoxId.setItems(rooms);
    }
    /**
     * Constructor
     * @param user
     */
    public ReservationController(User user){
        this.user = user;
    }


    /**
     * This method makes reservation
     * @param event
     */
    public void roomReservation(ActionEvent event){
        try {
            Reservation r = new Reservation();
            r.setRoomNumber((choiseBoxId.getValue().getId()));
            r.setArrivalDate(arrivalDateId.getValue());
            r.setDepartudeDate(departudeDateId.getValue());
            r.setUser(user);
            ReservationManager.addReservation(r);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Rezervacija");
            alert.setHeaderText("Rezultat:");
            alert.setContentText("Uspješno ste izvršili rezervaciju!");
            alert.showAndWait();

            Stage stage = (Stage) btnRezervisi.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
            fxmlLoader.setController(new MainController(user));
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
     * This method returns user to main page.
     * @param event
     */
    public void goBack(ActionEvent event){
        try {
            Stage stage = (Stage) btnBack.getScene().getWindow();
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
