package leetcode;

public class LongestPalindromicSubstring {
    //first
    /*

    private static boolean isPalindrome(String sub) {
        StringBuilder rev = new StringBuilder(sub);
        if( sub.equals(rev.reverse().toString())) {
            return true;
        }
        return false;
    }

    public static String longestPalindrome(String s) {
        int sLength = s.length();
        String bestPalindrome = "";
        int max = 0;

        if (sLength < 2) {
            return s;
        }
        for (int i = 0; i < sLength; i++) {
            for (int j = i; j < sLength; j++) {
                int len = j - i + 1;
                String sub = s.substring(i, j + 1); // Extract the current substring correctly
                if (isPalindrome(sub) && len > max) {
                    max = len;
                    bestPalindrome = sub;
                }
            }
        }
        return bestPalindrome;
    }

*/
    //second

    public static String longestPalindrome(String s) {
        int max = 0;
        int resultStart = 0;
        int sLength = s.length();
        String bestPalindrome = "";

        if (sLength < 2) {
            return s;
        }
        for (int start = 0; start < sLength; start++) {

        }
        return s.substring(resultStart, resultStart + max);

    }

    public static void main(String[] args) {
        String s = "bfabafb";
        String result =  longestPalindrome(s);
        System.out.println(result);
    }
}
