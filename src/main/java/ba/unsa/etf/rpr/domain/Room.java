package ba.unsa.etf.rpr.domain;

import java.util.Objects;

public class Room {

    private int idRoom;
    private int capacity;
    private int price;
    private int hotelId;

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    @Override
    public String toString() {
        return "Room{" +
                "idRoom=" + idRoom +
                ", capacity=" + capacity +
                ", price=" + price +
                ", hotelId=" + hotelId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return idRoom == room.idRoom;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRoom, capacity, price, hotelId);
    }
}
