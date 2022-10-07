package java8.repo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LimitSkip {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6);

        nums.stream().mapToDouble(i -> i).average().getAsDouble();
        int sum = nums.stream()
                .skip(2)
                .reduce(0,Integer::sum);
        System.out.println(sum);

        List<Integer> i = nums.stream()
                .limit(4)
                .collect(Collectors.toList());

        System.out.println(i);
    }
}
