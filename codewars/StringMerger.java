package codewars;
public class StringMerger {
    static int startIndexOfPart1 = 0;
    static int startIndexOfPart2 = 0;
    static int indexOfS = 0;
    static String concatString = "";
    static boolean subString = false;

    public static boolean isMerge(String s, String part1, String part2) {
        concatString = concatParts(s, part1, part2);
        System.out.println(concatString);
        if (concatString.equals(s)) {
            System.out.println(true);
            return true;
        } else {
            System.out.println(false);
            return false;
        }
    }

    public static int getSubString(int startIndex, String s, String part) {
        int index = startIndex;
        while (index < s.length() && index < part.length()) {
            char sOf = s.charAt(indexOfS);
            char partOf = part.charAt(index);
            if (sOf == partOf) {
                index++;
                indexOfS++;
                subString = true;
            } else {
                break;
            }
        }
        return index;
    }


    public static String concatParts(String s, String part1, String part2) {
        int endIndexOfPart1 = 0;
        int endIndexOfPart2 = 0;
        StringBuilder concat = new StringBuilder(concatString);
        endIndexOfPart1 = getSubString(startIndexOfPart1, s, part1);
        endIndexOfPart2 = getSubString(startIndexOfPart2, s, part2);
        if (startIndexOfPart1 >= startIndexOfPart2) {
            concat.append(s.substring(startIndexOfPart1, endIndexOfPart1));
            startIndexOfPart1 = endIndexOfPart1;
        } else {
            concat.substring(startIndexOfPart2, endIndexOfPart2);
            concat.append(s.substring(startIndexOfPart2, endIndexOfPart2));
            endIndexOfPart2 = endIndexOfPart2;
        }
        return concat.toString();
    }

    public static void main(String[] args) {
        String s = "aabaaaabaa";
        String part1 = "aabaa";
        String part2 = "aaaab";
        isMerge(s, part1, part2);
    }
}
