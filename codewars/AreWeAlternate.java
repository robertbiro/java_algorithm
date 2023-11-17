package codewars;
//https://www.codewars.com/kata/59325dc15dbb44b2440000af/train/java
public class AreWeAlternate {

    public static boolean isAlt(String word) {
        System.out.println(word);
        //make note that 'y' should not be treated as vowel
        //your code here
        int value;
        int[] values = new int[word.length()];
        int counter = 0;
        for (char letter : word.toCharArray()) {
            if (isVowel(letter)) {
                value = 1;
            } else {
                value = -1;
            }
            values[counter] = value;
            counter++;
        }
        boolean result = areSame(values);
        System.out.println(result);
        return result;
    }

    public static boolean isVowel(char letter) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        for(char vowel : vowels) {
            if (letter == vowel) {
                return true;
            }
        }
        return false;
    }
    public static boolean areSame(int[] values) {
        boolean result = false;
        for(int j = 0; j < values.length - 1; j++) {
            if (values[j] == values[j + 1]) {
                result = false;
                break;
            } else {
                result = true;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        isAlt("r");
    }
}
