package codewars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TheQueenOnTheChessboard {

    public static List<String> availableMoves(String position) {

        // your code here
        List<String> positions = new ArrayList<>();
        int convertedYCoorinate = Integer.parseInt(String.valueOf(position.charAt(1)));
        System.out.println(convertedYCoorinate -3);
        if(position.length() == 2 && convertedYCoorinate >= 1 && convertedYCoorinate <= 8 && position.charAt(0) >= 'A' && position.charAt(0) <= 'H') {
            int ycCoordinateToVertical = 1;
            //horizontal:
            for (int i = 'A'; i <= 'H'; i++) {
                String horizontalPos = "";
                horizontalPos = Character.toString(i) + position.charAt(1);
                if (!horizontalPos.equals(position)) {
                    positions.add(horizontalPos);
                }
                //vertical:
                String verticalPos = "";
                verticalPos = position.charAt(0) + String.valueOf(ycCoordinateToVertical);
                if (!verticalPos.equals(position)) {
                    positions.add(verticalPos);
                }
                ycCoordinateToVertical++;
                for (int j = 1; j <= 8; j++) {
                    //diagonal 1:
                    int yCoordinate = convertedYCoorinate - j;
                    if (position.charAt(0) - (char) i  == yCoordinate) {
                        StringBuilder stb1 = new StringBuilder();
                        stb1.append((char)i).append(j);
                        if(!positions.contains(stb1.toString()) && !stb1.toString().equals(position)) {
                            positions.add(stb1.toString());
                        }
                    }
                    //diagonal 2:
                    if ((char) i - position.charAt(0) == yCoordinate) {
                        StringBuilder stb2 = new StringBuilder();
                        stb2.append((char)i).append(j);
                        if(!positions.contains(stb2.toString()) && !stb2.toString().equals(position)) {
                            positions.add(stb2.toString());
                        }
                    }
                }
            }
            Collections.sort(positions);
            System.out.println(positions);
        }
        return positions;
    }

    public static void main(String[] args) {
        availableMoves("C5");

    }
}
