import java.util.ArrayList;
import java.util.List;

public class GomokuGame extends Game {
    private int moveCount;

    public GomokuGame(int gameId) {
        super(gameId, "Gomoku");
        this.moveCount = 0;
    }

    @Override
    public boolean placePiece(int row, int col) {
        if (row < 0 || row >= Board.SIZE || col < 0 || col >= Board.SIZE) {
            return false;
        }

        if (!board.isEmpty(row, col)) {
            return false;
        }

        board.setPiece(row, col, currentPlayer.getPiece());
        moveCount++;
        
        if (checkWin(row, col)) {
            gameOver = true;
            return true;
        }

        // 检查是否棋盘已满
        if (getValidMoves().isEmpty()) {
            gameOver = true;
            return true;
        }

        switchPlayer();
        return true;
    }

    @Override
    public boolean isGameOver() {
        return gameOver;
    }

    @Override
    public List<int[]> getValidMoves() {
        List<int[]> validMoves = new ArrayList<>();
        for (int i = 0; i < Board.SIZE; i++) {
            for (int j = 0; j < Board.SIZE; j++) {
                if (board.isEmpty(i, j)) {
                    validMoves.add(new int[]{i, j});
                }
            }
        }
        return validMoves;
    }

    private boolean checkWin(int row, int col) {
        Piece currentPiece = currentPlayer.getPiece();
        
        // 检查水平方向
        if (checkDirection(row, col, 0, 1, currentPiece) >= 5) return true;
        // 检查垂直方向
        if (checkDirection(row, col, 1, 0, currentPiece) >= 5) return true;
        // 检查主对角线方向
        if (checkDirection(row, col, 1, 1, currentPiece) >= 5) return true;
        // 检查副对角线方向
        if (checkDirection(row, col, 1, -1, currentPiece) >= 5) return true;
        
        return false;
    }

    private int checkDirection(int row, int col, int deltaRow, int deltaCol, Piece piece) {
        int count = 1;
        
        // 正向检查
        int r = row + deltaRow;
        int c = col + deltaCol;
        while (r >= 0 && r < Board.SIZE && c >= 0 && c < Board.SIZE && 
               board.getPiece(r, c) == piece) {
            count++;
            r += deltaRow;
            c += deltaCol;
        }
        
        // 反向检查
        r = row - deltaRow;
        c = col - deltaCol;
        while (r >= 0 && r < Board.SIZE && c >= 0 && c < Board.SIZE && 
               board.getPiece(r, c) == piece) {
            count++;
            r -= deltaRow;
            c -= deltaCol;
        }
        
        return count;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public Player getWinner() {
        if (!gameOver) {
            return null;
        }
        
        // 检查棋盘是否已满
        if (getValidMoves().isEmpty()) {
            return null; // 平局
        }
        
        // 如果游戏结束且棋盘未满，说明有玩家获胜
        return currentPlayer;
    }
} 