package no.uib.inf101.sem2;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;

/**
 * This class draws the cells in the game board.
 * <p>
 * There's about 81 cells in one board
 */

public class Cell extends JTextField{
    
    public static Color BackgroundColor = Color.WHITE;
    public static Color EmptyColor = Color.YELLOW;
    public static Color WrongGuessColor = Color.GRAY;
    public static Color CorrectGuessColor = Color.GREEN;
    public static Color GivenColor = Color.BLACK;
    public static Color ToGuessColor = Color.BLUE;
    public static Font NUMBER_FONT = new Font("Avenir", Font.PLAIN, 40);


    // Row and column of the cell
    int row;
    int col;

    // The value of the cell
    int value;

    // The status of the cell
    CellStatus status;

    // Cell constructor
    public Cell(int row, int col){
        // Jtextfield for the cell
        super();
        this.row = row;
        this.col = col;

        // Center and set font to super
        super.setHorizontalAlignment(JTextField.CENTER);
        super.setFont(NUMBER_FONT);
    }

    /**
     * Method for a new game, resets the cell
     */

    public void newGame(int value, boolean given){
        this.value = value;
        if (given) {
            status = CellStatus.GIVEN;
        } else {
            status = CellStatus.TO_GUESS;
        }
        paint();
    }


    public void paint(){
        switch (status) {
            case GIVEN:
                super.setBackground(BackgroundColor);
                super.setForeground(GivenColor);
                super.setText(value + "");
                super.setEditable(false);
                break;

            case TO_GUESS:
                super.setBackground(EmptyColor);
                super.setForeground(ToGuessColor);
                super.setText("");
                super.setEditable(true);
                break;

            case WRONG_GUESS:
                super.setBackground(WrongGuessColor);
                break;

            case CORRECT_GUESS:
                super.setBackground(CorrectGuessColor);
                break;

        }




        //paint lines in a 3x3 grid
        if (row % 3 == 0 && col % 3 == 0) {
            super.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 1, 1, 1, Color.BLACK));
        } else if (row % 3 == 0 && col % 3 == 1) {
            super.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 1, 1, 1, Color.BLACK));
        } else if (row % 3 == 0 && col % 3 == 2) {
            super.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 1, 1, 3, Color.BLACK));
        } else if (row % 3 == 1 && col % 3 == 0) {
            super.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        } else if (row % 3 == 1 && col % 3 == 1) {
            super.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        } else if (row % 3 == 1 && col % 3 == 2) {
            super.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 3, Color.BLACK));
        } else if (row % 3 == 2 && col % 3 == 0) {
            super.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 1, Color.BLACK));
        } else if (row % 3 == 2 && col % 3 == 1) {
            super.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 1, Color.BLACK));
        } else if (row % 3 == 2 && col % 3 == 2) {
            super.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 3, Color.BLACK));
        }
    }
}
