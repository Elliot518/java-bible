package zeus.network.start;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NioDemo {
    private static void nioTest() {
        try {
            InetAddress address = InetAddress.getByName("packtpub.com");
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress(address, 80));
            while (!socketChannel.finishConnect()) {
                // wait, or do something else...
            }
            System.out.println(socketChannel);
            System.out.println(socketChannel.isConnected());
            System.out.println(socketChannel.isBlocking());

            ByteBuffer buffer;
            buffer = ByteBuffer.allocate(64);
            System.out.println("buffer: " + buffer);
            int bytesRead = socketChannel.read(buffer);
            System.out.println("bytesRead: " + bytesRead);
            if (bytesRead > 0) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    System.out.println("--" + buffer.get());
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        nioTest();
    }
}
