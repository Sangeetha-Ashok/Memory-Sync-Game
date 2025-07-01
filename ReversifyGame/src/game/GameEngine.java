package game;
import database.GameLogger;
import java.util.Scanner;

public class GameEngine {
    public void start() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter player name: ");
        Player player = new Player(sc.nextLine());
        GameLogger logger = new GameLogger(player.name);
        Board board = new Board();
        int move = 0;

        while (!board.allMatched()) {
            System.out.println("\nMove #" + (++move));

            int x1, y1, x2, y2;

            do {
                System.out.print("Enter first card (row col): ");
                x1 = sc.nextInt();
                y1 = sc.nextInt();
            } while (!board.flip(x1, y1));

            board.displayTemporary(x1, y1, -1, -1);

            do {
                System.out.print("Enter second card (row col): ");
                x2 = sc.nextInt();
                y2 = sc.nextInt();
            } while (!board.flip(x2, y2) || (x1 == x2 && y1 == y2));

            board.displayTemporary(x1, y1, x2, y2);

            String s1 = board.getSymbol(x1, y1);
            String s2 = board.getSymbol(x2, y2);
            boolean match = s1.equals(s2);
            double time = player.getElapsedTime();

            if (match) {
                System.out.println("\nIt's a Match!");
                board.markAsMatched(x1, y1, x2, y2);
                board.displayMatchedOnly();
                player.correct++;
            } else {
                System.out.println("\nNot a Match!");
                player.wrong++;
            }

            logger.logMove(move, x1 + "," + y1, x2 + "," + y2, match, time);
            player.totalMoves++;
        }

        double totalTime = player.getElapsedTime();
        logger.logScore(player.totalMoves, player.correct, player.wrong, totalTime);
        System.out.println("\nGame Completed in " + player.totalMoves + " moves and " + totalTime + " seconds!");
    }
}