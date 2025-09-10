package zeus.network.start;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
    private static void inetAddressTest() {
        try {
            InetAddress address = InetAddress.getByName("www.packtpub.com");
            System.out.println(address);
            displayInetAddressInformation(address);
            address = InetAddress.getByName("83.166.169.231");
            System.out.println(address);
            address = InetAddress.getLocalHost();
            System.out.println(address);

        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        }
    }

    private static void displayInetAddressInformation(InetAddress address) {
        System.out.println("---InetAddress Information---");
        System.out.println(address);
        System.out.println("CanonicalHostName: " + address.getCanonicalHostName());
        System.out.println("HostAddress: " + address.getHostAddress());
        System.out.println("HostName: " + address.getHostName());
        System.out.println("---------");
    }

    public static void main(String[] args) {
        inetAddressTest();
    }
}
