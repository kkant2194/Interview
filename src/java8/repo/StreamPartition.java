package java8.repo;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamPartition {


    // partitionBy always returns a map
    static Map<Boolean, List<Person>> partitionByHeight(){
        Map<Boolean, List<Person>> partitionByHeight = PersonRepository.getAllPersons()
                .stream()
                .collect(Collectors.partitioningBy(p -> p.getHeight() >= 140));
        return partitionByHeight;
    }

    // partition By height and in map put name , hobbies

    static Map<Boolean, Map<String, List<String>>> byHeightAndCollectNameAndHobbiesInMap(){
        Map<Boolean, Map<String, List<String>>> collect = PersonRepository.getAllPersons()
                .stream()
                .collect(Collectors.partitioningBy(p -> p.getHeight() >= 140,
                        Collectors.toMap(Person::getName, Person::getHobbies)));
    return collect;
    }
    public static void main(String[] args) {
        System.out.println(partitionByHeight());
        System.out.println(byHeightAndCollectNameAndHobbiesInMap());
    }
}
