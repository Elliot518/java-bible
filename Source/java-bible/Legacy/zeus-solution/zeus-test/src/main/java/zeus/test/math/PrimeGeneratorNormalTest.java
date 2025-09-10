package zeus.test.math;

import zeus.infra.performance.PerformanceManager;
import zeus.infra.performance.TimeConsole;
import zeus.math.PrimeGenerator;

import java.util.Scanner;

/**
 * Created by KG on 2017/6/26.
 */

public class PrimeGeneratorNormalTest {
    public static void main(String[] args) {

        System.out.println("Please input upper number to calculate primes: ");
        Scanner sc = new Scanner(System.in);
        int upperNumber = sc.nextInt();

        PerformanceManager perf = new PerformanceManager("PrimeGeneratorTest", new TimeConsole());
        perf.start("PrimeGeneratorNormalTest - Normal");

        // Launch the prime numbers generator
        PrimeGenerator pg = new PrimeGenerator(upperNumber);
        pg.run();

        perf.stop();
        perf.printTime();
    }
}
