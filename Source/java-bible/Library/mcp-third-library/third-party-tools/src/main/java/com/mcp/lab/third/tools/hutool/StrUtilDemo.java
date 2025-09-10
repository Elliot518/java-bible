package com.mcp.lab.third.tools.hutool;

import cn.hutool.core.util.StrUtil;

/**
 * @author: KG
 * @description: 字符串工具类，定义了一些常用的字符串操作方法
 * @date: Created in 2021年06月29日 10:07 AM
 * @modified by:
 */
public class StrUtilDemo {
    public static void main(String[] args) {
        // 判断是否为空字符串
        String str = "test";
        StrUtil.isEmpty(str);
        StrUtil.isNotEmpty(str);

        // 去除字符串的前后缀
        StrUtil.removeSuffix("a.jpg", ".jpg");
        StrUtil.removePrefix("a.jpg", "a.");

        // 格式化字符串
        String template = "这只是个占位符:{}";
        String str2 = StrUtil.format(template, "我是占位符");
        System.out.println("/strUtil format: " + str2);
    }
}
