package no.uib.inf101.sem2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Responsible for visually presenting the Sudoku game board to the user and
 * handling user interactions with the board.
 */
public class GameView extends JPanel {

    // constants
    public static final int GridSize = 9;
    public static final int CellPixels = 60;

    // window size constants
    Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    int dims = ((int) screenSize.getWidth()) / 3;

    // instance variables
    public static Cell[][] box;
    private GameModel model;

    // constructor
    public GameView(GameModel model) {
        this.model = model;
        initializeBoard();
        createCells();
        addListeners();
        setPreferredSize(new Dimension(dims, dims));
    }

    // initialize board
    private void initializeBoard() {
        setLayout(new GridLayout(GridSize, GridSize));
        box = new Cell[GridSize][GridSize];
    }

    // create cells
    private void createCells() {
        for (int row = 0; row < GridSize; row++) {
            for (int col = 0; col < GridSize; col++) {
                box[row][col] = new Cell(row, col);
                add(box[row][col]);
            }
        }
    }

    // add listeners
    private void addListeners() {
        InputListener listener = new InputListener();
        for (int row = 0; row < GridSize; row++) {
            for (int col = 0; col < GridSize; col++) {
                if (box[row][col].isEditable())
                    box[row][col].addActionListener(listener);
            }
        }
    }

    // update view
    public void updateView() {
        for (int row = 0; row < GridSize; row++) {
            for (int col = 0; col < GridSize; col++) {
                box[row][col].newGame(model.getCellValue(row, col), model.isGiven(row, col));
            }
        }
    }

    // inner input listener class
    class InputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Cell cell = (Cell) e.getSource();
            cell.paint();
        }
    }
}
