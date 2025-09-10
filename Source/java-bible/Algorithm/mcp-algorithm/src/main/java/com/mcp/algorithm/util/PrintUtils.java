package com.mcp.algorithm.util;

import java.util.List;

/**
 * @author KG
 * @developer
 * @description
 * @date Created in 2022年09月28日 7:50 PM
 * @modified_by
 */
public class PrintUtils {
    public static <T> void printList(List<T> elements) {
        for (T element : elements) {
            System.out.println(element);
        }
    }
}
