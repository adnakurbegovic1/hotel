package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Room;
import ba.unsa.etf.rpr.exceptions.HotelException;

/**
 * Business Logic Layer for management of Room
 *
 * @author Adna Kurbegović
 */
public class RoomManager {

    /**
     * This method adds room
     * @param room
     * @return
     * @throws HotelException
     */
    public static Room addRoom(Room room) throws HotelException {
        try {
            return DaoFactory.roomDao().add(room);
        } catch (HotelException e) {
            throw e;
        }
    }
}
