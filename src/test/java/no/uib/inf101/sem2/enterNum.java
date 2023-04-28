package no.uib.inf101.sem2;

import org.junit.jupiter.api.Test;

public class enterNum {

    @Test
    public void testCellInput() {
        Cell cell = new Cell(0, 0);

        // Simulate typing '2' in the cell
        cell.setValueFromChar('2');
        cell.setValueFromChar('2');

        // Assert that the value of the cell is 2
        assert cell.getValue() == 2;


        // Simulate typing 'b' in the cell
        cell.setValueFromChar('b');

        // Assert that the value of the cell is 0
        assert cell.getValue() == 0;
    }
}
