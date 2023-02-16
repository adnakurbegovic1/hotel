package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Hotel;
import ba.unsa.etf.rpr.exceptions.HotelException;

import java.sql.*;
import java.util.Map;
import java.util.TreeMap;

/**
 * MySQL implementation of the DAO
 * @author Adna Kurbegović
 */

public class HotelDaoSQLImpl extends AbstractDao<Hotel> implements HotelDao{

    private static HotelDaoSQLImpl instance = null;
    public HotelDaoSQLImpl() {
        super("hotels");
    }

    public static HotelDaoSQLImpl getInstance(){
        if(instance==null)
            instance = new HotelDaoSQLImpl();
        return instance;
    }

    public static void removeInstance(){
        if(instance!=null)
            instance=null;
    }

    @Override
    public Hotel row2object(ResultSet rs) throws HotelException {
        try {
            Hotel h = new Hotel();
            h.setId(rs.getInt("id"));
            h.setNumberOfRooms(rs.getInt("numberOfRooms"));
            h.setNumberOfStars(rs.getInt("numberOfStars"));
            h.setName(rs.getString("name"));
            return h;
        } catch (SQLException e) {
            throw new HotelException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(Hotel object) {
        Map<String, Object> row = new TreeMap<String, Object>();
        row.put("id", object.getId());
        row.put("numberOfRooms", object.getNumberOfRooms());
        row.put("numberOfStars", object.getNumberOfStars());
        row.put("name", object.getName());
        return row;
    }

}
