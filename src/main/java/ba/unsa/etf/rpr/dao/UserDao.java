package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.HotelException;

/**
 * Dao interface for User domain bean
 *
 * @author Adna Kurbegović
 */

public interface UserDao  extends Dao<User>{
    User getByEmail(String email) throws HotelException;
}
