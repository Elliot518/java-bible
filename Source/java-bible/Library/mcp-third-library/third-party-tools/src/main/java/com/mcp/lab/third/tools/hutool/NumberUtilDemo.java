package com.mcp.lab.third.tools.hutool;

import cn.hutool.core.util.NumberUtil;

import java.math.BigDecimal;

/**
 * @author: KG
 * @description: 数字处理工具类，可用于各种类型数字的加减乘除操作及判断类型
 * @date: Created in 2021年06月29日 10:43 AM
 * @modified by:
 */
public class NumberUtilDemo {
    public static void main(String[] args) {
        double n1 = 1.234;
        double n2 = 1.234;
        double result;

        // 对float、double、BigDecimal做加减乘除操作
        result = NumberUtil.add(n1, n2);
        System.out.println(result);
        result = NumberUtil.sub(n1, n2);
        System.out.println(result);
        result = NumberUtil.mul(n1, n2);
        System.out.println(result);
        result = NumberUtil.div(n1, n2);
        System.out.println(result);

        // 保留两位小数
        BigDecimal roundNum = NumberUtil.round(n1, 2);
        System.out.println(roundNum);
        String n3 = "1.234";

        // 判断是否为数字、整数、浮点数
        Boolean isTrue = NumberUtil.isNumber(n3);
        System.out.println(isTrue);
        isTrue = NumberUtil.isInteger(n3);
        System.out.println(isTrue);
        isTrue = NumberUtil.isDouble(n3);
        System.out.println(isTrue);
    }
}
