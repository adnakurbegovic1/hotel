package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.ReservationManager;
import ba.unsa.etf.rpr.business.RoomManager;
import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Reservation;
import ba.unsa.etf.rpr.domain.Room;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.HotelException;
import javafx.beans.Observable;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

/**
 * This is terminal user interface
 */
public class App {

    /**
     * Main method
     *
     * @param args
     * @throws HotelException
     */
    public static void main(String[] args) throws HotelException {

        System.out.println("Za prijavu upišite P, a za registraciju R: ");
        Scanner scanner = new Scanner(System.in);
        String value;
        value = scanner.next();

        if (value.equals("P")) {
            String email;
            String password;
            System.out.println("Upišite email: ");
            Scanner newScaner = new Scanner(System.in);
            email = newScaner.next();
            System.out.println("Upišite password: ");
            password = scanner.next();
            User user = DaoFactory.userDao().getByEmail(email);

            while (true) {

                if (user != null && user.getPassword().equals(password)) {
                    System.out.println("Prijava uspješna!");
                    break;
                }

                if (user == null) {
                    System.out.println("Email nije ispravan. Ponovite unos! ");
                    String email2;
                    Scanner Scanner2 = new Scanner(System.in);
                    email2 = Scanner2.next();
                }

                if (!user.getPassword().equals(password)) {
                    System.out.println("Pogrešan password. Ponovite unos! ");
                    String password2;
                    Scanner Scanner2 = new Scanner(System.in);
                    password2 = Scanner2.next();
                    if (password.equals(user.getPassword())) break;
                }
            }
            showUser(user.getId());
        }

        if (value.equals("R")) {
            try {
                String name;
                String surname;
                String email;
                String password;

                System.out.println("Unesite ime: ");
                Scanner enterName = new Scanner(System.in);
                name = enterName.next();
                System.out.println("Unesite prezime: ");
                Scanner enterSurname = new Scanner(System.in);
                surname = enterSurname.next();
                System.out.println("Unesite email: ");
                Scanner enterEmail = new Scanner(System.in);
                email = enterEmail.next();
                System.out.println("Unesite password: ");
                Scanner enterPassword = new Scanner(System.in);
                password = enterPassword.next();


                User u = new User();
                u.setName(name);
                u.setSurname(surname);
                u.setEmail(email);
                u.setPassword(password);
                UserManager.registration(u);
                System.out.println("Uspješna registracija!");
                showUser(u.getId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Method that shows options for User
     * @param id
     * @throws HotelException
     */

    public static void showUser(int id) throws HotelException  {
        System.out.println("Imate sljedeće opcije: ");
        System.out.println("1: Dodavanje nove sobe");
        System.out.println("2: Rezervacija sobe");
        System.out.println("3: Pregled Vaših rezervacija");
        System.out.println("4: Pregled svih soba");
        Scanner scanner = new Scanner(System.in);
        int option;

        while(true) {
            System.out.println("Izaberite opciju: ");
            option = scanner.nextInt();
            if (option >= 1 && option <= 3) break;
            else System.out.println("Ponovite unos: ");
        }

        if (option == 1) {
            addNewRoom(id);
        }

        if (option == 2) {
            bookingRoom(id);
        }

        if (option == 3) {
            showMyReservations(id);
        }

        if (option == 4) {
            showAllRooms(id);
        }

    }

    /**
     * Method for adding new room
     * @param id
     * @throws HotelException
     */
    public static void addNewRoom(int id) throws HotelException {
        Integer capacity;
        Integer price;

        System.out.println("Upišite kapacitet sobe: ");
        Scanner capacityScanner = new Scanner(System.in);
        capacity = Integer.valueOf(capacityScanner.next());

        System.out.println("Unesite cijenu sobe: ");
        Scanner priceScanner = new Scanner(System.in);
        price = Integer.valueOf(priceScanner.next());


        Room room = new Room();
        room.setCapacity(capacity);
        room.setPrice(price);

        RoomManager.addRoom(room);
        System.out.println("Soba uspješno dodana! ");
        showUser(id);
    }

    /**
     * Method for adding new reservation
     * @param id
     * @throws HotelException
     */

    public static void bookingRoom(int id) throws HotelException {
        Integer roomNumber;
        LocalDate arrivalDate;
        LocalDate departureDate;

        System.out.println("Upišite broj sobe: ");
        Scanner rNScanner = new Scanner(System.in);
        roomNumber = Integer.valueOf(rNScanner.next());

        System.out.println("Unesite datum dolaska: ");
        Scanner aDScanner = new Scanner(System.in);
        arrivalDate = LocalDate.parse(aDScanner.next());

        System.out.println("Unesite datum odlaska: ");
        Scanner dDScanner = new Scanner(System.in);
        departureDate = LocalDate.parse(dDScanner.next());


        Reservation r = new Reservation();
        r.setRoomNumber(roomNumber);


        ReservationManager.addReservation(r);
        System.out.println("Soba uspješno rezervisana! ");
        showUser(id);
    }

    /**
     * Method that shows list of all rooms
     * @param id
     * @throws HotelException
     */
    private static void showAllRooms(int id) throws HotelException {
        ObservableList<Room> listOfRooms = DaoFactory.roomDao().allRooms();

        if (listOfRooms.isEmpty()) {
            System.out.println("Lista soba je prazna!");
            showUser(id);
            return;
        }

        System.out.println("Sve sobe: ");
        for (int i = 0; i < listOfRooms.size(); i++) {
            System.out.println("Broj sobe: " + listOfRooms.get(i).getId() + " | Kapacitet: " + listOfRooms.get(i).getCapacity() + " | Cijena: " + listOfRooms.get(i).getPrice());
        }
        showUser(id);
    }

    /**
     * Method that shows list of all reservations for user
     * @param id
     * @throws HotelException
     */
    private static void showMyReservations(int id) throws HotelException {
        ObservableList<Reservation> listOfReservations = DaoFactory.reservationDao().myReservations(id);

        if (listOfReservations.isEmpty()) {
            System.out.println("Nemate rezervacija!");
            showUser(id);
            return;
        }

        System.out.println("Sve sobe: ");
        for (int i = 0; i < listOfReservations.size(); i++) {
            System.out.println("Broj rezervacije: " + listOfReservations.get(i).getId() + " | Datum dolaska: " + listOfReservations.get(i).getArrivalDate() + " | Datum odlaska: " + listOfReservations.get(i).getDepartudeDate() + " | Gost: " + listOfReservations.get(i).getUser().getName() +  " " + listOfReservations.get(i).getUser().getSurname());
        }
        showUser(id);
    }



}