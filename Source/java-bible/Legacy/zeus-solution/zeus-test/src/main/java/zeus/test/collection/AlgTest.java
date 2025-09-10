package zeus.test.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlgTest {
    public static void main(String[] args) {
        List<String> strList = new ArrayList<>(Arrays.asList("ABC","KG","GOOD", "fuckYou", "shitDog", "Master HaKu"));

        // replaceAll test
        System.out.println("Before replace all:");
        printList(strList);
        strList.replaceAll(String::toLowerCase);
        System.out.println("After replace all:");
        printList(strList);

        // removeIf test
        strList.removeIf(s -> s.contains("fuck") || s.contains("shit"));
        System.out.println("After remove dirty words:");
        printList(strList);
    }

    private static void printList(List<String> list) {
        for (String s:list) {
            System.out.println(s);
        }
        System.out.println("------------------------------------------");
    }
}
