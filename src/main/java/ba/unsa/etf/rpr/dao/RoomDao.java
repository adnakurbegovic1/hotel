package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Room;
import ba.unsa.etf.rpr.exceptions.HotelException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Dao interface for Room domain bean
 *
 * @author Adna Kurbegović
 */

public interface RoomDao  extends Dao<Room> {

    /**
     * Returns all rooms with the given capacity.
     *
     * @param capacity search string for rooms
     * @return list of rooms
     */
    List<Room> searchByCapacity(int capacity) throws HotelException;

    /**
     * Returns all rooms with the given price.
     *
     * @param price search string for rooms
     * @return list of rooms
     */
    List<Room> searchByPrice(int price) throws HotelException;

    ObservableList<Room> allRooms() throws HotelException;

}
