package zeus.math;

/**
 * Created by KG on 2017/6/26.
 */

public class PrimeGenerator {

    private int upperNumber;

    public PrimeGenerator(int upperNumber) {
        this.upperNumber = upperNumber;
    }

    /**
     * Central method of the class
     */
    public void run() {
        long number = 2;

        // This bucle never ends... until is interrupted
        while (number <= upperNumber) {
            if (isPrime(number)) {
                System.out.printf("Number %d is Prime\n", number);
            }

            number++;
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
