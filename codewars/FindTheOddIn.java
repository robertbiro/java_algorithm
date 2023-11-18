package codewars;

import java.util.Arrays;

public class FindTheOddIn {

        public static int findIt(int[] a) {
            Arrays.sort(a);
            for (int i = 0; i < a.length; i++) {
                int count = 1;

                for(int j = i +1; j < a.length -1; j++) {
                    if (a[i] == a[j]) {
                        count++;
                    } else {
                        break;
                    }
                }
                if (count % 2 == 1) {
                    return a[i];
                }
                //skip index forward;
                i += count - 1;
            }

            return 0;
        }

    public static void main(String[] args) {
        int[] a = {1, 2, 2, 3, 3, 3, 4, 3, 3, 3, 2, 2, 1};
        int result = findIt(a);
        System.out.println("Number that appears an odd number of times: " + result);
    }
}
