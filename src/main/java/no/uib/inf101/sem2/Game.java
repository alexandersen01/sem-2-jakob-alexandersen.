package no.uib.inf101.sem2;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class Game {
    
    //all the numbers in the game
    int nums[][] = new int[GameBoard.GridSize][GameBoard.GridSize];
    boolean isGiven[][] = new boolean[GameBoard.GridSize][GameBoard.GridSize];

    public Game(){
        super();
    }

    public String getRandomLine(String filePath) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        Random rand = new Random();
        int randomIndex = rand.nextInt(lines.size());
        return lines.get(randomIndex);
    }

    public void newGame(int difficulty){

        //find random line from dataset.txt
        String line = "";
        try {
            line = getRandomLine("src/Dataset.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //split random line in strings with length 9 and add to nums[][]
        String[] split = line.split("(?<=\\G.{9})");
        for(int i = 0; i < split.length; i++){
            for(int j = 0; j < split[i].length(); j++){
                nums[i][j] = Integer.parseInt(split[i].substring(j, j+1));
            }
        }

        //print line to console
        System.out.println(line);

        //set isGiven[][] to true for all nums[][] that are not 0
        for(int i = 0; i < GameBoard.GridSize; i++){
            for(int j = 0; j < GameBoard.GridSize; j++){
                if(nums[i][j] != 0){
                    isGiven[i][j] = true;
                }
            }
        }
    }


    public static int[][] solve(int[][] input) {
        for (int i = 0; i < 9 * 9; i++) {
            if (input[i / 9][i % 9] != 0) {
                continue;
            }
            for (int j = 1; j <= 9; j++) {
                if (validNumber(input, i / 9, i % 9, j)) {
                    input[i / 9][i % 9] = j;
                    solve(input);
                }
            }
        }
        return input;
    }

    public static boolean validNumber(int[][] input, int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (input[row][i] == num) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (input[i][col] == num) {
                return false;
            }
        }
        int rowStart = (row / 3) * 3;
        int colStart = (col / 3) * 3;
        for (int i = rowStart; i < rowStart + 3; i++) {
            for (int j = colStart; j < colStart + 3; j++) {
                if (input[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

}
