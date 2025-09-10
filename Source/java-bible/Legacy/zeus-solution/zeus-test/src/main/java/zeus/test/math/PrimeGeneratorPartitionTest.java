package zeus.test.math;

import zeus.math.PrimeGeneratorPartitionThread;

import java.util.Scanner;

/**
 * Created by KG on 2017/6/26.
 */

public class PrimeGeneratorPartitionTest {
    public static void main(String[] args) {

        System.out.println("Please input upper number to calculate primes: ");
        Scanner sc = new Scanner(System.in);
        int range = sc.nextInt();

        int threadNum = 10;
        int avgNum = range / threadNum;

        int low = 2;
        int high = avgNum;
        for (int i = 1; i <=threadNum; i++) {
            // Launch the prime numbers generator
            Thread task = new PrimeGeneratorPartitionThread(low, high, threadNum);
            task.start();

            low = avgNum * i + 1;
            high = avgNum  * (i + 1);
            if (i == threadNum - 1) { high = range; }
        }
    }
}

