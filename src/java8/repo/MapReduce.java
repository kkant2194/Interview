package java8.repo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class MapReduce {

    public static void main(String[] args) {

        Predicate<Person> p1 = p ->p.getHeight() >=140;
        Predicate<Person> p2 = p ->p.getGender().equals("Male");

        List<Integer> list = Arrays.asList(1,2,3,4,5);
        System.out.println("Sum of Integers without reduce");
        long sum = list.stream()
                .mapToInt(i ->i)
                .sum();
        System.out.println(sum);

        System.out.println("Sum of Integers using reduce");
        long sumr = list.stream()
                        .reduce(0,(a,b) -> a+b);
        System.out.println(sumr);

        System.out.println("Product of Integers using reduce");
        long pro = list.stream()
                .reduce(1,(a,b) -> a*b);
        System.out.println(pro);

        System.out.println("Tallest Person by reduce");
        long tallest = PersonRepository.getAllPersons()
                .stream()
                .map(Person::getHeight)
                .reduce(0,(a,b) -> Math.max(a,b));
        System.out.println(tallest);

        Optional<Person> per = PersonRepository.getAllPersons()
                .stream()
                .reduce((a,b) ->a.getHeight()> b.getHeight()?a:b);
        System.out.println(per.get());

        System.out.println("Kids Count");
        int countOfKid = PersonRepository.getAllPersons()
                .stream()
                .filter(p1.and(p2))
                .map(Person::getKids)
               // .reduce(0,Integer::sum);
                .reduce(0,(a,b) -> a+b);

        System.out.println(countOfKid);
    }
}
