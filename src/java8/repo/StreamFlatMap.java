package java8.repo;

import java.util.List;
import java.util.stream.Collectors;

public class StreamFlatMap {

    public static void main(String[] args) {

        List<String> listOfHobbies = PersonRepository.getAllPersons()
                .stream()
                .map(Person::getHobbies)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(listOfHobbies);
    }
}
