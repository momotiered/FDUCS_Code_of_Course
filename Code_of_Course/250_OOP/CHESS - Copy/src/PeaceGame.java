import java.util.ArrayList;
import java.util.List;

public class PeaceGame extends Game {
    
    public PeaceGame(int gameId) {
        super(gameId, "peace");
        board.initPeaceBoard();
    }

    @Override
    public boolean placePiece(int row, int col) {
        // 在Peace模式下，只要位置是空的，就可以放置棋子
        if (!board.isInBoard(row, col)) {
            return false;
        }
        
        if (!board.isEmpty(row, col)) {
            return false;
        }
        
        board.setPiece(row, col, currentPlayer.getPiece());
        
        // 检查游戏是否结束
        if (isGameOver()) {
            gameOver = true;
        } else {
            // 切换玩家
            switchPlayer();
        }
        
        return true;
    }

    @Override
    public boolean isGameOver() {
        // Peace模式下，棋盘满了就结束
        return board.isFull();
    }

    @Override
    public List<int[]> getValidMoves() {
        // Peace模式下，所有空位都是合法的落子位置
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
} 