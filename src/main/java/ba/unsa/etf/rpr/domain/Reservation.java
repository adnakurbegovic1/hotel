package ba.unsa.etf.rpr.domain;

import java.util.Date;
import java.util.Objects;

public class Reservation implements Idable {
    private int id;
    private Date arrivalDate;
    private Date departudeDate;
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getDepartudeDate() {
        return departudeDate;
    }

    public void setDepartudeDate(Date departudeDate) {
        this.departudeDate = departudeDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", arrivalDate=" + arrivalDate +
                ", departudeDate=" + departudeDate +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, arrivalDate, departudeDate, user);
    }
}
