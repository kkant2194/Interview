package interview;

import java.util.HashMap;
import java.util.Map;

public class Practice {

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put(null,"abc");
        map.put(null,"pqr");
        System.out.println(map.get(null));
        Parent p = new Child();
        System.out.println(p.i);
    }
}
class Parent{
    int i=10;
}
class Child extends Parent{
    int i=20;
}