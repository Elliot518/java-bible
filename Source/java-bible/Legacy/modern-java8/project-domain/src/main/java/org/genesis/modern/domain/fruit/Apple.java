package org.genesis.modern.domain.fruit;

/**
 * @author: KG
 * @description:
 * @date: Created in 下午2:18 2018/10/19
 * @modified by:
 */

public class Apple {
    private int weight = 0;
    private String color = "";

    public Apple(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @SuppressWarnings("boxing")
    @Override
    public String toString() {
        return String.format("Apple{color='%s', weight=%d}", color, weight);
    }
}
