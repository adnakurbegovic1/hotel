package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Room;
import ba.unsa.etf.rpr.exceptions.HotelException;

import java.sql.*;
import java.util.*;

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

    @Override
    public Room row2object(ResultSet rs) throws HotelException {
        try {
            Room r = new Room();
            r.setId(rs.getInt("id"));
            r.setCapacity(rs.getInt("capacity"));
            r.setPrice(rs.getInt("price"));
            r.setHotel(DaoFactory.hotelDao().getById(rs.getInt("hotelId")));
            r.setReservation(DaoFactory.reservationDao().getById(rs.getInt("reservationId")));
            return r;
        } catch (Exception e) {
            throw new HotelException(e.getMessage(), e);
        }
    }
    @Override
    public Map<String, Object> object2row(Room object) {
        Map<String, Object> item = new TreeMap<String, Object>();
        item.put("id", object.getId());
        item.put("capacity", object.getCapacity());
        item.put("price", object.getPrice());
        item.put("hotelId", object.getHotel().getId());
        item.put("reservationId", object.getReservation().getId());
        return item;
    }
    /**
     * @param capacity search string for quotes
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
     * @param price search string for quotes
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
}
