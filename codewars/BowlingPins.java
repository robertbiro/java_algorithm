package codewars;

import java.util.Arrays;

public class BowlingPins {

    public static String bowlingPins(int[] arr) {
        String bowling = "I I I I\n I I I \n  I I  \n   I   ";
        String bowlingValue = "7 8 9 0\n 4 5 6 \n  2 3  \n   1   ";
        System.out.println(bowling.length());
        for (int i = 0; i < arr.length; i++) {
            if(bowlingValue.contains(String.valueOf(arr[i]))) {
                bowlingValue =  bowlingValue.replace(String.valueOf(arr[i]), " ");
            }
            if (arr[i] == 10) {
                bowlingValue =  bowlingValue.replace("0", " ");
            }
        }
        // Replace all integers with "I"
        bowlingValue = bowlingValue.replaceAll("\\d+", "I");

        System.out.println(bowlingValue.length());
        System.out.println("I I I I\n I I I \n       \n       ");
        return bowlingValue;
    }


    public static void main(String[] args) {
        bowlingPins(new int[]{1, 2, 3});
    }
}
