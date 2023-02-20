package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.HotelException;

/**
 * Business Logic Layer for management of User
 *
 * @author Adna Kurbegović
 */
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

    /**
     * This method adds new user
     * @param user
     * @return
     * @throws HotelException
     */
    public static User registration(User user) throws HotelException {
        try {
            return DaoFactory.userDao().add(user);
        } catch (HotelException e) {
            if (e.getMessage().contains("email")) {
                throw new HotelException("Korisnik već postoji");
            }
            throw e;
        }
    }
}
