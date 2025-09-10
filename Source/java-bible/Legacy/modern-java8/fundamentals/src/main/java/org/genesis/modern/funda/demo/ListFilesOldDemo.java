package org.genesis.modern.funda.demo;

import java.io.File;
import java.io.FileFilter;

/**
 * @author: KG
 * @description:
 * @date: Created in 下午4:19 2018/10/19
 * @modified by:
 */

public class ListFilesOldDemo {
    public static void main(String... args) {
        File[] hiddenFiles = new File(".").listFiles(new FileFilter() {
            public boolean accept(File file) {
                return file.isHidden();
            }
        });

        for (File file:hiddenFiles) {
            System.out.println(file.getName());
        }
    }
}
