package no.uib.inf101.sem2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameBoard extends JPanel{


    // define size of grid, subgrid and cell
    public static final int GridSize = 9;
    public static final int CellSize = 3;
    public static final int CellPixels = 60;

    //define sizes of grid and cell
    public static final int BoardWidth = CellPixels * GridSize;
    public static final int BoardHeight = CellPixels * CellSize;

    private Cell[][] box = new Cell[GridSize][GridSize];
    private Game game = new Game();

    public GameBoard(){
        
        super.setLayout(new GridLayout(GridSize, GridSize));

        // Create the cells
        for(int row = 0; row < GridSize; row++){
            for(int col = 0; col < GridSize; col++){
                box[row][col] = new Cell(row, col);
                super.add(box[row][col]);
            }
        }

        // Create the listener and incorporate it into the cells
        InputListener listener = new InputListener();
        for(int row = 0; row < GridSize; row++){
            for(int col = 0; col < GridSize; col++){
                if(box[row][col].isEditable())
                box[row][col].addActionListener(listener);
            }
        }

        //window size constants
        Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int dims = ((int) screenSize.getWidth()) / 3;


        super.setPreferredSize(new Dimension(dims, dims));
        

    }

    // inner InputListener class for all the editdable cells, because no other classes need to know about it
    private class InputListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            Cell cell = (Cell) e.getSource();

            // Get the value of the cell
            int cellValue = Integer.parseInt(cell.getText());

            // Check if the value is correct
            if(cellValue == game.nums[cell.row][cell.col]){
                cell.status = CellStatus.CORRECT_GUESS;
            } else {
                cell.status = CellStatus.WRONG_GUESS;
            }
            //repaint the cell
            cell.paint();
        }
    }

    public void newGame(){
        game.newGame();

        // Set the values of the cells
        for(int row = 0; row < GridSize; row++){
            for(int col = 0; col < GridSize; col++){
                box[row][col].newGame(game.nums[row][col], game.isGiven[row][col]);
            }
        }
    }

    public boolean isSolved(){
        // Check if the game is solved
        for(int row = 0; row < GridSize; row++){
            for(int col = 0; col < GridSize; col++){
                if(box[row][col].status == CellStatus.TO_GUESS || box[row][col].status == CellStatus.WRONG_GUESS){
                    return false;
                }
            }
        }
        return true;

    }
}
