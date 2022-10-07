package java8.repo;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SimpleStreamExample {

    public static void main(String[] args) {

        Predicate<Person> p1 = p ->p.getHeight() >=140;
        Predicate<Person> p2 = p ->p.getGender().equals("Male");
        BiPredicate<Integer,String> p3 = (height,gender) -> height >= 140 && gender.equals("Male");

        Map<String, List<String>> pmap = PersonRepository.getAllPersons()
                .stream()
                //.filter(p -> p1.and(p2).test(p))
                .filter( p -> p3.test(p.getHeight(),p.getGender()))
                .collect(Collectors.toMap(Person::getName,Person::getHobbies));

        System.out.println(pmap);

        /* Get list of hobbies */
        List<String> personHobbies = PersonRepository.getAllPersons()
                .stream()
                .map(Person::getHobbies)
                .flatMap(List:: stream)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(personHobbies);
    }
}
