package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Reservation;
import ba.unsa.etf.rpr.exceptions.HotelException;
import javafx.collections.ObservableList;

import java.util.Date;
import java.util.List;

/**
 * Dao interface for Reservation domain bean
 *
 * @author Adna Kurbegović
 */

public interface ReservationDao  extends Dao<Reservation>{

    /**
     * Search reservations in database based on date range
     * @param start start date
     * @param end end date
     * @return List of reservations
     */
    List<Reservation> getByDateRange(Date start, Date end) throws HotelException;

    ObservableList<Reservation> myReservations(Integer id) throws HotelException;
}
