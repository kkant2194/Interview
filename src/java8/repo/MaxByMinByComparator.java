package java8.repo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MaxByMinByComparator {

    public static void main(String[] args) {
        System.out.println("Get Tallest Person Using Max By");
        Optional<Person> tallestPerson = PersonRepository.getAllPersons()
                .stream()
                .collect(Collectors.maxBy(Comparator.comparing(Person::getHeight)));
        System.out.println(tallestPerson.get());


        System.out.println("Get Shortest Person Using Min By");
        Optional<Person> shortestPerson = PersonRepository.getAllPersons()
                .stream()
                .collect(Collectors.minBy(Comparator.comparing(Person::getHeight)));
        System.out.println(shortestPerson.get());

        System.out.println("Get list of tallest Person");
        List<Person> listOfTallest = new ArrayList<>();
        if(tallestPerson.isPresent()){
            listOfTallest = PersonRepository.getAllPersons()
                    .stream()
                    .filter(p -> tallestPerson.get().getHeight() == p.getHeight())
                    .collect(Collectors.toList());
        }

        System.out.println(listOfTallest);
    }
}
