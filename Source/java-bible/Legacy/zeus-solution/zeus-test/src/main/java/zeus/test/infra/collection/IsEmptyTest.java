package zeus.test.infra.collection;

import java.util.ArrayList;
import java.util.List;

public class IsEmptyTest {
    public static void main(String[] args) {
        List<String> strList1 = new ArrayList<>();
        List<String> strList2 = null;

        System.out.println("strList1 is empty? " + strList1.isEmpty());
        System.out.println("strList2 is empty? " + strList2.isEmpty());
    }
}
