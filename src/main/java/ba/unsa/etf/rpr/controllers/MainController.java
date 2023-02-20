package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.dao.RoomDao;
import ba.unsa.etf.rpr.dao.RoomDaoSQLImpl;
import ba.unsa.etf.rpr.domain.User;
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

/**
 * This class handles events for main page
 *
 *  @author Adna Kurbegović
 */
public class MainController {

    public ListView listOfRooms;
    public Button btnBooking;
    public Button btnAddRoom;
    public Button btnBack;

    public Button btnMyReservations;
    private RoomDaoSQLImpl dao;

    private User user;

    /**
     * Constructor without params
     */
    public MainController(){}

    /**
     * Constructor
     * @param user
     */
    public MainController(User user){
        this.user = user;
    }

    /**
     * Initialize method happens as soon as window is opened.
     */
    @FXML
    public void initialize() throws HotelException {
        dao = RoomDaoSQLImpl.getInstance();
        listOfRooms.setItems(dao.allRooms());
    }
    /**
     * This method opens reservation page.
     * @param event
     */
    public void goBookingRoom(ActionEvent event){
        try {
            Stage stage = (Stage) btnBooking.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/reservation.fxml"));
            ReservationController cont = new ReservationController(user);
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

    /**
     * This method opens addRoom page.
     * @param event
     */
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

    /**
     * This method returns user from main page to home page.
     * @param event
     */
    public void goBack(ActionEvent event){
        try {
            Stage stage = (Stage) btnBack.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/home.fxml"));
            HomeController cont = new HomeController();
            fxmlLoader.setController(cont);
            stage.setTitle("Hotel \"50 zvjezdica\"");
            stage.setScene(new Scene(fxmlLoader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setResizable(false);
            stage.show();
        }
        catch (Exception e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    public void viewMyReservation(ActionEvent event){
        try {
            Stage stage = (Stage) btnMyReservations.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/myReservations.fxml"));
            MyReservationsController cont = new MyReservationsController();
            fxmlLoader.setController(cont);
            stage.setTitle("Moje rezervacije");
            stage.setScene(new Scene(fxmlLoader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setResizable(false);
            stage.show();
        }
        catch (Exception e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
}
