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

    public HotelDaoSQLImpl() {
        super("hotels");
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
