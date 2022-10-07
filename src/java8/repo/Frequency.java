package java8.repo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Frequency {

    public static void main(String[] args) {
        String s = "abracadabra";
        Map<Character,Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
           map.put(ch,map.getOrDefault(ch,0) +1);
           /* if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }else{
                map.put(ch,1);
            }*/
        }
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }


    }
}
