package zeus.math;

import zeus.infra.performance.PerformanceManager;
import zeus.infra.performance.TimeConsole;

/**
 * Created by KG on 2017/6/26.
 */

public class PrimeGeneratorPartitionThread extends Thread {

    private static Integer threadCount = 0;

    private int lowNumber;
    private int highNumber;
    private int threadNum;

    public PrimeGeneratorPartitionThread(int lowNumber, int highNumber, int threadNum) {
        this.lowNumber = lowNumber;
        this.highNumber = highNumber;
        this.threadNum = threadNum;
    }

    /**
     * Central method of the class
     */
    @Override
    public void run() {
        PerformanceManager perf = new PerformanceManager("PrimeGeneratorPartitionThread", new TimeConsole());
        perf.start("PrimeGeneratorPartitionThread");

        long number = lowNumber;

        // This bucle never ends... until is interrupted
        while (number <= highNumber) {
            if (isPrime(number)) {
                System.out.printf("Number %d is Prime \n", number);
            }

            // When is interrupted, write a message and ends
            if (isInterrupted()) {
                System.out.printf("The Prime Generator has been Interrupted \n");
                return;
            }
            number++;
        }

        perf.stop();

        synchronized (this) {
            threadCount++;
            System.out.println("Thread Count: " + threadCount);
        }

        if (threadCount == threadNum) {
            perf.printTime();
        }
    }

    /**
     * Method that calculate if a number is prime or not
     *
     * @param number : The number
     * @return A boolean value. True if the number is prime, false if not.
     */
    private boolean isPrime(long number) {
        if (number <= 2) {
            return true;
        }
        for (long i = 2; i < number; i++) {
            if ((number % i) == 0) {
                return false;
            }
        }
        return true;
    }

}
