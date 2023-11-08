package codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TheSupermarketQueue {

    public static int solveSuperMarketQueue(int[] customers, int n) {
        /*
        int solution = 0;
        if (n == 1 || customers.length == 1) {
            for (int i = 0; i < customers.length; i++) {
                solution += customers[i];
            }
        } else if(customers.length < n) {
            solution = Arrays.stream(customers).max().getAsInt();
        } else {
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                subList.add(customers[i]);
            }
            for (int j = subList.size(); j < customers.length; j++) {
                int min = Collections.min(subList);
                for(int k = 0; k < subList.size(); k++) {
                    if (subList.get(k) == min) {
                        subList.set(k, subList.get(k) + customers[j]);
                        break;
                    }
                }
            }
            solution = Collections.max(subList);
        }
        System.out.println(Arrays.toString(customers));
        System.out.println(n);
        return solution; */
        if (customers.length == 0) return 0;
        if (n == 1) return Arrays.stream(customers).sum();

        int[] times = new int[n];

        for (int i = 0; i < customers.length; i++) {
            times[0] += customers[i];
            Arrays.sort(times);
            System.out.println(times.toString());
        }

        return times[n - 1];
    }

    public static void main(String[] args) {
        int[] customers = {7,2};
        int n = 3;
        int result = solveSuperMarketQueue(customers, n);
        System.out.println(result);
    }
}
