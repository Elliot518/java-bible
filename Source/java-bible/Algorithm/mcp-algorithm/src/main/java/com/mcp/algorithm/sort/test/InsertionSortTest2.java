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
public class InsertionSortTest2 {
    private static List<Employee> initEmployees(int num, double minSal, double maxSal) {
        List<Employee> employees = MockUtils.mockSortEmployeeList(num, minSal, maxSal);

        return employees;
    }

    public static void main(String[] args) {
        // mock sorted employees
        List<Employee> employees = initEmployees(100, 10000, 99999);

        // print elements
        PrintUtils.printList(employees);
    }
}
