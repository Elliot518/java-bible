package zeus.playground.function.method;

import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: MethodReferenceDemo
 * @Package zeus.playground.function.method
 * @Description: Using a method reference to access println
 * @date 2018/5/29 11:01
 */
public class MethodReferenceDemo {
    public static void main(String[] args) {
        // Using a lambda expression
        System.out.println("1. Using a lambda expression");
        Stream.of(3, 1, 4, 1, 5, 9)
                .forEach(x -> System.out.println(x));
        System.out.println("-----------------------------------------");

        // Using a method reference
        System.out.println("2. Using a method reference");
        Stream.of(3, 1, 4, 1, 5, 9)
                .forEach(System.out::println);
        System.out.println("-----------------------------------------");

        // Assigning the method reference to a functional interface
        System.out.println("3. Assigning the method reference to a functional interface");
        Consumer<Integer> printer = System.out::println;
        Stream.of(3, 1, 4, 1, 5, 9)
                .forEach(printer);
        System.out.println("-----------------------------------------");
    }
}
