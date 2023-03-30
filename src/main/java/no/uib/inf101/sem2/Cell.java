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
    public static Color ForegroundColor = Color.BLACK;
    public static Color WrongGuessColor = new Color(199, 0, 17);
    public static Color CorrectGuessColor = new Color(0, 123, 255);
    public static Color GivenColor = new Color(0, 0, 0);
    public static Color ToGuessColor = new Color(0, 0, 0);
    public static Font NUMBER_FONT = new Font("Avenir", Font.PLAIN, 20);
    //TODO: check colors hehe

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
                super.setBackground(GivenColor);
                super.setForeground(GivenColor);
                super.setText(value + "");
                super.setEditable(false);
                break;

            case TO_GUESS:
                super.setBackground(BackgroundColor);
                super.setForeground(ForegroundColor);
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
    }
}
