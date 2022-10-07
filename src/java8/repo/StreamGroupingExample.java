package java8.repo;

import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamGroupingExample {

    static Map<String, List<Person>> groupingDataBasedOnGender(){
        Map<String, List<Person>> grpOnGender = PersonRepository.getAllPersons()
                .stream()
                .collect(Collectors.groupingBy(Person::getGender));
        return grpOnGender;
    }

    static Map<String, List<Person>> groupingDataBasedOnHeight() {
        Map<String, List<Person>> grpOnHeight = PersonRepository.getAllPersons()
                .stream()
                .collect(Collectors.groupingBy(p -> p.getHeight() >= 140 ? "Tallest" : "Shortest"));
        return grpOnHeight;
    }

    static Map<String, Map<String, List<Person>>> twoLevelGrouping() {
        Map<String, Map<String, List<Person>>> twoLevelGrp = PersonRepository.getAllPersons()
                .stream()
                .collect(Collectors.groupingBy(Person::getGender,
                        Collectors.groupingBy(p -> p.getHeight() >= 140 ? "Tallest" : "Shortest")));
       return twoLevelGrp;
    }
    // group name with count of kids
    static Map<String, Integer> twoLevelGroupingCounting() {
        Map<String, Integer> collect = PersonRepository.getAllPersons()
                .stream()
                .collect(Collectors.groupingBy(Person::getName,
                        Collectors.summingInt(Person::getKids)));

       return collect;
    }

    static HashMap<String, List<Person>> threeLevelGrouping(){
        HashMap<String, List<Person>> threeLevelGrp = PersonRepository.getAllPersons()
                .stream()
                .collect(Collectors.groupingBy(Person::getName, HashMap::new, Collectors.toList()));

        return threeLevelGrp;
    }
    public static void main(String[] args) {
        System.out.println(groupingDataBasedOnGender());
        System.out.println(groupingDataBasedOnHeight());
        System.out.println(twoLevelGrouping());
        System.out.println(twoLevelGroupingCounting());
        System.out.println(threeLevelGrouping());
    }
}
