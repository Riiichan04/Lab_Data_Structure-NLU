package lab5;

public class TicTacToe {
    private static final char EMPTY = ' ';
    private char[][] board;

    public TicTacToe(char[][] board) {
        this.board = board;
    }
//    Task 2.4
//    Task 2.1
    public boolean checkRows() {
        for (char[] element : board) {
            int countX = 0;
            int countO = 0;
            for (int j = 0; j < element.length; j++) {
                switch (element[j]) {
                    case 'X': {
                        countX++;
                        break;
                    }
                    case 'O': {
                        countO++;
                        break;
                    }
                }
            }
            return countX == board.length || countO == board.length;
        }
        return false;
    }

//    Task 2.2
    public boolean checkCols() {
        for (int i = 0; i < board.length; i++) {
            int countX = 0;
            int countO = 0;
            for (int j = 0; j < board[i].length; j++) {
                switch (board[j][i]) {
                    case 'X': {
                        countX++;
                        break;
                    }
                    case 'O': {
                        countO++;
                        break;
                    }
                }
            }
            return countX == board.length || countO == board.length;
        }
        return false;
    }

    public boolean checkDiagonals() {
        return checkMainDig() || checkSubDig();
    }
    public boolean checkMainDig() {
        int countX = 0;
        int countO = 0;
        for (int i = 0; i < board.length; i++) {
            switch (board[i][i]) {
                case 'X': {
                    countX++;
                    break;
                }
                case 'O': {
                    countO++;
                    break;
                }
            }
        }
        return countX == board.length || countO == board.length;
    }

    public boolean checkSubDig() {
        int countX = 0;
        int countO = 0;
        for (int i = 0; i < board.length; i++) {
            switch (board[i][board.length - 1 - i]) {
                case 'X': {
                    countX++;
                    break;
                }
                case 'O': {
                    countO++;
                    break;
                }
            }
        }
        return countX == board.length || countO == board.length;
    }

    public static void main(String[] args) {
        char[][] board = {{'O', 'O', 'O', 'O'}, {' ', 'X', ' ', 'X'}, {'X', ' ', ' ', 'X'}, {' ', 'X', 'X', 'X'}};
        TicTacToe test = new TicTacToe(board);
        System.out.println(test.checkRows());
        System.out.println(test.checkCols());
        System.out.println(test.checkDiagonals());
    }
}
