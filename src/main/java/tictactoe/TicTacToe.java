package tictactoe;

public class TicTacToe {
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private final Board board;

    public TicTacToe() {
        this.player1 = new Player('X');
        this.player2 = new Player('O');
        this.currentPlayer = player1;
        this.board = new Board();
    }

    public void start() {
        System.out.println("Current Player: " + currentPlayer.getMarker());
        board.print();
    }

    public void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public boolean hasWinner() {
        // Will be fully implemented in US-03; defaults to false for US-01
        return false;
    }

    // Getters to assist unit testing
    public Board getBoard() { 
        return board; 
    }
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
}