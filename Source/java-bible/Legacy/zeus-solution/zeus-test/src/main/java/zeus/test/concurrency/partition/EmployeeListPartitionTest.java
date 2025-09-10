package zeus.test.concurrency.partition;

import zeus.concurrency.partition.GenericListPartitioner;
import zeus.test.pojo.Employee;

import java.util.*;

/**
 * @Author: KG
 * @Description:
 * @Date: Created in 下午4:01 2018/1/24
 * @Modified by:
 */

public class EmployeeListPartitionTest {

    public static void main(String[] args) {
        System.out.println("Please input employee number: ");
        Scanner sc = new Scanner(System.in);
        int empNum = sc.nextInt();
        System.out.println("Please input thread number: ");
        int threadNum = sc.nextInt();
        List<Employee> employees = initEmployees(empNum);
        HashMap<Integer, List<Employee>> partionEmployees = GenericListPartitioner.<Employee>split(employees, threadNum);
        displayEmployeesConcurrent(partionEmployees, threadNum);
    }

    private static List<Employee> initEmployees(int num) {
        List<Employee> employees = new ArrayList<>();
        for (int i=0;i<num;i++) {
            Employee employee = new Employee("Employee" + i, i % 100);
            employees.add(employee);
        }

        return employees;
    }

    private static void displayEmployeesConcurrent(HashMap<Integer, List<Employee>> partionEmployees, int threadNum) {
        for (Map.Entry<Integer, List<Employee>> entry : partionEmployees.entrySet()) {
            Integer index = entry.getKey();
            List<Employee> employees = entry.getValue();
            Thread task = new EmployeePartitionListThread(threadNum, employees);
            task.start();
        }
    }
}
