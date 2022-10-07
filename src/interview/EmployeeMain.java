package interview;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeMain {

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

        System.out.println("***********male and female employees are there in the organization************");
        Map<String, Long> maleFemaleEmp = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        maleFemaleEmp.entrySet().forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));

        System.out.println("*****************Print the name of all departments in the organization************************");
        List<String> deptNames = employeeList.stream()
                .map(Employee::getDepartment)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(deptNames);

        System.out.println("*******************avg age of male and female emp*************************************");
        Map<String, Double> avgAge = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));
        //avgAge.entrySet().forEach(e-> System.out.println(e.getKey() + " " + e.getValue()));
        System.out.println(avgAge);

        System.out.println("********Highest paid employee in organization**********");
        Optional<Employee> highestSalInOrg = employeeList.stream()
                .collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary)));
        System.out.println(highestSalInOrg.get());

        System.out.println("********Employee joined after 2015**********");
        List<String> employessJoinedAfter2015 = employeeList.stream()
                .filter(e -> e.getYearOfJoining() > 2015)
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println(employessJoinedAfter2015);

        System.out.println("********Employee count in each dept**********");
        Map<String, Long> empCountInEachDept = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

        System.out.println(empCountInEachDept);
        System.out.println("********Avg  sal in each dept**********");

        Map<String, Double> avgSalInEachDept = employeeList
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(avgSalInEachDept);

        Predicate<Employee> p1 = e -> e.getDepartment().equals("Product Development");
        Predicate<Employee> p2 = e ->e.gender.equals("Male");
        System.out.println("***********youngest male employee in the product development department***************************");
        Optional<Employee> youngestMaleInProd = employeeList.stream()
                .filter(p2.and(p1))
                .sorted(Comparator.comparing(Employee::getAge))
                .findFirst();
        System.out.println(youngestMaleInProd.get());

        System.out.println("***********Oldest Emp in the organization***************************");
        Optional<Employee> oldestEmp = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getYearOfJoining))
                .findFirst();
        System.out.println(oldestEmp.get());

        System.out.println("*************male and Female in Sales and Marketing Team**************");

        Map<String, Long> sales_and_marketing = employeeList.stream()
                .filter(e -> e.getDepartment().equals("Sales And Marketing"))
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

        System.out.println(sales_and_marketing);

        System.out.println("********************Avg Sal of male and female emp*******************");

        Map<String, Double> avgSalofMaleAndFemale = employeeList
                .stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(avgSalofMaleAndFemale);

        System.out.println("****************List Down All Employees in Ecah DEpt***************");

        Map<String, List<Employee>> empInEcahDept = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.toList()));

        System.out.println(empInEcahDept);

        System.out.println("******************avg sal and total sal in whole organization");

        DoubleSummaryStatistics collect = employeeList.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("Sum " + collect.getSum());
        System.out.println("Average " + collect.getAverage());

        System.out.println("*****************employees younger than 25*************************");
        employeeList.stream()
                .collect(Collectors.groupingBy(e -> e.getAge() > 25 ? "Greater Than 25" : "Less Than 25"));
        //System.out.println(lessThan25);

        System.out.println("*****************Oldest Employee In the organization*************************");
        Optional<Employee> maxAgedEmp = employeeList.stream()
                .max(Comparator.comparing(Employee::getAge));
        System.out.println(maxAgedEmp.get());
    }
}
