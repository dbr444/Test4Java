package test4.zad3.services;

import test4.zad3.exceptions.InvalidPersonDataException;
import test4.zad3.exceptions.NoValidPeopleException;
import test4.zad3.exceptions.NoWomenException;
import test4.zad3.models.Person;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonService {
    public Person getOldestWoman(List<Person> people) {
        return people.stream()
                .peek(person -> validatePerson(person))
                .filter(person -> person.isFemale())
                .max(Comparator.comparingInt(Person::getAge))
                .orElseThrow(() -> new NoWomenException("No women in the list"));
    }

    public double getAverageAgeOfAllPeople(List<Person> people) {
        return people.stream()
                .peek(person -> validatePerson(person))
                .mapToInt(person -> person.getAge())
                .average()
                .orElseThrow(() -> new NoValidPeopleException("No valid people in the list"));

    }

    public double getAverageAgeOfMen(List<Person> people) {
        return people.stream()
                .peek(person -> validatePerson(person))
                .filter(person -> person.isMale())
                .mapToInt(person -> person.getAge())
                .average()
                .orElseThrow(() -> new NoValidPeopleException("No valid men in the list"));
    }

    public double getAverageAgeOfWomen(List<Person> people) {
        return people.stream()
                .peek(person -> validatePerson(person))
                .filter(person -> person.isFemale())
                .mapToInt(person -> person.getAge())
                .average()
                .orElseThrow(() -> new NoValidPeopleException("No valid women in the list"));
    }
    public double getAverageAgeByPredicate(List<Person> people, Predicate<Person> predicate) {
        return people.stream()
                .peek(person -> validatePerson(person))
                .filter(predicate)
                .mapToInt(person -> person.getAge())
                .average()
                .orElseThrow(() -> new NoValidPeopleException("No valid people in the list"));
    }

    public String getMostPopulatedCity(List<Person> people) {
        return people.stream()
                .peek(person -> validatePerson(person))
                .collect(Collectors.groupingBy(person -> person.getCity(), Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElseThrow(() -> new NoValidPeopleException("No valid people in the list"));
    }

    public Set<String> getUniqueCities(List<Person> people) {
        return people.stream()
                .peek(person -> validatePerson(person))
                .map(person -> person.getCity())
                .collect(Collectors.toSet());
    }

    //tutaj dalem jakas robocza minimalna walidacje dlugosci pola i wieku
    private void validatePerson(Person person) {
        validateField(person.getFirstName(), "first name");
        validateField(person.getLastName(), "last name");
        validateField(person.getCity(), "city");

        Optional.ofNullable(person.getAge())
                .filter(age -> age > 0)
                .orElseThrow(() -> new InvalidPersonDataException("Invalid field: " + "age"));
    }
    private void validateField(String field, String fieldName) {
        Optional.ofNullable(field)
                .filter(value -> value.length() >= 2)
                .orElseThrow(() -> new InvalidPersonDataException("Invalid field: " + fieldName));
    }
}
