package codewars;

import java.util.ArrayList;
import java.util.List;

public class NotPrimeNumbers {

    public static List<Integer> notPrimes(int a, int b) {
        List<Integer> notPrime = new ArrayList<>();
        for (int i = a; i < b; i++) {
            if(!isPrime(i) && allDigitsArePrime(i)) {
                notPrime.add(i);
            }
        }
        return notPrime; // Do your magic!
    }

    public static boolean allDigitsArePrime (int number) {
        char[] digits = String.valueOf(number).toCharArray(); //55 -> [5,5]
        for (char digit : digits) {
            if (!isPrime(Integer.parseInt(String.valueOf(digit)))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
        }

    public static void main(String[] args) {
        int a = 22;
        int b = 222;
        List<Integer> result = notPrimes(a, b);
        System.out.println(result);

    }

}
