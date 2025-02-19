package test4.zad2.services;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class NumberService {
    public List<Integer> getTopFiveLargestNumbersFromList(List<Integer> numbers) {
        return Optional.ofNullable(numbers)
                .filter(list -> list.size() >= 5)
                .map(list -> list.stream()
                .sorted(Comparator.reverseOrder())
                .limit(5)
                .collect(Collectors.toList()))
                .orElse(Collections.emptyList());
    }
}
