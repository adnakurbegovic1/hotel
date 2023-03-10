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

    /**
     *This method logs user in o
     * @param email
     * @param password
     * @return user from database
     * @throws HotelException
     */
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
     * This method checks if the name is valid
     * @param name
     * @return boolean
     */
    public static boolean isNameValid(String name) {
        boolean valid = true;
        if(name.equals("") ) valid = false;
        return valid;
    }

    /**
     * This method checks if the surname is valid
     * @param surname
     * @return boolean
     */

    public static boolean isSurnameValid(String surname) {
        boolean valid = true;
        if(surname.equals("") ) valid = false;
        return valid;
    }

    /**
     * This method checks if the email is valid
     * @param email
     * @return boolean
     */

    public static boolean isEmailValid(String email) {
        boolean valid = true;
        if(email.equals("") ) valid = false;
        return valid;
    }

    /**
     * This method checks if the password is valid
     * @param password
     * @return boolean
     */
    public static boolean isPasswordValid(String password) {
        boolean valid = true;
        if(password.equals("") ) valid = false;
        return valid;
    }
    /**
     * This method adds new user
     * @param user
     * @return
     * @throws HotelException
     */
    public static User registration(User user) throws HotelException {

        if ((!isNameValid(user.getName())) || (!isPasswordValid(user.getPassword())) || (!isEmailValid(user.getEmail())) || (!isSurnameValid(user.getSurname()))) {
            throw new HotelException("Polja ne smiju biti prazna!");
        }
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
