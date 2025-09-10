package com.mcp.lab.third.tools.hutool;

/**
 * @author: KG
 * @description:
 * @date: Created in 2021年06月29日 10:23 AM
 * @modified by:
 */
public class Person {
    private String name;

    public void hello() {
        System.out.println("Hello: " + name);
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
