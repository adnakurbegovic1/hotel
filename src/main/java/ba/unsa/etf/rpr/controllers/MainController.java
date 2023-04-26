package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.dao.RoomDao;
import ba.unsa.etf.rpr.dao.RoomDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Room;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.HotelException;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

/**
 * This class handles events for main page
 *
 *  @author Adna Kurbegović
 */
public class MainController {

    public TableView listOfRooms;
    public Button btnBooking;
    public Button btnAddRoom;
    public Button btnBack;

    public Button btnMyReservations;
    private RoomDaoSQLImpl dao;

    private User user;

    TableColumn id ;
    TableColumn capacity ;
    TableColumn price;

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

        id = new TableColumn<>("Broj sobe");
        capacity = new TableColumn<>("Kapacitet");
        price = new TableColumn<>("Cijena");

        dao = RoomDaoSQLImpl.getInstance();

        id.setCellValueFactory(new PropertyValueFactory<Room, String>("id"));
        capacity.setCellValueFactory(new PropertyValueFactory<Room, String>("capacity"));
        price.setCellValueFactory(new PropertyValueFactory<Room, String>("price"));

        listOfRooms.getColumns().addAll(id, capacity, price); // add the columns to the TableView
        listOfRooms.getItems().addAll(dao.allRooms()); // add the data to the TableView


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

    /**
     * This method opens myReservations page.
     * @param event
     */

    public void viewMyReservation(ActionEvent event){
        try {
            Stage stage = (Stage) btnMyReservations.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/myReservations.fxml"));
            MyReservationsController cont = new MyReservationsController(user);
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
