package codewars;
//https://www.codewars.com/kata/59e66e48fc3c499ec5000103/train/java
//!! permutation without repetition
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayCombinations {

    public static int solve(final List<List<Integer>> data) {
        List<List<Integer>> removeDuplication = data.stream()
                                    .map(innerList -> innerList.stream().distinct().collect(Collectors.toList()))
                                    .collect(Collectors.toList());
        int result = 1;
        for (List<Integer> innerList : removeDuplication) {
            result *= innerList.size();
        }
        System.out.println(result);
        return result; // your code here
    }

    public static void main(String[] args) {
        List<List<Integer>> data = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(4, 4),
                Arrays.asList(5, 6, 6)
        );
        int result = solve(data);
        System.out.println(result);
    }
}
