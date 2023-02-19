package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.dao.RoomDao;
import ba.unsa.etf.rpr.dao.RoomDaoSQLImpl;
import ba.unsa.etf.rpr.exceptions.HotelException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class MainController {

    public ListView listOfRooms;
    public Button btnBooking;
    public Button btnAddRoom;
    private RoomDaoSQLImpl dao;
    @FXML
    public void initialize() throws HotelException {
        dao = RoomDaoSQLImpl.getInstance();
        listOfRooms.setItems(dao.allRooms());
    }
    public void goBookingRoom(ActionEvent event){
        try {
            Stage stage = (Stage) btnBooking.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/reservation.fxml"));
            ReservationController cont = new ReservationController();
            fxmlLoader.setController(cont);
            stage.setTitle("Rezervacija");
            stage.setScene(new Scene(fxmlLoader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setResizable(false);
            stage.show();
        }
        catch (Exception e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    public void addNewRoom(ActionEvent event){
        try {
            Stage stage = (Stage) btnAddRoom.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/addRoom.fxml"));
            AddRoomController cont = new AddRoomController();
            fxmlLoader.setController(cont);
            stage.setTitle("Nova soba:");
            stage.setScene(new Scene(fxmlLoader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setResizable(false);
            stage.show();
        }
        catch (Exception e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
}
