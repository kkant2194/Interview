package java8.repo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamMap {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Apple","Orange","Banana" ,"Pineapple");

        List<Integer> len  = fruits.stream()
                .map(f -> f.length())
                .collect(Collectors.toList());

        System.out.println(len);

        Map<String ,Integer> dd = fruits.stream()
                .collect(Collectors.toMap(Function.identity(),String::length));
        System.out.println(dd);

        List<Integer> oddNums = Arrays.asList(1,3,5,7);
        List<Integer> evenNums = Arrays.asList(2,4,6,8);

        List<List<Integer>> listOfList = Arrays.asList(oddNums,evenNums);
        System.out.println("Before FlatMap " + listOfList);

        List<Integer> ss = listOfList.stream()
                .flatMap(list -> list.stream())
                .collect(Collectors.toList());
        System.out.println("After flat map " +  ss);


    }
}
