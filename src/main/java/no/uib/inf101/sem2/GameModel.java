package no.uib.inf101.sem2;

/**
 * Responsible for representing the state of the Sudoku game board and providing
 * methods to interact with the board.
 */
public class GameModel {

    // constants
    public static final int GridSize = 9;
    private Game game;

    // constructor
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
