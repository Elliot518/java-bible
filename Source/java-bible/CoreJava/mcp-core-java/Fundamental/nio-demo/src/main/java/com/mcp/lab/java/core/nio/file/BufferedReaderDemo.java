package com.mcp.lab.java.core.nio.file;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author KG
 * @developer
 * @description
 * @date Created in 2022年09月21日 8:29 PM
 * @modified_by
 */
public class BufferedReaderDemo {

    private static void readFile(String path) {

        try (BufferedReader br = Files.newBufferedReader(Paths.get(path))) {
            // read line by line
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String path = "/Users/kg/Downloads/data/file_CU_001.txt";
        readFile(path);
    }
}

