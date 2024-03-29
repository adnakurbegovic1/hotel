package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Reservation;
import ba.unsa.etf.rpr.domain.Room;
import ba.unsa.etf.rpr.exceptions.HotelException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.*;
import java.util.Date;


/**
 * MySQL implementation of DAO
 * @author Adna Kurbegović
 */

public class ReservationDaoSQLImpl extends AbstractDao<Reservation> implements ReservationDao{

    private static ReservationDaoSQLImpl instance = null;
    public ReservationDaoSQLImpl() {
        super("reservations");
    }

    /**
     * @return ReservationDaoSQLImpl
     * We don't need more than one object for CRUD operations on table 'reservations' so we will use Singleton
     * This method will call private constructor in instance==null and then return that instance
     */
    public static ReservationDaoSQLImpl getInstance(){
        if(instance==null)
            instance = new ReservationDaoSQLImpl();
        return instance;
    }
    public static void removeInstance(){
        if(instance!=null)
            instance=null;
    }

    /**
     * Method for mapping ResultSet into Object
     * @param rs - result set from database
     * @return a Bean object for reservations table
     * @throws HotelException in case of error with db
     */
    @Override
    public Reservation row2object(ResultSet rs) throws HotelException {
        try{
            Reservation r = new Reservation();
            r.setId(rs.getInt("id"));
            r.setArrivalDate(rs.getDate("arrivalDate").toLocalDate());
            r.setDepartudeDate(rs.getDate("departudeDate").toLocalDate());
            r.setUser(DaoFactory.userDao().getById(rs.getInt("userId")));
            r.setRoomNumber(rs.getInt("roomNumber"));
            return r;
        }catch (SQLException e){
            throw new HotelException(e.getMessage(), e);
        }

    }

    /**
     * Method for mapping Object into Map
     * @param object - a bean object for reservations table
     * @return key, value sorted map of object
     */
    @Override
    public Map<String, Object> object2row(Reservation object) {
        Map<String, Object> item = new TreeMap<String, Object>();
        item.put("id", object.getId());
        item.put("arrivalDate", object.getArrivalDate());
        item.put("departudeDate", object.getDepartudeDate());
        item.put("userId", object.getUser().getId());
        item.put("roomNumber", object.getRoomNumber());
        return item;
    }

    /**
     * @param start, end search dates for reservations
     * @return list of reservations
     */
    @Override
    public List<Reservation> getByDateRange(Date start, Date end) throws HotelException {
        List<Reservation> reservations = new ArrayList<>();
        try{
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM reservations WHERE arrivalDate = ? AND departudeDate = ?");
            stmt.setObject(1, start);
            stmt.setObject(2, end);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                reservations.add(row2object(rs));
            }
            rs.close();
            return reservations;
        }catch (SQLException e){
            throw new HotelException(e.getMessage(), e);
        }
    }

    /**
     * @return list of reservations for user
     */

    @Override
    public ObservableList<Reservation> myReservations(Integer id) throws HotelException{
        String query = "SELECT * FROM reservations WHERE userId = ?";

        ObservableList<Reservation> result = FXCollections.observableArrayList();
        try {
            PreparedStatement stmt = getConnection().prepareStatement(query);
            stmt.setInt(1, id);
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
