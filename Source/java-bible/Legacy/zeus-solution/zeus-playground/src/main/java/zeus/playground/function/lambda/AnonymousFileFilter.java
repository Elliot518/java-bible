package zeus.playground.function.lambda;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: AnonymousFileFilter
 * @Package zeus.playground.function.lambda
 * @Description: An anonymous inner class implementation of FilenameFilter
 * @date 2018/5/29 10:36
 */
public class AnonymousFileFilter {
    public static void main(String[] args) {
        File directory = new File("/Users/jgu55/MyTest/test_files");
        String[] names = directory.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".java");
            }
        });
        System.out.println("An anonymous inner class implementation of FilenameFilter:");
        System.out.println(Arrays.asList(names));
    }
}

