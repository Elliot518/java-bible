package zeus.test.infra.random;

import zeus.infra.rand.IdGenerator;

/**
 * Created by KG on 2017/4/25.
 */
public class getRandomStringTest {
    private static void singleThreadRandString() {
        String randString = IdGenerator.getRandomString(16);
        System.out.println("Random String: " + randString);
    }

    private static void multiThreadRandString() {
        for (int i = 0; i < 20; i++) {
            Runnable myRunnable = new RandomStringRunnable();
            Thread t = new Thread(myRunnable);
            t.start();
        }
    }

    public static void main(String args[]) {
        //singleThreadRandString();
        multiThreadRandString();
    }
}

class RandomStringRunnable implements Runnable {
    public void run() {
        String randString = IdGenerator.getRandomString(16);
        System.out.println("Random String: " + randString);
    }
}

