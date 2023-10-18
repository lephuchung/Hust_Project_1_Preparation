import java.util.*;

public class Ex5 {
    public static void main(String[] args) {
        int[][] sudoku = new int[9][9];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = scanner.nextInt();
            }
        }
        int solutions = solveSudo(sudoku);
        System.out.println(solutions);
    }

    private static int solveSudo(int[][] sudoku) {// backtracking
        int[] emptyCell = findEmpty(sudoku);

        if (emptyCell == null) {
            return 1;
        }
        int row = emptyCell[0];
        int col = emptyCell[1];
        int solutions = 0;


        for (int num = 1; num <= 9; num++) {
            if (isValidMove(sudoku, row, col, num)) {
                sudoku[row][col] = num;
                solutions += solveSudo(sudoku);
                sudoku[row][col] = 0;
            }
        }
        return solutions;
    }

    private static int[] findEmpty(int[][] sudoku) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudoku[i][j] == 0) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
    private static boolean isValidMove(int[][] sudoku, int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[row][i] == num || sudoku[i][col] == num) {
                return false;
            }
        }
        int startR = row - row % 3;
        int startC = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (sudoku[i + startR][j + startC] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}