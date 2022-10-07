package java8.repo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamInterview {

    public static void main(String[] args) {

        // number and their squares
        List<Integer> list = Arrays.asList(2,3,4,5);
        Map<Integer, Integer> square = list.stream()
                .collect(Collectors.toMap(Function.identity(), x -> x * x));
        System.out.println(square);

        // count occurence
        List<String> fruits = Arrays.asList("apple","orange","apple","banana","orange");
        Map<String, Long> collect = fruits.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(collect);


    }
}
