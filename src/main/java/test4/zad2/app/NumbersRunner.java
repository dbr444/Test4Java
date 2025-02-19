package test4.zad2.app;

import test4.zad2.services.NumberService;
import java.util.Arrays;
import java.util.List;

public class NumbersRunner {
    public static void main(String[] args) {
        NumberService numberService = new NumberService();

        List<Integer> numbers = Arrays.asList(22,1,10,5,88,33,73,70,11);

        List<Integer> topFive = numberService.getTopFiveLargestNumbersFromList(numbers);
        System.out.println("5 największych liczb: " + topFive);
    }
}
