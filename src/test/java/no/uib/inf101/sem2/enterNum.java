package no.uib.inf101.sem2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class enterNum {
    @Test
    public void testCellIsEditable() {
        Cell cell = new Cell(0, 0);  // create a new Cell object
        boolean expected = true;     // the expected value of isEditable
        boolean actual = cell.isEditable();  // retrieve the actual value of isEditable
        assertEquals(expected, actual);     // assert that the values are equal
    }

}
