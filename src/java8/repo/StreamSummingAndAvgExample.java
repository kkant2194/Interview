package java8.repo;

import java.util.List;
import java.util.stream.Collectors;

public class StreamSummingAndAvgExample {

    // can also be done through reduce
    static long sumTotalKids(){
        return PersonRepository.getAllPersons()
                .stream()
                .collect(Collectors.summingLong(Person::getKids));
    }

    static double averageHeight(){
        return PersonRepository.getAllPersons()
                .stream()
                .collect(Collectors.averagingDouble(Person::getHeight));
    }
    public static void main(String[] args) {
        System.out.println("Sum Using Summing " + sumTotalKids());
        System.out.println("Average  height averaging " + averageHeight());
        System.out.println("Printing All Person whose height is greater than avg height");
        double avgHt = averageHeight();
        List<Person> personList = PersonRepository.getAllPersons()
                .stream()
                .filter(p -> p.getHeight() > avgHt)
                .collect(Collectors.toList());

        System.out.println(personList);

    }
}
