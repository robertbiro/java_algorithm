package codewars;

import java.rmi.MarshalledObject;
import java.util.*;
import java.util.stream.Collectors;

//https://howtodoinjava.com/java/sort/java-sort-map-by-values/

public class SimpleFrequencySort {

    public static int[] sortByFrequency(int[] array) {
        Map<Integer, Integer> counter = countFrequency(array);
        Integer[] integerArray = Arrays.stream(array)
                .boxed()
                //.boxed(): Converts the IntStream to a Stream<Integer>.
                .toArray(Integer[]::new);
        //Converts the Stream<Integer> to an array of Integer.
        Comparator<Integer> customComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                int freqComparison = Integer.compare(counter.get(b), counter.get(a));
                if (freqComparison != 0) {
                    return freqComparison;
                }
                return Integer.compare(a, b);
            }
        };
        Arrays.sort(integerArray, customComparator);
        // the original array is modified,
        return Arrays.stream(integerArray)
                .mapToInt(Integer::intValue)
                //.mapToInt(Integer::intValue): This intermediate operation transforms the stream of Integer
                // objects into an IntStream. It extracts the integer values from the Integer objects using
                // the intValue method. This is necessary because the terminal
                // operation toArray() expects an int[] array, not Integer[]
                .toArray();
    }

    public static Map<Integer, Integer> countFrequency(int[] numbers) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int number : numbers) {
            if(counter.containsKey(number)) {
                counter.put(number, counter.get(number) +1);
            } else {
                counter.put(number, 1);
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        int[] example = {2, 3, 5, 3, 7, 9, 5, 3, 7};
        // Sort the array based on frequency and value
        int[] sortedArray = sortByFrequency(example);
        // Print the sorted array
        System.out.println(Arrays.toString(sortedArray));


    }
}
