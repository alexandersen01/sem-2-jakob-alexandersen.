package no.uib.inf101.sem2;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import org.junit.jupiter.api.Test;

class ViewTest {

    // test to initialize board
    @Test
    public void testInitializeBoard() {
        GameModel model = new GameModel();
        GameView gameView = new GameView(model);

        JPanel panel = gameView;
        assertNotNull(panel);

        assertEquals(GameView.GridSize * GameView.GridSize, panel.getComponentCount());
        assertEquals(new Dimension(gameView.dims, gameView.dims), panel.getPreferredSize());
    }

    // test to create cells
    @Test
    public void testCreateCells() {
        GameModel model = new GameModel();
        GameView gameView = new GameView(model);

        JPanel panel = gameView;
        assertNotNull(panel);

        int expectedCellCount = GameView.GridSize * GameView.GridSize;
        assertEquals(expectedCellCount, panel.getComponentCount());

        for (int row = 0; row < GameView.GridSize; row++) {
            for (int col = 0; col < GameView.GridSize; col++) {
                assertTrue(panel.getComponent(row * GameView.GridSize + col) instanceof Cell);
            }
        }
    }

    // test to add listeners
    // suppress warning because we know that we are adding the correct listeners
    @SuppressWarnings("static-access")
    @Test
    public void testAddListeners() {
        GameModel model = new GameModel();
        GameView gameView = new GameView(model);

        JPanel panel = gameView;
        assertNotNull(panel);

        ActionListener listener = gameView.new InputListener();
        assertNotNull(listener);

        for (int row = 0; row < GameView.GridSize; row++) {
            for (int col = 0; col < GameView.GridSize; col++) {
                Cell cell = gameView.box[row][col];
                if (cell.isEditable()) {
                    ActionListener[] listeners = cell.getActionListeners();
                    assertEquals(1, listeners.length);
                }
            }
        }
    }

}