public class Board {
    public static final int SIZE = 8;
    private Piece[][] board;

    public Board() {
        board = new Piece[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = Piece.EMPTY;
            }
        }
    }

    public void initPeaceBoard() {
        // 初始化Peace模式棋盘，中间四格有棋子
        board[3][3] = Piece.WHITE;
        board[3][4] = Piece.BLACK;
        board[4][3] = Piece.BLACK;
        board[4][4] = Piece.WHITE;
    }

    public void initReversiBoard() {
        // 初始化Reversi模式棋盘，初始状态：黑棋位于4E和5D，白棋位于4D和5E
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = Piece.EMPTY;
            }
        }
        board[3][3] = Piece.WHITE; // 4D
        board[3][4] = Piece.BLACK; // 4E
        board[4][3] = Piece.BLACK; // 5D
        board[4][4] = Piece.WHITE; // 5E
    }

    public Piece getPiece(int row, int col) {
        return board[row][col];
    }

    public void setPiece(int row, int col, Piece piece) {
        board[row][col] = piece;
    }

    public boolean isInBoard(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE;
    }

    public boolean isEmpty(int row, int col) {
        return board[row][col] == Piece.EMPTY;
    }

    public int countPieces(Piece piece) {
        int count = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == piece) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == Piece.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
} 