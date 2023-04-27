package no.uib.inf101.sem2;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;

/**
 * This class draws the cells in the game board.
 * <p>
 * There's about 81 cells in one board
 */

public class Cell extends JTextField {

    private Color BackgroundColor = Color.WHITE;
    private Color EmptyColor = Color.YELLOW;
    private Color GivenColor = Color.BLACK;
    private Color ToGuessColor = Color.BLUE;
    private Font NUMBER_FONT = new Font("Avenir", Font.PLAIN, 40);

    // Row and column of the cell
    int row;
    int col;

    // The value of the cell
    int value;

    // The status of the cell
    CellStatus status;

    // Cell constructor
    public Cell(int row, int col) {
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

    public void newGame(int value, boolean given) {
        this.value = value;
        if (given) {
            status = CellStatus.GIVEN;
        } else {
            status = CellStatus.TO_GUESS;
        }
        paint();
    }
    
    // New method to set the cell value based on the typed character
    // for testing purposes
    public void setValueFromChar(char c) {
        if (Character.isDigit(c)) {
            value = Character.getNumericValue(c);
        } else {
            value = 0;
        }
    }

    // gets the value from the cell. testing purposes
    public int getValue() {
        return value;
    }

    /**
     * Paints cells in the game board
     * <p>
     * The cells are painted in different colors depending on their status, and
     * given cells are not editable
     */
    public void paint() {
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

                // Only allow numbers to be typed in the cell
                super.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyTyped(java.awt.event.KeyEvent evt) {
                        char c = evt.getKeyChar();
                        if (!(Character.isDigit(c) || (c == java.awt.event.KeyEvent.VK_BACK_SPACE)
                                || (c == java.awt.event.KeyEvent.VK_DELETE))) {
                            evt.consume();
                        }
                    }
                });

                // only allow one digit in the cell
                super.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyTyped(java.awt.event.KeyEvent evt) {
                        if (getText().length() >= 1) {
                            evt.consume();
                        }
                    }
                });
                break;
        }

        // paint lines in a 3x3 grid
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
