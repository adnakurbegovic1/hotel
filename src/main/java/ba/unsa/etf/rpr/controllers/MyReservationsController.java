package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.dao.ReservationDaoSQLImpl;
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

public class MyReservationsController {
    public Button btnBack;

    public ListView listOfReservations;

    private ReservationDaoSQLImpl dao;

    @FXML
    public void initialize() throws HotelException {
        dao = ReservationDaoSQLImpl.getInstance();
        listOfReservations.setItems(dao.myReservations());
    }
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
