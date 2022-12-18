package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Room;
import ba.unsa.etf.rpr.exceptions.HotelException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class RoomDaoSQLImpl extends AbstractDao<Room> implements RoomDao {

    public RoomDaoSQLImpl() {
        super("rooms");
    }

    @Override
    public Room row2object(ResultSet rs) throws HotelException {
        try {
            Room r = new Room();
            r.setId(rs.getInt("id"));
            r.setCapacity(rs.getInt("capacity"));
            r.setPrice(rs.getInt("price"));
            r.setHotel(DaoFactory.categoryDao().getById(rs.getInt("hotelId")));
            r.setReservation(DaoFactory.categoryDao().getById(rs.getInt("reservationId")));
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
