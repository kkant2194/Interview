package java8.repo;

public class ABC {

    public static void main(String[] args) throws Exception {

        System.out.println(Class.forName("String").getName());

        Integer i = 100;
        Integer j = 200;
        System.out.println(i ==j);
        System.out.println(i.equals(j));
        method(10);
        method(new Integer(20));
        method(new Integer(new Integer(30)));
        method(new Integer(null));
        method(null);
    }

    private static void method(Integer i) {
        System.out.println(i.toString());
    }

   /* private static void method(Number i) {
        System.out.println("ui6546546ghui");
    }*/

}
