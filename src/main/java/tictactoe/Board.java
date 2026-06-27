package tictactoe;

public class Board {
    private final char[][] cells;

    public Board() {
        this.cells = new char[3][3];
        clear();
    }

    public boolean isCellEmpty(int x, int y) {
        if (x >= 0 && x < 3 && y >= 0 && y < 3) {
            return cells[x][y] == ' ';
        }
        return false;
    }

    public void place(int x, int y, char marker) {
        if (x >= 0 && x < 3 && y >= 0 && y < 3) {
            cells[x][y] = marker;
        }
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j] == ' ') return false;
            }
        }
        return true;
    }

    public void clear() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = ' ';
            }
        }
    }

    public void print() {
        System.out.println("▁▁▁▁▁▁");
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print(cells[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println("▔▔▔▔");
    }

    // helper getter for unit testing assertions
    char[][] getCells() {

        return cells;
    }
}