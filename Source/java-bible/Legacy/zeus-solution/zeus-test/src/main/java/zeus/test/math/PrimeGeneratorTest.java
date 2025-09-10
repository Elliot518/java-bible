package zeus.test.math;

import zeus.infra.performance.PerformanceManager;
import zeus.infra.performance.TimeConsole;
import zeus.math.PrimeGeneratorThread;

import java.util.Scanner;

/**
 * Created by KG on 2017/6/26.
 */

public class PrimeGeneratorTest {
    public static void main(String[] args) {

        System.out.println("Please input upper number to calculate primes: ");
        Scanner sc = new Scanner(System.in);
        int upperNumber = sc.nextInt();

        // Launch the prime numbers generator
        Thread task = new PrimeGeneratorThread(upperNumber);
        task.start();

        // Wait 5 seconds
//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        // Interrupt the prime number generator
//        task.interrupt();
    }
}
