package com.mcp.lab.java.core.nio.file;

import com.sun.deploy.util.StringUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author KG
 * @developer
 * @description
 * @date Created in 2022年09月21日 9:05 PM
 * @modified_by
 */
public class FileChannelDemo {

    private static void readFile(String path) {
        RandomAccessFile file = null;
        FileChannel channel = null;
        try {
            file = new RandomAccessFile(path, "r");

            channel = file.getChannel();

            //System.out.println("File size is: " + channel.size());

            ByteBuffer buffer = ByteBuffer.allocate((int) channel.size());

            channel.read(buffer);

            // Restore buffer to position 0 to read it
            buffer.flip();

            //System.out.println("Reading content and printing ... ");

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < channel.size(); i++) {
                char ch = (char) buffer.get();
                if (ch != '\n') {
                    sb.append(ch);
                } else {
                    System.out.println(sb);
                    sb = new StringBuilder();
                }
            }

            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                channel.close();
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        String path = "/Users/kg/Downloads/data/file_CU_001.txt";
        readFile(path);
    }
}
