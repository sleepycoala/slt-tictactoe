package tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    private Board board;

    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    public void testClearInitializesEmptyCells() {
        board.place(0, 0, 'X');
        board.clear();
        assertTrue(board.isCellEmpty(0, 0),
            "Cells should be completely empty after clear sequence.");
    }

    @Test
    public void testIsCellEmptyAndPlace() {
        assertTrue(board.isCellEmpty(1, 1));
        board.place(1, 1, 'X');
        assertFalse(board.isCellEmpty(1, 1));
    }

    @Test
    public void testIsFull() {
        assertFalse(board.isFull());
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.place(i, j, 'X');
            }
        }
        assertTrue(board.isFull(), "Board should report full when no spaces remain.");
    }

    @Test
    public void testPrintOutputLayout() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        board.place(1, 1, 'X');
        board.print();

        String expected = "-------" + System.lineSeparator() +
                          "| | | |" + System.lineSeparator() +
                          "| |X| |" + System.lineSeparator() +
                          "| | | |" + System.lineSeparator() +
                          "-------" + System.lineSeparator();

        assertEquals(expected, outContent.toString());
        System.setOut(System.out); // Reset standard output stream
    }
}
