package tictactoe;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicTacToeTest {
    private TicTacToe game;
    private Board board;

    @BeforeEach
    public void setUp() {
        game = new TicTacToe();
        board = game.getBoard();
    }

    // ==========================================
    // Tests for Board.print() Layout
    // ==========================================

    @Test
    public void testPrintOutputLayoutPositive() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Set up a recognizable board state
        board.place(1, 1, 'X');
        board.print();

        String expected = "-------" + System.lineSeparator() +
                          "| | | |" + System.lineSeparator() +
                          "| |X| |" + System.lineSeparator() +
                          "| | | |" + System.lineSeparator() +
                          "-------" + System.lineSeparator();

        assertEquals(expected, outContent.toString(), 
            "The board UI should print the exact grid framework with markers.");
        System.setOut(System.out); // Reset stream
    }

    @Test
    public void testPrintOutputLayoutNegative() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        board.place(0, 0, 'O');
        board.print();

        // A deliberate bad layout match string (missing borders/wrong symbols)
        String wrongExpectedLayout = "|O| | |\n"; 

        assertNotEquals(wrongExpectedLayout, outContent.toString(), 
            "The output shouldn't match broken structural strings.");
        System.setOut(System.out); // Reset stream
    }

    // ==========================================
    // Tests for Board.isCellEmpty() State Tracking
    // ==========================================

    @Test
    public void testIsCellEmptyPositive() {
        // Positive Case: Checking a pristine, empty coordinates position
        assertTrue(board.isCellEmpty(0, 2), 
            "An untouched coordinate should correctly report as empty.");
    }

    @Test
    public void testIsCellEmptyNegative() {
        // Negative Case A: Checking a coordinate that contains an active marker
        board.place(0, 2, 'X');
        assertFalse(board.isCellEmpty(0, 2), "An occupied cell must not report as empty.");

        // Negative Case B: Checking out of bound coordinates
        assertFalse(board.isCellEmpty(-1, 0), 
            "Out of bounds lower limits should safely return false.");
        assertFalse(board.isCellEmpty(3, 3), 
            "Out of bounds upper limits should safely return false.");
    }

    @Test
    public void testHasWinnerPositive() {
        TicTacToe game = new TicTacToe();

        game.getBoard().place(0, 0, 'X');
        game.getBoard().place(0, 1, 'X');
        game.getBoard().place(0, 2, 'X');

        assertTrue(game.hasWinner(), 
            "Positive Test Failed: X should have won with 3 in a row.");
    }

    @Test
    public void testHasWinnerNegative() {
        TicTacToe game = new TicTacToe();

        game.getBoard().place(0, 0, 'X');
        game.getBoard().place(0, 1, 'O');
        game.getBoard().place(0, 2, 'X');

        assertFalse(game.hasWinner(), "Negative Test Failed: Mixed row should not trigger a win.");
    }

    @Test
    public void testStartInitializesGamePositive() {
        TicTacToe game = new TicTacToe();

        assertNotNull(game.getBoard(), "Positive Test Failed: Board should be accessible via getter.");
    }

    @Test
    public void testStartGameOverFlagNegative() {
        TicTacToe game = new TicTacToe();

        assertFalse(game.hasWinner(), "Negative Test Failed: A newly started game should not instantly have a winner.");
    }

    @Test
    public void testClearPositive() {
        Board board = new Board();
        board.place(1, 1, 'O'); // Put a marker down

        board.clear();

        char[][] cells = board.getCells();
        assertEquals(' ', cells[1][1], "Positive Test Failed: clear() did not empty the cell.");
    }

    @Test
    public void testClearNegative() {
        Board board = new Board();
        board.clear();

        assertFalse(board.isFull(), 
            "Negative Test Failed: Clearing an empty board shouldn't break it or mark it full.");
    }
}
