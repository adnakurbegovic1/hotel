package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Reservation;
import ba.unsa.etf.rpr.exceptions.HotelException;

public class ReservationManager {
    public static Reservation addReservation(Reservation reservation) throws HotelException {
        try {
            return DaoFactory.reservationDao().add(reservation);
        } catch (HotelException e) {
            throw e;
        }
    }
}
