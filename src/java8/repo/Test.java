package java8.repo;

public class Test {

    public static void main(String test[]){

        m1(10);

    }

    static void m1(int i){
        System.out.println("inside int " + i);
    }

    static void m1(Integer j){
        System.out.println("inside integer " + j);
    }
}
