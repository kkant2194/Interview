package java8.repo;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamJoiningExample {

    static String joiningExample(){
        String s = PersonRepository.getAllPersons()
                .stream()
                .map(Person::getName)
                //.collect(Collectors.joining());   // normal without parameters
                //.collect(Collectors.joining("-"));  // with delimiter as parameter
                .collect(Collectors.joining("-","[","]")); // with delimiter prefix and suffix
        return s;
    }

    public static void main(String[] args) {
        char [] ch = {'a','b','c','d','e'};
        // String::new ----> arr -> new String(arr)
        String join = Stream.of(ch).
                map(String::new).
                collect(Collectors.joining());
       // System.out.println(join);

        String join1 = Stream.of(ch).map(String::new).collect(Collectors.joining("-","[","]"));
       // System.out.println(join1);

        System.out.println("All names using joining -->" + joiningExample());

    }
}
