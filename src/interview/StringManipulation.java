package interview;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringManipulation {

    public static void main(String[] args) {
        String input = "Java Hungry Blog Alive is Awesome";

        Character character = input.chars()
                .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s)))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(e -> e.getKey())
                .findFirst()
                .get();

        System.out.println(character);

    }
}
