package ba.unsa.etf.rpr.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class UserTest {
    private User user = new User();

    /**
     * Setting User for testing
     */
    @BeforeEach
    public void setUser() {
        user.setId(1);
        user.setName("Adna");
        user.setSurname("Kurbegovic");
        user.setEmail("akurbegovi1@etf.unsa.ba");
        user.setPassword("adna");
    }

    /**
     * Method tests getter for attribute name
     */
    @Test
    void getName() {
        assertEquals("Adna", user.getName());
    }

    /**
     * Method tests getter for attribute surname
     */
    @Test
    void getSurname() {
        assertEquals("Kurbegovic", user.getSurname());
    }

    /**
     * Method tests getter for attribute email
     */
    @Test
    void getEmail() {
        assertEquals("akurbegovi1@etf.unsa.ba", user.getEmail());
    }

    @Test
    void getPassword() {
        assertEquals("adna", user.getPassword());
    }
}