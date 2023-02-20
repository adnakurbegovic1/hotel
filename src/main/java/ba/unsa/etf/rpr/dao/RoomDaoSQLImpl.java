package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Room;
import ba.unsa.etf.rpr.exceptions.HotelException;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.*;

/**
 * MySQL implementation of DAO
 * @author Adna Kurbegović
 */

public class RoomDaoSQLImpl extends AbstractDao<Room> implements RoomDao {

    private static RoomDaoSQLImpl instance = null;
    public RoomDaoSQLImpl() {
        super("rooms");
    }

    public static RoomDaoSQLImpl getInstance(){
        if(instance==null)
            instance = new RoomDaoSQLImpl();
        return instance;
    }

    public static void removeInstance(){
        if(instance!=null)
            instance=null;
    }

    /**
     * Method for mapping ResultSet into Object
     * @param rs - result set from database
     * @return a Bean object for rooms table
     * @throws HotelException in case of error with db
     */
    @Override
    public Room row2object(ResultSet rs) throws HotelException {
        try {
            Room r = new Room();
            r.setId(rs.getInt("id"));
            r.setCapacity(rs.getInt("capacity"));
            r.setPrice(rs.getInt("price"));
            return r;
        } catch (Exception e) {
            throw new HotelException(e.getMessage(), e);
        }
    }

    /**
     * Method for mapping Object into Map
     * @param object - a bean object for rooms table
     * @return key, value sorted map of object
     */
    @Override
    public Map<String, Object> object2row(Room object) {
        Map<String, Object> item = new TreeMap<String, Object>();
        item.put("id", object.getId());
        item.put("capacity", object.getCapacity());
        item.put("price", object.getPrice());
        return item;
    }
    /**
     * @param capacity search int for rooms
     * @return list of rooms
     * @author Adna Kurbegović
     */

    @Override
    public List<Room> searchByCapacity(int capacity) throws HotelException {

        String query = "SELECT * FROM rooms WHERE capacity = ?";
        try {
            PreparedStatement stmt = getConnection().prepareStatement(query);
            stmt.setInt(1, capacity);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Room> roomLista = new ArrayList<>();
            while (rs.next()) {
                roomLista.add(row2object(rs));
            }
            return roomLista;
        } catch (SQLException e) {
            throw new HotelException(e.getMessage(), e);
        }
    }

    /**
     * @param price search int for rooms
     * @return list of rooms
     * @author Adna Kurbegović
     */

    @Override
    public List<Room> searchByPrice(int price) throws HotelException {
        String query = "SELECT * FROM rooms WHERE price = ?";
        try {
            PreparedStatement stmt = getConnection().prepareStatement(query);
            stmt.setInt(1, price);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Room> roomLista = new ArrayList<>();
            while (rs.next()) {
                roomLista.add(row2object(rs));
            }
            return roomLista;
        } catch (SQLException e) {
            throw new HotelException(e.getMessage(), e);
        }
    }

    /**
     * @return list of all rooms
     */
    public ObservableList<Room> allRooms() throws HotelException{
        String query = "SELECT * FROM rooms";

        ObservableList<Room> result = FXCollections.observableArrayList();
        try {
            PreparedStatement stmt = getConnection().prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                result.add(row2object(rs));
            }
            return result;
        } catch (SQLException e) {
            throw new HotelException(e.getMessage(), e);
        }
    }
}
