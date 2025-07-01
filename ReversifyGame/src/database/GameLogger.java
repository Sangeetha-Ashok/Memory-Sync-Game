package database;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GameLogger {
    private String playerName;
    private PrintWriter writer;

    public GameLogger(String playerName) throws IOException {
        this.playerName = playerName;
        this.writer = new PrintWriter(new FileWriter("reversify_log.txt", true));
    }

    public void logMove(int move, String pos1, String pos2, boolean match, double time) {
        writer.println("Move " + move + ": " + pos1 + " & " + pos2 + " -> " + (match ? "Match" : "Mismatch") + " (Time: " + time + "s)");
        writer.flush();
    }

    public void logScore(int total, int correct, int wrong, double time) {
        writer.println("Player: " + playerName);
        writer.println("Total Moves: " + total + ", Correct: " + correct + ", Wrong: " + wrong);
        writer.println("Total Time: " + time + " seconds");
        writer.println("--------------------------------------------------");
        writer.close();
    }
}