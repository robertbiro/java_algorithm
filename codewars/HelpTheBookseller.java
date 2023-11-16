package codewars;
//https://www.codewars.com/kata/54dc6f5a224c26032800005c/train/java
import java.util.HashMap;
import java.util.Map;

public class HelpTheBookseller {

    // 1st parameter is the stocklist (L in example),
    // 2nd parameter is list of categories (M in example)
    public static String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        Map<String, Integer> books = createMap(lstOfArt);
        String result = "";
        if (lstOfArt.length > 0 && lstOf1stLetter.length > 0) {
            for (int i = 0; i < lstOf1stLetter.length; i++) {
                String letter = lstOf1stLetter[i];
                Integer value = 0;
                if (books.containsKey(letter)) {
                    value = books.get(letter);
                } else {
                    value = 0;
                }
                String part = "(" + letter + " : " + value + ")";
                result += part;
                if (i < lstOf1stLetter.length - 1) {
                    result += " - ";
                }
            }
        } else {
            result.toCharArray();
        }

        System.out.println(result);
        return result;
    }
    public static Map<String, Integer> createMap(String[] lstOfArt) {
        Map<String, Integer> books = new HashMap<>();
        for (String item : lstOfArt) {
            String[] words = item.split("\\s+");
            String key = Character.toString(words[0].charAt(0));
            int value = Integer.parseInt(words[1]);
            if (books.containsKey(key)) {
                books.put(key, books.get(key) + value);
            } else {
                books.put(key, value);
            }
        }
        printMap(books);
        return books;
    }
    public static void printMap(Map<String, Integer> books) {
        for(Map.Entry<String, Integer> entry : books.entrySet()) {
            //System.out.printf("(%s : %d)", entry.getKey(), entry.getValue());
        }
    }

    public static void main(String[] args){
        String[] lstOfArt = {"ABART 20", "CDXEF 50", "BKWRK 25", "BTSQZ 89", "DRTYM 60"};
        String[] lstOf1stLetter = {"A", "B", "W"};
        stockSummary(lstOfArt, lstOf1stLetter);
        }

}
