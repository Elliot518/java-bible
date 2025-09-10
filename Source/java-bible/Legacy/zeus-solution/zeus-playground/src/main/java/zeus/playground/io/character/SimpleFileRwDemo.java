package zeus.playground.io.character;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author: KG
 * @description:
 * @date: Created in 上午9:02 2018/3/14
 * @modified by:
 */

public class SimpleFileRwDemo {
    public static void main(String[] args) throws IOException {
        String message = "你好, 这是一条字符串信息!";

        try (FileWriter fw = new FileWriter("temp")) {
            fw.write(message, 0, message.length());
        }

        char[] buf = new char[message.length()];
        try (FileReader fr = new FileReader("temp")) {
            fr.read(buf, 0, message.length());
            System.out.println(buf);
        }
    }
}
