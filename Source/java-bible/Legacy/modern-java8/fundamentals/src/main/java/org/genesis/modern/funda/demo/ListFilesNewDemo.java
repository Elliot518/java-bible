package org.genesis.modern.funda.demo;

import java.io.File;

/**
 * @author: KG
 * @description:
 * @date: Created in 下午4:21 2018/10/19
 * @modified by:
 */

public class ListFilesNewDemo {
    public static void main(String... args) {
        File[] hiddenFiles = new File(".").listFiles(File::isHidden);

        for (File file:hiddenFiles) {
            System.out.println(file.getName());
        }
    }
}
