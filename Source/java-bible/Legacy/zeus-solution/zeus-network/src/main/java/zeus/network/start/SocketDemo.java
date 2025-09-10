package zeus.network.start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketDemo {
    private static void socketTest() {
        try {
            InetAddress address = InetAddress.getByName("163.com");
            Socket socket = new Socket(address, 80);
            System.out.println(socket.isConnected());
            InputStream input;
            input = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(input));
            while (!br.ready()) {
            }
            String line = br.readLine();
            System.out.println("First - " + line);
            while ((line = br.readLine()) != null) {
                System.out.println("Each - " + line);
            }
            System.out.println("Done");
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        socketTest();
    }
}
