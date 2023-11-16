package codewars;

public class NextSmallerNumberWithTheSameDigits {

    public static long nextSmaller(long n) {
        int length =  String.valueOf(n).length();
        long[] digits = new long[length];
        int counter = digits.length - 1;
        int index = digits.length - 3;

        splitInDigits(n, digits, counter);
        long[] slippedArray =  replaceElement(digits, index);
        long result = output(n, slippedArray, index);
        System.out.println(result);
        return result;
    }

    public static long[] splitInDigits(long n, long[] digits, int counter) {
        if (n / 10 > 0) {
            digits[counter] = n % 10;
            n /= 10;
            counter--;
            return splitInDigits(n, digits, counter);
        }
        digits[counter] = n % 10;
        return digits;
    }

    public static long convertArrayToLong(long[] array) {
        StringBuilder builder = new StringBuilder();
        for (long num : array) {
            builder.append(num);
        }
        return Long.parseLong(builder.toString());
    }

    public static long[] replaceElement(long[] array, int index) {
        //5381 -> 5318 --------> 5138
        //5318 -> 5138

        //6347 ->  || 4763

        //6743 ->                   || 6473
        //85467 -> 84765
        //90234 ->
        //92156 -> 91652: 9 Ok, 2 helyett kisebb (1), majd a maradékbol csökkenö
        //----------------------------------
        //92156 -> 9 .2.. 156 -> 91 ... 256 -> 91 652
        //9567214 -> 9 .5.. 12467 -> 94 ... 12567 -> 94 76521

        long[] slippedArray = new long[array.length];
        System.arraycopy(array, 0, slippedArray, 0, array.length);
        slippedArray [index + 1] = array[index + 2];
        slippedArray [index + 2] = array[index + 1];
        return slippedArray;
    }
    public static long output(long n, long[] slippedArray, int index) {
        long m = convertArrayToLong(slippedArray);
        long result = 0;
        if (n < 10) {
            result = -1;
        } else if (m < n) {
            result = m;
        } else if (m == n) {
            result = -1;
        } else if (slippedArray[0] == 0) {
            result = -1;
        } else {
            index--;
            long[] resultArray = replaceElement(slippedArray, index);
            result = output(n, resultArray, index);
        }
        return result;
    }

    public static void main(String[] args) {
        nextSmaller(1027);
    }
}
