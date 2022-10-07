package java8.repo;

import java.util.Collections;
import java.util.Comparator;

public class StreamCustomSortExample {
    public static void main(String[] args) {

        System.out.println("Sort By Name");
        PersonRepository.getAllPersons()
                .stream()
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);

        System.out.println("Sort By Height");
        PersonRepository.getAllPersons()
                .stream()
                .sorted(Comparator.comparing(Person::getHeight))
                .forEach(System.out::println);

        System.out.println("Sort By Height, if height same then by name");
        PersonRepository.getAllPersons()
                .stream()
                .sorted(Comparator.comparing(Person::getHeight).thenComparing(Person::getName))
                .forEach(System.out::println);

        System.out.println("Sort By Height, if height same then by name in JAVA7");
       Collections.sort(PersonRepository.getAllPersons(), (p1, p2) -> {
            if(p1.getHeight() == p2.getHeight()){
                return p1.getName().compareTo(p2.getName());
            }
            return p1.getHeight() - p2.getHeight();
        });
    }
}
