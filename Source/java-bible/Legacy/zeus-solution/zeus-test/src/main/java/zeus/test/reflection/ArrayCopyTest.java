package zeus.test.reflection;

import zeus.infra.reflection.GenericReflector;

import java.util.Arrays;

/**
 * Created by KG on 2017/5/24.
 */
public class ArrayCopyTest {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        a = (int[]) GenericReflector.arrayCopy(a, 10);
        System.out.println(Arrays.toString(a));

        String[] b = {"Tom", "Dick", "Harry"};
        b = (String[]) GenericReflector.arrayCopy(b, 2);
        System.out.println(Arrays.toString(b));

        String[] c = {"Tom", "Dick", "Harry"};
        c = (String[]) GenericReflector.arrayCopy(c, 9);
        System.out.println(Arrays.toString(c));
    }
}
