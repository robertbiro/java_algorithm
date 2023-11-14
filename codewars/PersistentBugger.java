package codewars;
//https://www.codewars.com/kata/55bf01e5a717a0d57e0000ec/train/java
public class PersistentBugger {

    public static long persistence(long n) {
        long m = n;
        int counter = 0;
        long result = 0;
        while (m >= 10) {
            int length = String.valueOf(n).length();
            long[] digits = new long[length];
            multipleDigits(n, digits, counter);
            m = makeNewLong(digits);
            n = m;
            result++;
        };
        return result; // your code
    }
    public static long[] multipleDigits(long n, long[] digits, int  counter) {
        if (n / 10 > 0) {
            digits[counter] = n % 10;
            n /= 10;
            counter++;
            return multipleDigits(n, digits, counter );
        }
        digits[counter] = n % 10;
        return digits;
    }

    public static long makeNewLong(long[] digits) {
        long m = 1;
        for(int i = 0; i < digits.length; i++) {
            m *= digits[i];
        }
        return m;
    }

    public static void main(String[] args) {
        long n = 444;
        long number = persistence(n);
        System.out.println(number);
    }
}
