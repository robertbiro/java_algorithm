package codewars;

public class TransformToPrime {

    public static int createMinimumNumber(int[] numbers) {
        int result = sum(numbers);
        if(isPrime(result)) {
            return 0;
        } else {
            int num = 0;
            while (!isPrime(result + num)) {
                num += 1;
            }
            return num;
        }
    }

    public static int sum (int[] numbers) {
        int result = 0;
        for (int i = 0; i < numbers.length; i++) {
            result += numbers[i];
        }
        return result;
    }

    public static boolean isPrime(int number) {
        if(number <= 1) {
            return false;
        } else {
            for (int j = 2; j < number; j++) {
                if ((number % j) == 0) {
                    return false;
                }
            }
            return true;
        }
    }


    public static void main(String[] args) {

    }
}
