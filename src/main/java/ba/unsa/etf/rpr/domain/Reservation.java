package ba.unsa.etf.rpr.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

/**
 * Domain Javabean class Reservation
 */
public class Reservation implements Idable {
    private int id;
    private LocalDate arrivalDate;
    private LocalDate departudeDate;
    private User user;

    private int roomNumber;

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public LocalDate getDepartudeDate() {
        return departudeDate;
    }

    public void setDepartudeDate(LocalDate departudeDate) {
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
                ", roomNumber=" + roomNumber +
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
        return Objects.hash(id, arrivalDate, departudeDate, user, roomNumber);
    }
}
