package com.mcp.algorithm.sort;

import java.util.Collection;
import java.util.List;

/**
 * @author KG
 * @developer
 * @description
 * @date Created in 2022年09月28日 6:21 PM
 * @modified_by
 */
public class InsertionSort {
    /**
     * Sort all elements already prepared
     *
     * @param elements raw elements
     * @author KG
     * @date 2022/9/28 22:20
     */
    public static <T extends Comparable<T>> void sort(List<T> elements) {
        T key;
        int j;
        int size = elements.size();
        for (int i = 1; i < size; i++) {
            key = elements.get(i);
            // insert elements[i] into the sorted sublist elements[0:i-1]
            j = i - 1;
            while (j >= 0 && elements.get(j).compareTo(key) > 0) {
                elements.set(j + 1, elements.get(j));
                j--;
            }
            elements.set(j + 1, key);
        }
    }

    /**
     * Insert element and sort
     *
     * @param elements raw elements dynamic change
     * @param element  insert element
     * @author KG
     * @date 2022/9/28 22:25
     */
    public static <T extends Comparable<T>> void insertSort(List<T> elements, T element) {
        elements.add(element);
        int size = elements.size();
        if (size > 1) {
            int i = size - 2;
            while (i >= 0 && elements.get(i).compareTo(element) > 0) {
                elements.set(i + 1, elements.get(i));
                i--;
            }
            elements.set(i + 1, element);
        }
    }
}
