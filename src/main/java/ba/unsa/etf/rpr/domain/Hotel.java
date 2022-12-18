package ba.unsa.etf.rpr.domain;

import java.util.Objects;

public class Hotel {

private int idHotel;
private int numberOfRooms;
private int numberOfStars;
private String name;

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public int getNumberOfStars() {
        return numberOfStars;
    }

    public void setNumberOfStars(int numberOfStars) {
        this.numberOfStars = numberOfStars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "idHotel=" + idHotel +
                ", numberOfRooms=" + numberOfRooms +
                ", numberOfStars=" + numberOfStars +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return idHotel == hotel.idHotel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idHotel, numberOfRooms, numberOfStars, name);
    }
}
