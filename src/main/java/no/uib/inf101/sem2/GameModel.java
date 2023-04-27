package no.uib.inf101.sem2;

public class GameModel {

    public static final int GridSize = 9;
    private Game game;

    public GameModel() {
        game = new Game();
    }

    public void newGame() {
        game.newGame();
    }

    public int getCellValue(int row, int col) {
        return game.nums[row][col];
    }

    public boolean isGiven(int row, int col) {
        return game.isGiven[row][col];
    }
}
