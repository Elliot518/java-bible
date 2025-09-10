package zeus.test.infra.basic;

import java.util.UUID;

public class UUIDTest {
    public static void main(String[] args) {
        String uuid1 = UUID.randomUUID().toString();
        System.out.println(uuid1);
        String uuid2 = UUID.randomUUID().toString().replaceAll("-", "");
        System.out.println(uuid2);
    }
}

