package com.mcp.lab.java.core.classloader;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: KG
 * @description:
 * @date: Created in 2021年04月14日 10:21 PM
 * @modified by:
 */
@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class FileDefine {

    public static String WATCH_PACKAGE = "/Users/kg/develop/MicroComponent/Architecture/mcp-java-lab/CoreJava/mcp-core-java/classloader-demo/src/main/java/com/mcp/lab/java/core/classloader/watchfile";

    private String fileName;

    private Long lastDefine;


}

