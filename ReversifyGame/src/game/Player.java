package game;

public class Player {
    public String name;
    public int totalMoves = 0;
    public int correct = 0;
    public int wrong = 0;
    private long startTime;

    public Player(String name) {
        this.name = name;
        this.startTime = System.currentTimeMillis();
    }

    public double getElapsedTime() {
        return (System.currentTimeMillis() - startTime) / 1000.0;
    }
}