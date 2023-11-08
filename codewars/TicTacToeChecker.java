package codewars;

public class TicTacToeChecker {

    public static int isSolved(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    return -1;
                } else if (board[i][j] == 1) {
                    
                }
            }
        }
        // your code here
        return 0;
    }

    public static void main(String[] args) {
        int[][] board = {{0, 0, 1},{0, 1, 2},{2, 1, 0}};

    }
}
