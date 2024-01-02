package codewars;

import java.util.ArrayList;
import java.util.List;

public class TheObservedPIN {

    public static List<String> getPINs(String observed) {
        String[][] buttons = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}, {" ", "0", " "}};
        String[] singleItem = observed.split("");
        List<String> numbersForSolutions = new ArrayList<>();
        for(int i = 0; i < singleItem.length; i++) {
            String item = singleItem[i];
            int[] coordinate = getCoordinate(buttons, item);
            String adjacent = getAdjacentNumbers(buttons, coordinate);
            numbersForSolutions.add(adjacent);
        }
        List<String> result = generateVariations(numbersForSolutions);
        for (String item : result) {
            System.out.println(item);
        }
        System.out.println(numbersForSolutions);
        return result;
    }

    public static List<String> generateVariations(List<String> numbersForSolutions) {
        List<String> result = new ArrayList<>();
        generateVariations(numbersForSolutions, 0, "", result);
        return result;
    }

    private static void generateVariations(List<String> numbersForSolutions, int index, String current, List<String> result) {
        if (index == numbersForSolutions.size()) {
            result.add(current);
        }

        if (index >= 0 && index < numbersForSolutions.size()) {
            for (int i = 0; i < numbersForSolutions.get(index).length(); i++) {
                char currentDigit = numbersForSolutions.get(index).charAt(i);
                generateVariations(numbersForSolutions, index + 1, current + currentDigit, result);
            }
        }
    }

    public static int[] getCoordinate(String[][] matrix, String item) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j].equals(item)) {
                    return new int[]{i, j};
                }
            }
        }
        // String not found
        return new int[0];
    }

    public static String getAdjacentNumbers(String[][]matrix, int[] coordinate) {
        int startRow = coordinate[0];
        int startColumn = coordinate[1];
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0,-1, 1, 0};
        StringBuilder result = new StringBuilder();
        result.append(matrix[startRow][startColumn]);
        for(int i = 0; i < 4; i++) {
            int newRow = startRow + dx[i];
            int newColumn = startColumn + dy[i];
            if (isValidCoordinate(matrix, newRow, newColumn) && matrix[newRow][newColumn] != " ") {
                result.append(matrix[newRow][newColumn]);
            }
        }
        return result.toString();
    }

    public static boolean isValidCoordinate(String[][] inputAsMatrix, int row, int col) {
        return row >= 0 && row < inputAsMatrix.length && col >= 0 && col < inputAsMatrix[0].length;
    }

    public static void main(String[] args) {
        getPINs("369");
    }

}
