package codewars;

public class AscendDescendRepeat {

    public static String ascendDescend(int length, int minimum, int maximum) {

        StringBuilder result = new StringBuilder();
        int currentValue = minimum;
        boolean done = false;

        while (!done) {
            while (currentValue < maximum) {
                if (result.length() < length) {
                    result.append(currentValue);
                } else {
                    done = true;
                }
                currentValue++;
            }
            while (currentValue > minimum) {
                if (result.length() < length) {
                    result.append(currentValue);
                } else {
                    done = true;
                }
                currentValue--;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int length=11;
        int minimum=5;
        int maximum=9;
        System.out.println(ascendDescend(length, minimum, maximum));


    }
}
