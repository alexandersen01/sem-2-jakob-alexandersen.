package no.uib.inf101.sem2;

/**
 * The status of a cell in the game.
 * <p>
 * The statuses are:
 * <ul>
 * <li>GIVEN: The cell is given in the puzzle</li>
 * <li>TO_GUESS: The cell is to be guessed</li>
 * <li>WRONG_GUESS: The cell is guessed wrong</li>
 * <li>CORRECT_GUESS: The cell is guessed correct</li>
 * </ul>
 * If no cells have the status WRONG_GUESS or TO_GUESS, the game is won.
 */

public enum CellStatus {
    GIVEN, // The cell is given in the puzzle
    TO_GUESS, // The cell is to be guessed
    WRONG_GUESS, // The cell is guessed wrong
    CORRECT_GUESS // The cell is guessed correct

    // If no cells have the status WRONG_GUESS or TO_GUESS, the game is won
}
