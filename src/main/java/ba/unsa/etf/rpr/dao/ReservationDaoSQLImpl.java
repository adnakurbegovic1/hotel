package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Reservation;
import ba.unsa.etf.rpr.exceptions.HotelException;

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

    public static ReservationDaoSQLImpl getInstance(){
        if(instance==null)
            instance = new ReservationDaoSQLImpl();
        return instance;
    }
    public static void removeInstance(){
        if(instance!=null)
            instance=null;
    }

    @Override
    public Reservation row2object(ResultSet rs) throws HotelException {
        try{
            Reservation r = new Reservation();
            r.setId(rs.getInt("id"));
            r.setArrivalDate(rs.getDate("arrivalDate"));
            r.setDepartudeDate(rs.getDate("departudeDate"));
            r.setUser(DaoFactory.userDao().getById(rs.getInt("userId")));
            r.setId(rs.getInt("roomNumber"));
            return r;
        }catch (SQLException e){
            throw new HotelException(e.getMessage(), e);
        }

    }

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
}
