package ba.unsa.etf.rpr.domain;

import org.junit.jupiter.api.BeforeEach;

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
        r.setArrivalDate(LocalDate.MAX);
        r.setRoomNumber(1);
        r.setUser(u);
    }

}