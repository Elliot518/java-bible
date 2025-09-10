package zeus.playground.function.method;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Stream;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: StaticMethodReference
 * @Package zeus.playground.function.method
 * @Description: Using a method reference to a static method
 * @date 2018/5/29 11:09
 */
public class StaticMethodReference {
    public static void main(String[] args) {
        System.out.println("Using a method reference to a static method");
        Stream.generate(Math::random)
                .limit(10)
                .forEach(System.out::println);
    }
}

