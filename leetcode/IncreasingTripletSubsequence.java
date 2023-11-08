package leetcode;

import java.util.Arrays;

public class IncreasingTripletSubsequence {

    public static boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE;
        int middle = Integer.MAX_VALUE;
        int[] triplet = new int[3];
        int i = 0, j = 0, k = 0;

        for (int index = 0; index < nums.length; index++) {
            int num = nums[index];
        if (num <= small) {
            small = num;
            i = index;
        } else if (num <= middle && index != i) {
            middle = num;
            j = index;
        } else if (index != i && index != j) {
            k = index;
            triplet[0] = nums[i];
            triplet[1] = nums[j];
            triplet[2] = nums[k];
            System.out.println(Arrays.toString(triplet));
            return true; // We found an increasing triplet with i < j < k.
            }
        }

        return false; // No increasing triplet found.
    }

public static void main(String[] args) {
        int[] nums = {0, 3, -5, 6, 2, 10};
        boolean result = increasingTriplet(nums);
    }
}
