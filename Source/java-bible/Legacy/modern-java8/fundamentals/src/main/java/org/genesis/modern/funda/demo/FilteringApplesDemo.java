package org.genesis.modern.funda.demo;

import org.genesis.modern.domain.fruit.Apple;
import org.genesis.modern.funda.algorithm.AppleAlgorithm;

import java.util.Arrays;
import java.util.List;

/**
 * @author: KG
 * @description:
 * @date: Created in 下午2:35 2018/10/19
 * @modified by:
 */

public class FilteringApplesDemo {
    public static void main(String... args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red")
        );

        // [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        List<Apple> greenApples = AppleAlgorithm.filterApples(inventory, AppleAlgorithm::isGreenApple);
        System.out.println(greenApples);

        // [Apple{color='green', weight=155}]
        List<Apple> heavyApples = AppleAlgorithm.filterApples(inventory, AppleAlgorithm::isHeavyApple);
        System.out.println(heavyApples);

        // [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        List<Apple> greenApples2 = AppleAlgorithm.filterApples(inventory, (Apple a) -> "green".equals(a.getColor()));
        System.out.println(greenApples2);

        // [Apple{color='green', weight=155}]
        List<Apple> heavyApples2 = AppleAlgorithm.filterApples(inventory, (Apple a) -> a.getWeight() > 150);
        System.out.println(heavyApples2);

        // []
        List<Apple> weirdApples = AppleAlgorithm.filterApples(inventory, (Apple a) -> a.getWeight() < 80 || "brown".equals(a.getColor()));
        System.out.println(weirdApples);
    }
}



