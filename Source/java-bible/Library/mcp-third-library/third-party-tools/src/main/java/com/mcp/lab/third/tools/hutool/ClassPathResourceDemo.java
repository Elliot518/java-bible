package com.mcp.lab.third.tools.hutool;

import cn.hutool.core.io.resource.ClassPathResource;

import java.io.IOException;
import java.util.Properties;

/**
 * @author: KG
 * @description: 获取classPath下的文件，在Tomcat等容器下，classPath一般是WEB-INF/classes
 * @date: Created in 2021年06月29日 10:10 AM
 * @modified by:
 */
public class ClassPathResourceDemo {
    public static void main(String[] args) throws IOException {
        // 获取定义在src/main/resources文件夹中的配置文件
        ClassPathResource resource = new ClassPathResource("generator.properties");
        Properties properties = new Properties();
        properties.load(resource.getStream());
        System.out.println("value: " + properties.getProperty("hello"));
    }
}
