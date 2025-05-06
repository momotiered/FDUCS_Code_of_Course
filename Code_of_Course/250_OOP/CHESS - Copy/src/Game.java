import java.util.ArrayList;
import java.util.List;

public abstract class Game {
    protected int gameId;
    protected String gameType;
    protected Board board;
    protected Player player1;
    protected Player player2;
    protected Player currentPlayer;
    protected boolean gameOver;

    public Game(int gameId, String gameType) {
        this.gameId = gameId;
        this.gameType = gameType;
        this.board = new Board();
        this.player1 = new Player("玩家1", Piece.BLACK);
        this.player2 = new Player("玩家2", Piece.WHITE);
        this.currentPlayer = player1; // 黑方先行
        this.gameOver = false;
    }

    public abstract boolean placePiece(int row, int col);
    
    public abstract boolean isGameOver();
    
    public abstract List<int[]> getValidMoves();

    public int getGameId() {
        return gameId;
    }

    public String getGameType() {
        return gameType;
    }

    public Board getBoard() {
        return board;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public boolean isOver() {
        return gameOver;
    }
    
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
    
    public Player getPlayer1() {
        return player1;
    }
    
    public Player getPlayer2() {
        return player2;
    }
} 