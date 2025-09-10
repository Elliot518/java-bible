package zeus.test.infra.collection;

import zeus.test.pojo.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class CollectionTest2 {
    public static void main(String[] args) {
        System.out.println("Current Date:" + new Date());

        List<Employee> staffList1 = new ArrayList<>();
        staffList1.add(new Employee("Harry Hacker", 35000));
        staffList1.add(new Employee("Peter Tod", 50000));
        staffList1.add(new Employee("Mark Ape", 30000));

        List<Employee> staffList2 = new ArrayList<>();
        staffList2.add(new Employee("Mary Kim", 25000));
        staffList2.add(new Employee("Peter Tod", 50000));
        staffList2.add(new Employee("Harry Hacker", 35000));

        System.out.println("** Before removing employees **");
        displayEmployees(staffList1);
        System.out.println("----------------------------------------------------");

        staffList1.removeAll(staffList2);
        System.out.println("** After removing employees **");
        displayEmployees(staffList1);

        Integer[] list1 = { 1, 2, 3, 9, 8, 10, 15, 99 };
        Integer[] list2 = { 2, 3, 8, 99, 100, 98 };
        ArrayList<Integer> arrList1 = new ArrayList<Integer>(Arrays.asList(list1));
        ArrayList<Integer> arrList2 = new ArrayList<Integer>(Arrays.asList(list2));
        System.out.println("** Before removing numbers **");
        displayNumbers(arrList1);
        System.out.println("----------------------------------------------------");

        ArrayList<Integer> cloneList1 = (ArrayList<Integer>)arrList1.clone();
        cloneList1.removeAll(arrList2);
        System.out.println("** After removing numbers **");
        displayNumbers(cloneList1);
        System.out.println("----------------------------------------------------");

        arrList1.retainAll(arrList2);
        System.out.println("** After retain numbers **");
        displayNumbers(arrList1);
    }

    private static void displayEmployees(List<Employee> empList) {
        for (Employee employee:empList) {
            System.out.println(employee);
        }
    }

    private static void displayNumbers(List<Integer> numList) {
        for (Integer number:numList) {
            System.out.println(number);
        }
    }
}
