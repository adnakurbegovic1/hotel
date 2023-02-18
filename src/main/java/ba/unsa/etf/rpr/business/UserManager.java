package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.HotelException;

public class UserManager {

    public static User login(String email, String password) throws HotelException {

        if (email == null || password.equals("")) {
            throw new HotelException("Polja ne smiju biti prazna!");
        }

        User u = DaoFactory.userDao().getByEmail(email);

        if (!u.getPassword().equals(password)) {
            throw new HotelException("Pogrešan password!");
        }

        return u;
    }
}
