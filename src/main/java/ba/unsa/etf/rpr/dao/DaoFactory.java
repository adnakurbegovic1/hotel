package ba.unsa.etf.rpr.dao;

/**
 * Factory method for singleton implementation of DAOs
 * @author Adna Kurbegović
 */

public class DaoFactory {
    private static final HotelDao hotelDao = new HotelDaoSQLImpl();
    private static final ReservationDao reservationDao = new ReservationDaoSQLImpl();
    private static final RoomDao roomDao = new RoomDaoSQLImpl();
    private static final UserDao userDao = new UserDaoSQLImpl();

    private DaoFactory(){
    }

    public static HotelDao hotelDao(){
        return hotelDao;
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
