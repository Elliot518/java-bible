package com.mcp.algorithm.mock;

import com.mcp.algorithm.models.Employee;
import com.mcp.algorithm.sort.InsertionSort;
import com.mcp.algorithm.util.RandomUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KG
 * @developer
 * @description
 * @date Created in 2022年09月28日 6:52 PM
 * @modified_by
 */
public class MockUtils {
    public static List<Employee> mockEmployeeList(int num, double minSal, double maxSal) {
        List<Employee> employeeList = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            String name = String.format("Emp%s", i);
            Employee employee = new Employee();
            employee.setName(name);
            employee.setAge(RandomUtils.generateRandomInt(100));
            employee.setSalary(RandomUtils.generateRandomDouble(1000, 50000));

            employeeList.add(employee);
        }

        return employeeList;
    }

    public static List<Employee> mockSortEmployeeList(int num, double minSal, double maxSal) {
        List<Employee> employeeList = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            String name = String.format("Emp%s", i);
            Employee employee = new Employee();
            employee.setName(name);
            employee.setAge(RandomUtils.generateRandomInt(100));
            employee.setSalary(RandomUtils.generateRandomDouble(1000, 50000));

            InsertionSort.insertSort(employeeList, employee);
        }

        return employeeList;
    }
}


