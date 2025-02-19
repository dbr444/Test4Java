package test4.zad3.app;

import test4.zad3.models.Person;
import test4.zad3.services.PersonService;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class PersonRunner {
    public static void main(String[] args) {
        PersonService personService = new PersonService();

        List<Person> people = Arrays.asList(
                new Person("Justyna", "Kowalczyk", "Warszawa", 44),
                new Person("Piotr", "Zyla", "Krakow", 34),
                new Person("Hanna", "Nowak", "Gdynia", 26),
                new Person("Otylia", "Jedrzejczak", "Gdynia", 41),
                new Person("Bartosz", "Kurek", "Czestochowa", 38)
        );

        //met1

        Person oldestWoman = personService.getOldestWoman(people);
        System.out.println("Oldest woman: " + oldestWoman);

        //met2
        double averageAgeOfAllPeople = personService.getAverageAgeOfAllPeople(people);
        System.out.println("Average age of all people: " + averageAgeOfAllPeople);

        //met3
        double averageMenAge = personService.getAverageAgeOfMen(people);
        System.out.println("Average age of men: " + averageMenAge);

        //met4
        double averageWomenAge = personService.getAverageAgeOfWomen(people);
        System.out.println("Average age of women: " + averageWomenAge);

        //met5
        double averageAgeByGenderOfWomen = personService.getAverageAgeByPredicate(people, person -> person.isFemale());
        System.out.println("Average age by gender of women: " + averageAgeByGenderOfWomen);

        double averageAgeByGenderOfMen = personService.getAverageAgeByPredicate(people, person -> person.isMale());
        System.out.println("Average age by gender of men: " + averageAgeByGenderOfMen);

        //met6
        String mostPopulatedCity = personService.getMostPopulatedCity(people);
        System.out.println("Most populated city: " + mostPopulatedCity);

        //met7
        Set<String> uniqueCities = personService.getUniqueCities(people);
        System.out.println("Unique cities: " + uniqueCities);

    }
}
