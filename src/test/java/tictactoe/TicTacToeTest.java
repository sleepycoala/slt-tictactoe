

package tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {

    @Test
    public void testHasWinner_Positive() {
        TicTacToe game = new TicTacToe();

        game.getBoard().place(0, 0, 'X');
        game.getBoard().place(0, 1, 'X');
        game.getBoard().place(0, 2, 'X');

        assertTrue(game.hasWinner(), "Positive Test Failed: X should have won with 3 in a row.");
    }

    @Test
    public void testHasWinner_Negative() {
        TicTacToe game = new TicTacToe();

        game.getBoard().place(0, 0, 'X');
        game.getBoard().place(0, 1, 'O');
        game.getBoard().place(0, 2, 'X');

        assertFalse(game.hasWinner(), "Negative Test Failed: Mixed row should not trigger a win.");
    }

    @Test
    public void testStart_InitializesGame_Positive() {
        TicTacToe game = new TicTacToe();

        assertNotNull(game.getBoard(), "Positive Test Failed: Board should be accessible via getter.");
    }

    @Test
    public void testStart_GameOverFlag_Negative() {
        TicTacToe game = new TicTacToe();

        assertFalse(game.hasWinner(), "Negative Test Failed: A newly started game should not instantly have a winner.");
    }

    @Test
    public void testClear_Positive() {
        Board board = new Board();
        board.place(1, 1, 'O'); // Put a marker down

        board.clear();

        char[][] cells = board.getCells();
        assertEquals(' ', cells[1][1], "Positive Test Failed: clear() did not empty the cell.");
    }

    @Test
    public void testClear_Negative() {
        Board board = new Board();
        board.clear();

        assertFalse(board.isFull(), "Negative Test Failed: Clearing an empty board shouldn't break it or mark it full.");
    }

}
