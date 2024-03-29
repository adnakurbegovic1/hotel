package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.HotelException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

/**
 * MySQL implementation of DAO
 * @author Adna Kurbegović
 */
public class UserDaoSQLImpl extends AbstractDao<User> implements UserDao{

    public UserDaoSQLImpl() {
        super("users");
    }

    private static UserDaoSQLImpl instance = null;

    /**
     * @return UserDaoSQLImpl
     * We don't need more than one object for CRUD operations on table 'users' so we will use Singleton
     * This method will call private constructor in instance==null and then return that instance
     */
    public static UserDaoSQLImpl getInstance(){
        if(instance==null)
            instance = new UserDaoSQLImpl();
        return instance;
    }

    public static void removeInstance(){
        if(instance!=null)
            instance=null;
    }

    /**
     * Method for mapping ResultSet into Object
     * @param rs - result set from database
     * @return a Bean object for users table
     * @throws HotelException in case of error with db
     */
    @Override
    public User row2object(ResultSet rs) throws HotelException {
        try {
            User u = new User();
            u.setId(rs.getInt("id"));
            u.setName(rs.getString("name"));
            u.setSurname(rs.getString("surname"));
            u.setEmail(rs.getString("email"));
            u.setPassword(rs.getString("password"));
            return u;
        } catch (SQLException e) {
            throw new HotelException(e.getMessage(), e);
        }
    }

    /**
     * Method for mapping Object into Map
     * @param object - a bean object for users table
     * @return key, value sorted map of object
     */
    @Override
    public Map<String, Object> object2row(User object) {
        Map<String, Object> row = new TreeMap<String, Object>();
        row.put("id", object.getId());
        row.put("name", object.getName());
        row.put("surname", object.getSurname());
        row.put("email", object.getEmail());
        row.put("password", object.getPassword());
        return row;
    }

    /**
     * @param email search string for users
     * @return user
     */
    public User getByEmail(String email) throws HotelException{
        String query = "SELECT * FROM  users  WHERE email = ?";
        try{
            PreparedStatement stmt = getConnection().prepareStatement(query);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                User result = row2object(rs);
                rs.close();
                return result;
            } else {
                throw new HotelException("Korisnik nije pronađen!");
            }
        } catch (SQLException e) {
            throw new HotelException(e.getMessage(), e);
        }
    }
}
