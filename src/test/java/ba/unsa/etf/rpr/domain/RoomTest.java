package ba.unsa.etf.rpr.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    private Room room = new Room();

    /**
     * Setting Room for testing
     */
    @BeforeEach
    public void setRoom() {
        room.setId(1);
        room.setCapacity(2);
        room.setPrice(50);
    }

    /**
     * Method tests getter for attribute capacity
     */
    @Test
    void getCapacity() {
        assertEquals(2, room.getCapacity());
    }

    /**
     * Method tests getter for attribute price
     */
    @Test
    void getPrice() {
        assertEquals(50, room.getPrice());
    }
}