package java8.repo;

import java.util.List;
import java.util.stream.Collectors;

public class StreamMappingAndCounting {

    static List<String> mappingName(){
        List<String>  names  = PersonRepository.getAllPersons()
                .stream()
                .map(Person::getName)// Inorder to skip this step we will Collectors.mapping in collect
                .collect(Collectors.toList());


        List<String>  names1  = PersonRepository.getAllPersons()
                .stream()
                //.map(Person::getName)// Inorder to skip this step we will Collectors.mapping in collect
                .collect(Collectors.mapping(Person::getName,Collectors.toList()));
        return names1;
    }

    static long countPersonWithHeightMoreThan140(){
       return  PersonRepository.getAllPersons()
                .stream()
                .filter(p ->p.getHeight()>=140)
                .collect(Collectors.counting());
    }

    public static void main(String[] args) {
        System.out.println("Collectors.Mapping Example -- > " + mappingName());
        System.out.println("Person with height >= 140 --> " + countPersonWithHeightMoreThan140());

    }
}
