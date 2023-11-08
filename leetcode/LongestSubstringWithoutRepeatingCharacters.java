package leetcode;

public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {

        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            StringBuilder solution = new StringBuilder();

            for (int j = i; j < s.length(); j++) {
                char currentChar = s.charAt(j);

                if (solution.indexOf(String.valueOf(currentChar)) == -1) {
                    solution.append(currentChar);
                } else {
                    break;
                }

                maxLength = Math.max(maxLength, solution.length());
            }
        }

        return maxLength;

    }

    public static void main(String[] args) {
        int max = lengthOfLongestSubstring("pwwkew");
        System.out.println(max);

    }
}
