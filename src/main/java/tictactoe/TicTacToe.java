package tictactoe;


import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);
        boolean gameInProgress = true;

        System.out.println("Welcome to TicTacToe!");

        while (gameInProgress) {

            System.out.println("\nCurrent Player: " + currentPlayer.getMarker());
            board.print();

            System.out.print("row (0-2): ");
            int row = scanner.nextInt();
            System.out.print("column (0-2): ");
            int col = scanner.nextInt();

            if (board.isCellEmpty(row, col)) {
                board.place(row, col, currentPlayer.getMarker());

                if (hasWinner()) {
                    board.print();
                    System.out.println("Game Over! The winner is: " + currentPlayer.getMarker());
                    gameInProgress = false;
                } else if (board.isFull()) {
                    board.print();
                    System.out.println(" Game Over! It is a draw");
                    gameInProgress = false;
                } else {
                    switchCurrentPlayer();
                }
            } else {
                System.out.println("That cell is already taken! Try again.");
            }
        }

        System.out.print("Do you want to play again? (yes/no): ");
        String response = scanner.next();

        if (response.equalsIgnoreCase("yes")){
            board.clear();
            this.start();
        } else {
            System.out.println("Thank you for playing TiTacToe with us! Goodbye.");
            return;
        }
        scanner.close();
    }




    public void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public boolean hasWinner() {
        char m = currentPlayer.getMarker();
        char[][] cells = board.getCells();

//        rows
        for (int i = 0; i < 3; i++){
            if (cells[i][0] == m && cells[i][1] == m & cells[i][2] == m) return true;
        }

//        columns
        for (int i = 0; i < 3; i++){
            if (cells[0][i] == m && cells[1][i] == m & cells[2][i] == m) return true;
        }

//        diagonal
        if (cells[0][0] == m && cells[1][1] == m & cells[2][2] == m) return true;
        if (cells[0][2] == m && cells[1][1] == m & cells[2][0] == m) return true;


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