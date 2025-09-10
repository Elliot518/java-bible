package zeus.playground.function.lambda;

import java.io.File;
import java.util.Arrays;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: LambdaFileFilter
 * @Package zeus.playground.function.lambda
 * @Description: Lambda expression with explicit data types
 * @date 2018/5/29 10:49
 */
public class LambdaFileFilter {
    public static void main(String[] args) {
        File directory = new File("/Users/jgu55/MyTest/test_files");
        String[] names = directory.list((File dir, String name) ->
                name.endsWith(".java"));
        System.out.println("Lambda expression with explicit data types:");
        System.out.println(Arrays.asList(names));
    }
}
