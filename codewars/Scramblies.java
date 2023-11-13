package codewars;

import java.util.HashMap;
import java.util.Map;

public class Scramblies {

    public static boolean scramble(String str1, String str2) {
        boolean res = false;
        Map<Character, Integer> result = createMapFromSample(str2);
        Map<Character, Integer> result2 = decreaseValueOfSameChar(result, str1);
        for (int value : result2.values()) {
            if (value <= 0) {
                res = true;
        } else {
                res = false;
                break;
            }
        }
        return res;
    }

    public static Map<Character, Integer> createMapFromSample(String str2) {
        Map<Character, Integer> counterStr1 = new HashMap<>();
        char[] strArray = str2.toCharArray();
        for (char c : strArray) {
            if (counterStr1.containsKey(c)) {
                counterStr1.put(c, counterStr1.get(c) + 1);
            } else {
                counterStr1.put(c, 1);
            }
        }
        return counterStr1;
    }

    public static Map<Character, Integer> decreaseValueOfSameChar(Map<Character, Integer> counterStr1, String str1) {
        char[] str2Array = str1.toCharArray();
        for (char c : str2Array) {
            if (counterStr1.containsKey(c)) {
                //the corresponding value will be decreased by 1
                counterStr1.put(c, counterStr1.get(c) - 1);
            }
        }
        return counterStr1;
    }

    public static void main(String[] args) {
        String s1 = "katas";
        String s2 = "steak";
        boolean res = scramble(s1, s2);
        System.out.println(res);
    }
}
