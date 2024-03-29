package ba.unsa.etf.rpr.dao;

/**
 * Factory method for singleton implementation of DAOs
 * @author Adna Kurbegović
 */

public class DaoFactory {
    private static final ReservationDao reservationDao = ReservationDaoSQLImpl.getInstance();
    private static final RoomDao roomDao = RoomDaoSQLImpl.getInstance();
    private static final UserDao userDao = UserDaoSQLImpl.getInstance();

    private DaoFactory(){
    }

    public static ReservationDao reservationDao(){
        return reservationDao;
    }

    public static RoomDao roomDao(){
        return roomDao;
    }

    public static UserDao userDao(){
        return userDao;
    }
}
