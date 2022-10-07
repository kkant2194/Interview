package interview;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmpMain {

    public static void main(String[] args) {
        List<Emp> empList = new ArrayList<>();
        empList.add(new Emp(101,"siva",101,"active",2000));
        empList.add(new Emp(102,"reddy",101,"active",5000));
        empList.add(new Emp(103,"raju",102,"inactive",6000));
        empList.add(new Emp(104,"shivam",102,"inactive",4000));
        empList.add(new Emp(105,"bob",103,"active",3500));
        empList.add(new Emp(106,"alice",103,"inactive",3500));
        empList.add(new Emp(107,"srivn",104,"active",3500));
        System.out.println("**********Emp Detail Based on Dept***********");
        Map<Integer, List<Emp>> empDetailOnDept = empList.stream()
                .collect(Collectors.groupingBy(Emp::getDeptId, Collectors.toList()));
        empDetailOnDept.entrySet().forEach(e -> System.out.println(e.getKey() + "  " + e.getValue()));

        System.out.println("**********Emp Count in each Dept***********");
        Map<Integer, Long> empInEachDept = empList.stream()
                .collect(Collectors.groupingBy(Emp::getDeptId, Collectors.counting()));
        empInEachDept.entrySet().forEach(e -> System.out.println(e.getKey()+" " + e.getValue()));

        System.out.println("**********Print active/inactive count***********");
        long active = empList.stream()
                .filter(e -> e.getStatus().equals("active"))
                .count();
        System.out.println("Active Emp " + active);

        System.out.println("**********Max sal in Each dept***********");
        Map<Integer, Optional<Emp>> maxSalByDept = empList.stream()
                .collect(Collectors.groupingBy(Emp::getDeptId,
                        Collectors.maxBy(Comparator.comparing(Emp::getSal))));
        maxSalByDept.entrySet().forEach(e-> System.out.println(e.getKey() + " " + e.getValue().get()));

        System.out.println("**********Max sal in whole table***********");
        Optional<Emp> empMaxSal = empList.stream()
                .collect(Collectors.maxBy(Comparator.comparing(Emp::getSal)));

        System.out.println(empMaxSal.get(

        ));

        System.out.println("**********Third higest sal***********");
        List<Emp> collect = empList.stream()
                .sorted(Comparator.comparing(Emp::getSal).reversed())
                .skip(3)
                .limit(1)
                .collect(Collectors.toList());

        System.out.println(collect);;

        Map<Integer,Emp> map = new HashMap<>();
        map.put(1,new Emp(102,"siva",101,"active",2000));
        map.put(2,new Emp(101,"siva",101,"active",2000));
        map.put(3,new Emp(104,"siva",101,"active",2000));
        map.put(4,new Emp(103,"siva",101,"active",2000));

        LinkedHashMap<Integer, Emp> collect1 = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue((e1, e2) -> e1.getEmpId().compareTo(e2.getEmpId())))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o, n) -> o, LinkedHashMap::new));

        System.out.println(collect1);
    }
}
