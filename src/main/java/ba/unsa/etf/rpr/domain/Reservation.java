package ba.unsa.etf.rpr.domain;

import java.util.Date;
import java.util.Objects;

public class Reservation {
    private int idReservation;
    private Date arrivalDate;
    private Date departudeDate;
    private User user;

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
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
                "idReservation=" + idReservation +
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
        return idReservation == that.idReservation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idReservation, arrivalDate, departudeDate, user);
    }
}
