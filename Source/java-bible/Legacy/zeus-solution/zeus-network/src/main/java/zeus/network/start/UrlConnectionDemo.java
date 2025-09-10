package zeus.network.start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class UrlConnectionDemo {
    private static void urlConnectionTest() {
        try {
            URL url = new URL("http://www.baidu.com");
            URLConnection urlConnection = url.openConnection();
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(urlConnection.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void urlConnectionChannelTest() {
        try {
            // Channel
            URL url = new URL("http://www.baidu.com");
            System.out.println("Channel Example");
            URLConnection urlConnection = url.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            ReadableByteChannel channel = Channels.newChannel(inputStream);
            ByteBuffer buffer = ByteBuffer.allocate(64);
            String line = null;
            while (channel.read(buffer) > 0) {
                System.out.println("---" + new String(buffer.array()));
                buffer.clear();
            }
            channel.close();
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        urlConnectionTest();
        urlConnectionChannelTest();
    }
}
