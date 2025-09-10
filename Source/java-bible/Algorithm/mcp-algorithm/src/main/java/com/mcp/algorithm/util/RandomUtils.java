package com.mcp.algorithm.util;

import java.util.Random;

/**
 * @author KG
 * @developer
 * @description
 * @date Created in 2022年09月28日 6:55 PM
 * @modified_by
 */
public class RandomUtils {

    public static int generateRandomInt(int max) {
        return (int) (Math.random() * max);
    }

    public static Double generateRandomDouble(double min, double max) {
        Random rand = new Random();
        double result = 0;
        for (int i = 0; i < 10; i++) {
            result = min + (rand.nextDouble() * (max - min));
            result = (double) Math.round(result * 100) / 100;
        }
        return result;
    }

    /*public static void main(String[] args) {
        double num = generateRandomDouble(1000, 50000);
        System.out.println(num);
    }*/
}
