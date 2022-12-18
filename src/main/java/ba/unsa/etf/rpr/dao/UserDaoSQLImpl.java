package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Hotel;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.HotelException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

public class UserDaoSQLImpl extends AbstractDao<User> implements UserDao{

    public UserDaoSQLImpl() {
        super("users");
    }

    @Override
    public User row2object(ResultSet rs) throws HotelException {
        try {
            User u = new User();
            u.setId(rs.getInt("id"));
            u.setName(rs.getString("name"));
            u.setSurname(rs.getString("surname"));
            u.setEmail(rs.getString("email"));
            return u;
        } catch (SQLException e) {
            throw new HotelException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(User object) {
        Map<String, Object> row = new TreeMap<String, Object>();
        row.put("id", object.getId());
        row.put("name", object.getName());
        row.put("surname", object.getSurname());
        row.put("email", object.getEmail());
        return row;
    }
}
