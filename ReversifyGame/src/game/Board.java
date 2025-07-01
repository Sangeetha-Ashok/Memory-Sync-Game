package game;
import java.util.*;

public class Board {
    private String[][] board;
    private boolean[][] matched;
    private final int size = 4;

    public Board() {
        board = new String[size][size];
        matched = new boolean[size][size];
        List<String> symbols = new ArrayList<>();
        for (char c = 'A'; c < 'I'; c++) {
            symbols.add(String.valueOf(c));
            symbols.add(String.valueOf(c));
        }
        Collections.shuffle(symbols);
        Iterator<String> it = symbols.iterator();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = it.next();
            }
        }
    }

    public void displayTemporary(int x1, int y1, int x2, int y2) {
        System.out.println("    0 1 2 3");
        for (int i = 0; i < size; i++) {
            System.out.print(i + " | ");
            for (int j = 0; j < size; j++) {
                if (matched[i][j] || (i == x1 && j == y1) || (i == x2 && j == y2))
                    System.out.print(board[i][j] + " ");
                else
                    System.out.print("* ");
            }
            System.out.println();
        }
    }

    public void displayMatchedOnly() {
        System.out.println("    0 1 2 3");
        for (int i = 0; i < size; i++) {
            System.out.print(i + " | ");
            for (int j = 0; j < size; j++) {
                if (matched[i][j])
                    System.out.print(board[i][j] + " ");
                else
                    System.out.print("* ");
            }
            System.out.println();
        }
    }

    public boolean flip(int x, int y) {
        return !matched[x][y];
    }

    public String getSymbol(int x, int y) {
        return board[x][y];
    }

    public void markAsMatched(int x1, int y1, int x2, int y2) {
        matched[x1][y1] = true;
        matched[x2][y2] = true;
    }

    public boolean allMatched() {
        for (boolean[] row : matched)
            for (boolean b : row)
                if (!b) return false;
        return true;
    }
}