package com.mcp.algorithm.sort.test;

import com.mcp.algorithm.models.Employee;

/**
 * @author: KG
 * @description:
 * @date: Created in 21:12 2022/9/28
 * @modified by:
 */
public class CompareTest {
    public static void main(String[] args) {
        Employee emp1 = new Employee();
        emp1.setName("Employee1");
        emp1.setAge(90);
        emp1.setSalary(1500);

        Employee emp2 = new Employee();
        emp2.setName("Employee2");
        emp2.setAge(100);
        emp2.setSalary(1500);

        int result = emp1.compareTo(emp2);
        System.out.println(result);
    }
}
