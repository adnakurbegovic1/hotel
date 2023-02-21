package ba.unsa.etf.rpr.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ReservationTest {

    private Reservation r = new Reservation();
    private User u = new User();

    /**
     * Setting Room for testing
     */
    @BeforeEach
    public void setRoom() {
        u.setName("Adna");
        r.setId(1);
        r.setArrivalDate(LocalDate.MIN);
        r.setDepartudeDate(LocalDate.MAX);
        r.setRoomNumber(1);
        r.setUser(u);
    }

    /**
     * Method tests getter for attribute arrivalDate
     */
    @Test
    void getArrivalDate() {
        assertEquals(LocalDate.MIN, r.getArrivalDate());
    }

    @Test
    void getDepartudeDate() {
        assertEquals(LocalDate.MAX, r.getDepartudeDate());
    }

}