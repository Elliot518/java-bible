package com.mcp.algorithm.sort.test;

import com.mcp.algorithm.mock.MockUtils;
import com.mcp.algorithm.models.Employee;
import com.mcp.algorithm.sort.InsertionSort;
import com.mcp.algorithm.util.PrintUtils;

import java.util.List;

/**
 * @author KG
 * @developer
 * @description
 * @date Created in 2022年09月28日 7:18 PM
 * @modified_by
 */
public class InsertionSortTest {
    private static List<Employee> initEmployees(int num, double minSal, double maxSal) {
        List<Employee> employees = MockUtils.mockEmployeeList(num, minSal, maxSal);

        return employees;
    }

    public static void main(String[] args) {
        // mock employees
        List<Employee> employees = initEmployees(100, 1000, 50000);

        // insertion sort
        InsertionSort.sort(employees);

        // print elements
        PrintUtils.printList(employees);
    }
}
