package com.mcp.algorithm.models;

import lombok.Data;

/**
 * @author KG
 * @developer
 * @description
 * @date Created in 2022年09月28日 6:26 PM
 * @modified_by
 */
@Data
public class Employee implements Comparable<Employee> {
    private String name;

    private int age;

    private double salary;

    @Override
    public int compareTo(Employee o) {
        return (int)(this.getSalary() - o.getSalary());
    }
}
