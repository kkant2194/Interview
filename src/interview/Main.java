package interview;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class Main {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(10,3,10,2,20);
        OptionalDouble average = list.stream().mapToInt(n -> n * n)
                .filter(n -> n >= 10).average();

        System.out.println(average.getAsDouble());
    }

}
