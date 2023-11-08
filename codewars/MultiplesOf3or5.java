package codewars;

import java.util.ArrayList;
import java.util.List;

public class MultiplesOf3or5 {

    public static int Solution(int number) {
        List<Integer> solution = new ArrayList<>();
        for (int i = 1; i < number; i++) {
            if(i % 3 == 0 || i % 5 == 0 && !solution.contains(i)) {
                solution.add(i);
            }
        }
        return solution.stream()
                .reduce(0,Integer::sum);
    }

    public static void main(String[] args) {
        int result = Solution(10);
        System.out.println(result);
    }
}
