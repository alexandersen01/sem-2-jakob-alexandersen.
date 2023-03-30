package no.uib.inf101.sem2;

public class Game {
    
    //all the numbers in the game
    int nums[][] = new int[GameBoard.GridSize][9];
    boolean isGiven[][] = new boolean[GameBoard.GridSize][GameBoard.GridSize];

    public Game(){
        super();
    }

    public void newGame(int difficulty){
        // Create a new game
        // difficulty is the number of given cells
        // 0 = easy, 1 = medium, 2 = hard
        // 0 = 30 given cells, 1 = 40 given cells, 2 = 50 given cells
        int given = 30 + 10 * difficulty;
        int row, col, num;
        boolean valid;

        // Clear the board
        for(row = 0; row < GameBoard.GridSize; row++){
            for(col = 0; col < GameBoard.GridSize; col++){
                nums[row][col] = 0;
                isGiven[row][col] = false;
            }
        }

        // Fill the board with random numbers
        for(int i = 0; i < given; i++){
            do{
                row = (int) (Math.random() * GameBoard.GridSize);
                col = (int) (Math.random() * GameBoard.GridSize);
                num = (int) (Math.random() * GameBoard.GridSize) + 1;
                valid = true;

                // Check if the number is valid
                for(int j = 0; j < GameBoard.GridSize; j++){
                    if(nums[row][j] == num || nums[j][col] == num){
                        valid = false;
                        break;
                    }
                }

                // Check if the number is valid in the subgrid
                int subRow = row / GameBoard.CellSize;
                int subCol = col / GameBoard.CellSize;
                for(int j = subRow * GameBoard.CellSize; j < (subRow + 1) * GameBoard.CellSize; j++){
                    for(int k = subCol * GameBoard.CellSize; k < (subCol + 1) * GameBoard.CellSize; k++){
                        if(nums[j][k] == num){
                            valid = false;
                            break;
                        }
                    }
                }
            }while(!valid);

            // Set the number
            nums[row][col] = num;
            isGiven[row][col] = true;
        }
    }

}
