package java8.repo;

import java.util.Random;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class StreamFactory {

    static UnaryOperator<Integer> add = x -> x+5;
    public static void main(String[] args) {
        // iterate will generate infinite numbers unless and until we limit it and it accepts an unary operator
        Stream<Integer> s1 = Stream.iterate(0,add).limit(10);
        s1.forEach(System.out::println);

        Stream.generate(Math::random).limit(10).forEach(System.out::println);



    }
}
