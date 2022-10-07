package java8.repo;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStream {

    public static void main(String[] args) {
        IntStream intStream = IntStream.rangeClosed(1,6);
        System.out.println("Sum Using int stream " + intStream.sum());
        LongStream.range(1,10).forEach(System.out::println); // range excludes last number
        LongStream.rangeClosed(1,10).forEach(System.out::println); // range includes last number

        System.out.println("==================================================================");

        LongStream longStreamSum = LongStream.rangeClosed(1,50);
        System.out.println("Sum --->" + longStreamSum.sum());
        LongStream longStreamMax = LongStream.rangeClosed(1,50);
        System.out.println("Max --->" + longStreamMax.max().getAsLong());
        LongStream longStreamMin = LongStream.rangeClosed(1,50);
        System.out.println("Min --->" + longStreamMin.min().getAsLong());
        LongStream longStreamAvg = LongStream.rangeClosed(1,50);
        System.out.println("Avg --->" + longStreamAvg.average().getAsDouble());
    }
}
