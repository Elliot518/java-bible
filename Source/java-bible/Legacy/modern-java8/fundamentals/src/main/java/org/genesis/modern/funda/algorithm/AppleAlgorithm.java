package org.genesis.modern.funda.algorithm;

import org.genesis.modern.domain.fruit.Apple;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author: KG
 * @description:
 * @date: Created in 下午2:28 2018/10/19
 * @modified by:
 */

public class AppleAlgorithm {
    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}
