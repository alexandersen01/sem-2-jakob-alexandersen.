package no.uib.inf101.sem2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

/**
 * The game class. This class contains the game logic.
 */

public class Game {
    public GameStatus state = GameStatus.ACTIVE;
    public static String solution = "";

    int nums[][] = new int[GameBoard.GridSize][GameBoard.GridSize];
    boolean isGiven[][] = new boolean[GameBoard.GridSize][GameBoard.GridSize];

    // constructor
    public Game() {
        super();
    }

    /**
     * Gets a random line from a file
     * 
     * @param filePath
     * @return String
     * @throws IOException
     */
    public String getRandomLine(String filePath) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        Random rand = new Random();
        int randomIndex = rand.nextInt(lines.size());
        return lines.get(randomIndex);
    }

    /**
     * Starts a new game
     */
    public void newGame() {

        // find random line from dataset.txt
        String line = "";
        try {
            line = getRandomLine("src/Easy.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // get first 81 chars from line and add to nums[][]
        for (int i = 0; i < GameBoard.GridSize; i++) {
            for (int j = 0; j < GameBoard.GridSize; j++) {
                nums[i][j] = Integer
                        .parseInt(line.substring(i * GameBoard.GridSize + j, i * GameBoard.GridSize + j + 1));
            }
        }

        // get the chars from the right of the comma in line and add to solution
        solution += line.substring(82);

        // set isGiven[][] to true for all nums[][] that are not 0
        for (int i = 0; i < GameBoard.GridSize; i++) {
            for (int j = 0; j < GameBoard.GridSize; j++) {
                if (nums[i][j] != 0) {
                    isGiven[i][j] = true;
                }
            }
        }
    }

    /**
     * Checks if the game is solved
     * 
     * @return Boolean (true, hopefully)
     */
    public boolean isSolved() {
        // Check that GameBoard.box is not null
        if (GameBoard.box == null) {
            return false;
        }

        String board = "";
        // get all the numbers on from gameboard.box
        for (int i = 0; i < GameBoard.GridSize; i++) {
            for (int j = 0; j < GameBoard.GridSize; j++) {
                // Check that GameBoard.box[i][j] is not null
                if (GameBoard.box[i][j] == null) {
                    return false;
                }
                board += GameBoard.box[i][j].getText();
            }
        }

        // check if board is equal to solution
        if (board.equals(solution)) {
            state = GameStatus.WON;
            return true;
        } else {
            state = GameStatus.LOST;
            return false;
        }
    }

}
