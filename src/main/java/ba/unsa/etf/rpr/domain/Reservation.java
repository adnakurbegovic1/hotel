package ba.unsa.etf.rpr.domain;

import java.util.Date;
import java.util.Objects;

public class Reservation {
    private int idReservation;
    private Date arrivalDate;
    private Date departudeDate;
    private int roomId;
    private int userId;

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

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "idReservation=" + idReservation +
                ", arrivalDate=" + arrivalDate +
                ", departudeDate=" + departudeDate +
                ", roomId=" + roomId +
                ", userId=" + userId +
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
        return Objects.hash(idReservation, arrivalDate, departudeDate, roomId, userId);
    }
}
