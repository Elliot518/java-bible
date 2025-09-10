package zeus.playground.function.lambda;

import java.io.File;
import java.util.Arrays;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: BlockLambda
 * @Package zeus.playground.function.lambda
 * @Description: A block lambda
 * @date 2018/5/29 10:57
 */
public class BlockLambda {
    public static void main(String[] args) {
        File directory = new File("/Users/jgu55/MyTest/test_files");
        String[] names = directory.list((File dir, String name) -> {
            return name.endsWith(".java");
        });
        System.out.println("A block lambda:");
        System.out.println(Arrays.asList(names));
    }
}
