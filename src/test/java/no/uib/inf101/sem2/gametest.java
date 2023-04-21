package no.uib.inf101.sem2;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class gametest {
    @Test
    public void testNewGame() {
        Game game = new Game();
        game.newGame();
        assertNotNull(Game.solution);
    }


    @Test
    public void testGetRandomLine() throws IOException {
        Game game = new Game();
        String line = game.getRandomLine("src/Test.txt");
        assertNotNull(line);
    }
}
