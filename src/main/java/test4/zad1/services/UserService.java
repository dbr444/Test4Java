package test4.zad1.services;

import test4.zad1.exceptions.InvalidPeselException;
import java.time.LocalDate;
import java.util.Optional;

public class UserService {
    public int getUserNameLength(String name) {
        return Optional.ofNullable(name).map(u -> u.length()).orElse(0);
    }

    public LocalDate getUserBirthday(String pesel) {
        return Optional.ofNullable(pesel)
                .filter(p -> p.matches("\\d{11}"))
                .map(p -> getBirthDateFromPesel(p))
                .orElseThrow(() -> new InvalidPeselException("Incorrect PESEL"));
    }

    private LocalDate getBirthDateFromPesel(String pesel) {
        int year = Integer.valueOf(pesel.substring(0, 2));
        int month = Integer.valueOf(pesel.substring(2, 4));
        int day = Integer.valueOf(pesel.substring(4, 6));

        if (month > 12) {
            month -= 20;
            year += 2000;
        } else {
            year += 1900;
        }
        //tu dodalem fragment dla osob po 2000 roku

        return LocalDate.of(year, month, day);
    }
}
