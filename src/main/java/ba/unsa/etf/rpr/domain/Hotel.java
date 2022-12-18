package ba.unsa.etf.rpr.domain;

import java.util.Objects;

public class Hotel implements Idable {

private int id;
private int numberOfRooms;
private int numberOfStars;
private String name;

    public int getId() {
        return id;
    }

    public void setId(int idHotel) {
        this.id = idHotel;
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
                "id=" + id +
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
        return id == hotel.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numberOfRooms, numberOfStars, name);
    }

}
