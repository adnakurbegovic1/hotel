package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.HotelException;
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

    }



}