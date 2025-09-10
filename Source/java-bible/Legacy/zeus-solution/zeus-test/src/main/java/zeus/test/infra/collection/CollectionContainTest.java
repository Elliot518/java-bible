package zeus.test.infra.collection;

import zeus.infra.collection.CollectionUtil;
import zeus.test.pojo.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KG on 2017/6/26.
 */

public class CollectionContainTest {
    public static void main(String[] args) {
        List<String> strList = new ArrayList<>();
        strList.add("david");
        strList.add("peter");
        strList.add("kelvin");

        String name = "kelvin";
        boolean contains = CollectionUtil.contains(strList, name);
        System.out.println("List contains " + name + "? " + contains);
        name = "alice";
        contains = CollectionUtil.contains(strList, name);
        System.out.println("List contains " + name + "? " + contains);

        System.out.println("-----------------------------------------------------");

        List<Employee> staffList = new ArrayList<>();

        staffList.add(new Employee("Harry Hacker", 35000));
        Employee specialEmp = new Employee("Carl Cracker", 75000);
        specialEmp.setHireDay(1980, 1, 1);
        staffList.add(specialEmp);
        staffList.add(new Employee("Tony Tester", 38000));

        Employee employee1 = new Employee("Harry Hacker", 35000);
        contains = CollectionUtil.contains(staffList, employee1);
        System.out.println("List contains employee info? \n" + employee1 + "\n" + "Result: " + contains);

        Employee employee2 = new Employee("Harry Hacker", 35000);
        contains = CollectionUtil.contains(staffList, employee2);
        System.out.println("List contains employee info? \n" + employee2 + "\n" + "Result: " + contains);

        Employee employee3 = new Employee("Carl Cracker", 75000);
        employee3.setHireDay(1980, 1, 1);
        contains = CollectionUtil.contains(staffList, employee3);
        System.out.println("List contains employee info? \n" + employee3 + "\n" + "Result: " + contains);
    }
}
