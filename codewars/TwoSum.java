package codewars;

import java.util.Arrays;

public class TwoSum {

    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        for(int i = 0; i < numbers.length; i++) {
            int subst = target - numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] == subst) {
                    result[0] = i;
                    result[1] = j;

                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 2 ,3};
        int target = 4;
        int[] result = twoSum(numbers, target);
        System.out.println(Arrays.toString(result));

    }


}
