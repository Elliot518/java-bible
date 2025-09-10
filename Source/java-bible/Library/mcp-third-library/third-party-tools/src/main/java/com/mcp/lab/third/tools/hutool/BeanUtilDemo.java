package com.mcp.lab.third.tools.hutool;

import cn.hutool.core.bean.BeanUtil;

import java.util.Map;

/**
 * @author: KG
 * @description: JavaBean的工具类，可用于Map与JavaBean对象的互相转换以及对象属性的拷贝
 * @date: Created in 9:45 下午 2021/6/29
 * @modified by:
 */

public class BeanUtilDemo {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setName("KG");
        employee.setAge(30);

        // Bean转Map
        Map<String, Object> map = BeanUtil.beanToMap(employee);
        System.out.println("beanUtil bean to map: " + map);

        // Map转Bean
        Employee empFromMap = BeanUtil.mapToBean(map, Employee.class, false);
        System.out.println("beanUtil map to bean: " + empFromMap);

        // Bean属性拷贝
        Employee copyEmployee = new Employee();
        BeanUtil.copyProperties(employee, copyEmployee);
        System.out.println("beanUtil copy properties: " + copyEmployee);
    }
}
