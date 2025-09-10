package zeus.playground.stream;

import zeus.playground.util.AlgUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: ClassReference
 * @Package zeus.playground.stream
 * @Description: Invoking a multiple-argument instance method from a class reference
 * @date 2018/5/29 11:31
 */
public class ClassReference {
    public static void main(String[] args) {
        List<String> strings =
                Arrays.asList("this", "is", "a", "list", "of", "strings");
        List<String> sorted = strings.stream()
                .sorted((s1, s2) -> s1.compareTo(s2))
                .collect(Collectors.toList());
        System.out.println(sorted);

        List<String> sorted2 = strings.stream()
                .sorted(String::compareTo)
                .collect(Collectors.toList());
        System.out.println(sorted2);

       strings.stream().map(String::length).forEach(System.out::println);

        List<Integer> lenList =  strings.stream().map(String::length).collect(Collectors.toList());
        System.out.println("Stream List:");
        lenList.forEach(System.out::println);

        System.out.println("map method:");
        strings.stream().map(t->"length: " + t.length()).forEach(System.out::println);
        strings.stream().map(t->"length square: " + t.length()*t.length()).forEach(System.out::println);
        System.out.println("map to custom method:");
        strings.stream().map(t->AlgUtil.getFullOddString(t)).forEach(System.out::println);
    }
}
