package zeus.playground.io.character;

import java.io.*;

/**
 * @author: KG
 * @description:
 * @date: Created in 上午9:24 2018/3/14
 * @modified by:
 */

public class BufferFileRwDemo {
    static String[] lines =
            {
                    "It was the best of times, it was the worst of times,",
                    "it was the age of wisdom, it was the age of foolishness,",
                    "it was the epoch of belief, it was the epoch of incredulity,",
                    "it was the season of Light, it was the season of Darkness,",
                    "it was the spring of hope, it was the winter of despair."
            };

    public static void main(String[] args) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("temp"))) {
            for (String line : lines) {
                bw.write(line, 0, line.length());
                bw.newLine();
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader("temp"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
