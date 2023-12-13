package codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HumanReadableDurationFormat {

    public static String formatDuration(int seconds) {

        if (seconds == 0) {
            return "now";
        }

        StringBuilder result = new StringBuilder();
        int[] durations = { 365 * 24 * 60 * 60, 24 * 60 * 60, 60 * 60, 60, 1 };
        boolean isPreviousComponentAdded = false;

        for (int i = 0; i < durations.length; i++) {
            int time = durations[i];
            if (seconds >= time) {
                int count = seconds / time;
                seconds = seconds % time;

                if (isPreviousComponentAdded) {
                    if (seconds > 0) {
                        result.append(", ");
                    } else {
                        result.append(" and ");
                    }
                }

                result.append(count).append(" ").append(fixExpression(count, i));
                isPreviousComponentAdded = true;
            }
        }

        System.out.println(result.toString());
        return result.toString();
    }

    public static String fixExpression(int num, int i) {
        String[] units = { "year", "day", "hour", "minute", "second" };
        String result = "";
        if(num > 1) {
            result = units[i] + "s";
        } else {
            result = units[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int second = 205851834;
        formatDuration(second);

    }
}
