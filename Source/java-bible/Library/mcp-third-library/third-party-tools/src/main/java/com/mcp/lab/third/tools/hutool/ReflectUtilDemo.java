package com.mcp.lab.third.tools.hutool;

import cn.hutool.core.util.ReflectUtil;

import java.lang.reflect.Method;

/**
 * @author: KG
 * @description:
 * @date: Created in 2021年06月29日 10:17 AM
 * @modified by:
 */
public class ReflectUtilDemo {
    public static void main(String[] args) {
        // 获取某个类的所有方法
        Method[] methods = ReflectUtil.getMethods(Person.class);

        // 获取某个类的指定方法
        Method method = ReflectUtil.getMethod(Person.class, "hello");
        System.out.println("Method: " + method);

        // 使用反射来创建对象
        Person person = ReflectUtil.newInstance(Person.class);

        // 反射执行对象的方法
        ReflectUtil.invoke(person, "setName", "kg");
        ReflectUtil.invoke(person, "hello");
    }
}
