package codewars;

public class LoneliestCharacter {

    public static char[] loneliest(String s) {
        StringBuilder correctS = new StringBuilder(s.trim());
        String result = "";
        int max = 0;
        for (int i = 0; i < correctS.toString().length(); i++) {
            if (Character.isLetter(correctS.charAt(i))) {
                int counter = 0;
                int forward = i;
                int back = i;
                boolean nextLetter = false;
                boolean previousLetter = false;
                while (!nextLetter) {
                    if (forward != correctS.length() - 1) {
                        forward++;
                    }
                    if (Character.isLetter(correctS.charAt(forward))) {
                        nextLetter = true;
                    } else {
                        counter++;
                    }
                }
                while (!previousLetter) {
                    if (back != 0) {
                        back--;
                    }
                    if (Character.isLetter(correctS.charAt(back))) {
                        previousLetter = true;
                    } else {
                        counter++;
                    }
                }
                if (counter > max) {
                    max = counter;
                    result = String.valueOf(correctS.charAt(i));
                } else if (counter == max) {
                    max = counter;
                    result += String.valueOf(correctS.charAt(i));
                }
            }
        }
        // May the schwartz be with you
        return result.toCharArray();
    }

    public static void main(String[] args) {
        String s = "abc";
        char[] result = loneliest(s);
        System.out.println(result.toString());

    }
}
