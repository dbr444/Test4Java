package test4.zad1.app;

import test4.zad1.services.UserService;

import java.time.LocalDate;
import java.util.Scanner;

public class UserRunner {
    public static void main(String[] args) {
        UserService userService = new UserService();
        Scanner scanner = new Scanner(System.in);

        //imie
        System.out.println("Podaj swoje imie:");
        String name = scanner.nextLine();

        int nameLength = userService.getUserNameLength(name);
        System.out.println("Dlugosc imienia: " + nameLength);

        //pesel
        System.out.println("Podaj swoj PESEL:");
        String pesel = scanner.nextLine();

        LocalDate birthDate = userService.getUserBirthday(pesel);
        System.out.println("Data urodzenia: " + birthDate);


        scanner.close();
    }
}
