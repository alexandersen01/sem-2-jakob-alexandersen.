package no.uib.inf101.sem2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameView extends JPanel {

    public static final int GridSize = 9;
    public static final int CellPixels = 60;

    private Cell[][] box;
    private GameModel model;

    public GameView(GameModel model) {
        this.model = model;
        initializeBoard();
        createCells();
        addListeners();
        setPreferredSize(new Dimension(CellPixels * GridSize, CellPixels * GridSize / 3));
    }

    private void initializeBoard() {
        setLayout(new GridLayout(GridSize, GridSize));
        box = new Cell[GridSize][GridSize];
    }

    private void createCells() {
        for (int row = 0; row < GridSize; row++) {
            for (int col = 0; col < GridSize; col++) {
                box[row][col] = new Cell(row, col);
                add(box[row][col]);
            }
        }
    }

    private void addListeners() {
        InputListener listener = new InputListener();
        for (int row = 0; row < GridSize; row++) {
            for (int col = 0; col < GridSize; col++) {
                if (box[row][col].isEditable())
                    box[row][col].addActionListener(listener);
            }
        }
    }

    public void updateView() {
        for (int row = 0; row < GridSize; row++) {
            for (int col = 0; col < GridSize; col++) {
                box[row][col].newGame(model.getCellValue(row, col), model.isGiven(row, col));
            }
        }
    }

    private class InputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Cell cell = (Cell) e.getSource();
            cell.paint();
        }
    }
}
