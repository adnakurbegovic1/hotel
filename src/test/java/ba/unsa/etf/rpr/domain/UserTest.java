package ba.unsa.etf.rpr.domain;

import org.junit.jupiter.api.BeforeEach;


class UserTest {
    private User user = new User();

    @BeforeEach
    public void setUser() {
        user.setId(1);
        user.setName("Adna");
        user.setSurname("Kurbegovic");
        user.setEmail("akurbegovi1@etf.unsa.ba");
        user.setPassword("adna");
    }
}