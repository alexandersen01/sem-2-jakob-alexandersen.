package no.uib.inf101.sem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class solutionTest {

    @Test
    public void testIsSolved() {

        Game game = new Game();
        String solution = "123456789456789123789123456234567891567891234891234567345678912678912345912345678";
        
        String board = solution;
        
        // pass the board and solution to the isSolved method
        boolean expected = true;
        boolean actual = game.isSolved(board, solution);
    }
}