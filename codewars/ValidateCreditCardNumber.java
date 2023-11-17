package codewars;

public class ValidateCreditCardNumber {

    public static boolean validate(String n){
        char[] cardCharArray = String.valueOf(n).toCharArray();
        int sumOfAll = 0;
        for(int i = 0; i < cardCharArray.length; i++) {
            int temp = Character.getNumericValue(cardCharArray[i]);
            if(cardCharArray.length % 2 == 0 && i % 2 == 0 || cardCharArray.length % 2 == 1 && i % 2 == 1) {
                temp *= 2;
                if (temp >= 10) {
                    temp = getSumOfDigits(temp);
                }
            }
            sumOfAll += temp;
        }
        System.out.println(sumOfAll % 10 == 0);
        return sumOfAll % 10 == 0;
    }
    public static int getSumOfDigits(int number) {
        char[] digitsArray = String.valueOf(number).toCharArray();
        int sum = 0;
        for(int j = 0; j < digitsArray.length; j++) {
            sum += Character.getNumericValue(digitsArray[j]);
        }
        return sum;
    }

    public static void main(String[] args) {
        String n = "8675309";
        validate(n);

    }
}
