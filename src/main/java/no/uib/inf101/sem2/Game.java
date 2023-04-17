package no.uib.inf101.sem2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class Game {
    public GameStatus state = GameStatus.ACTIVE;
    public static String solution = "";


    // all the numbers in the game
    // add solved boards to txt files
    // enum field
    // tallet, statusen til tallet, om tallet er gitt eller ikke
    // når tegner, tegner bare en rute -> jpanel (bare tilgang til det tallet
    // lager en klasse (sudokucell) field num, status
    // soduku cellview som tegner den ene ruten
    // den håndterer statusen til tallet

    // FUNKSJONALITET
    // ønsker en splash screen
    // ønsker en GAMEOVER -> om du har tapt eller vunnet

    // MODULARITET
    // Innenfor minimum
    // lage en ny klasse som representerer en celle og en som tegner en celle

    // KODESTIL
    // dokumentasjon og testing må skrives på alt som er public
    // kjør format på alle filene 

    int nums[][] = new int[GameBoard.GridSize][GameBoard.GridSize];
    boolean isGiven[][] = new boolean[GameBoard.GridSize][GameBoard.GridSize];

    public Game() {
        super();
    }

    public String getRandomLine(String filePath) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        Random rand = new Random();
        int randomIndex = rand.nextInt(lines.size());
        return lines.get(randomIndex);
    }

    public void newGame() {

        // find random line from dataset.txt
        String line = "";
        try {
            line = getRandomLine("src/Easy.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //get first 81 chars from line and add to nums[][]
        for (int i = 0; i < GameBoard.GridSize; i++) {
            for (int j = 0; j < GameBoard.GridSize; j++) {
                nums[i][j] = Integer.parseInt(line.substring(i * GameBoard.GridSize + j, i * GameBoard.GridSize + j + 1));
            }
        }

        
        // get the chars from the right of the comma in line and add to solution
        solution += line.substring(82);
        System.out.println(solution);


        // print line to console
        System.out.println(line);

        // set isGiven[][] to true for all nums[][] that are not 0
        for (int i = 0; i < GameBoard.GridSize; i++) {
            for (int j = 0; j < GameBoard.GridSize; j++) {
                if (nums[i][j] != 0) {
                    isGiven[i][j] = true;
                }
            }
        }
    }

    // public String getSolution() {
    //     return solution;
    // }


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

    //create eventlistener to check if all the numbers are filled in
    //if they are, call isSolved()
    public void checkIfSolved() {
        boolean solved = true;
        for (int i = 0; i < GameBoard.GridSize; i++) {
            for (int j = 0; j < GameBoard.GridSize; j++) {
                if (nums[i][j] == 0) {
                    solved = false;
                }
            }
        }
        if (solved) {
            isSolved();
        }
    }

    public boolean isFilled() {
        for (int i = 0; i < GameBoard.GridSize; i++) {
            for (int j = 0; j < GameBoard.GridSize; j++) {
                if (nums[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }


    public boolean isSolved() {


        String board = "";        
        //get all the numbers on from gameboard.box
        for (int i = 0; i < GameBoard.GridSize; i++) {
            for (int j = 0; j < GameBoard.GridSize; j++) {
                board += GameBoard.box[i][j].getText();
            }
        }
        System.out.println(board);

        System.out.println(solution);



        //check if board is equal to solution
        if (board.equals(solution)) {
            state = GameStatus.WON;
            System.out.println("You won!");
            return true;
        } else {
            state = GameStatus.LOST;
            System.out.println("You lost!");
            return false;
        }
    }

}
