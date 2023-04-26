package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.dao.ReservationDaoSQLImpl;
import ba.unsa.etf.rpr.dao.RoomDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Reservation;
import ba.unsa.etf.rpr.domain.Room;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.HotelException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class MyReservationsController {
    public Button btnBack;

    private ReservationDaoSQLImpl dao;

    private User user;

    public TableView tableReservation;

    TableColumn id ;
    TableColumn arrivalDate ;
    TableColumn departudeDate;
    TableColumn roomNumber;

    /**
     * Constructor
     * @param user
     */

    public MyReservationsController(User user){
        this.user = user;
    }
    /**
     * Initialize method happens as soon as window is opened.
     */
    @FXML
    public void initialize() throws HotelException {
        dao = ReservationDaoSQLImpl.getInstance();
        id = new TableColumn<>("Broj rezervacije");
        arrivalDate = new TableColumn<>("Datum dolaska");
        departudeDate = new TableColumn<>("Datum odlaska");
        roomNumber = new TableColumn("Broj sobe");
        id.setCellValueFactory(new PropertyValueFactory<Reservation, String>("id"));
        arrivalDate.setCellValueFactory(new PropertyValueFactory<Reservation, String>("arrivalDate"));
        departudeDate.setCellValueFactory(new PropertyValueFactory<Reservation, String>("departudeDate"));
        roomNumber.setCellValueFactory(new PropertyValueFactory<Reservation, String>("roomNumber"));
        tableReservation.getColumns().addAll(id, arrivalDate, departudeDate, roomNumber); // add the columns to the TableView
        tableReservation.getItems().addAll(dao.myReservations(user.getId())); // add the data to the TableView
    }

    /**
     * This method returns user from main page to home page.
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
