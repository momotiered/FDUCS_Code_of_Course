import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private List<Game> games;
    private int currentGameIndex;
    
    public GameManager() {
        games = new ArrayList<>();
        
        // 初始化三个游戏
        games.add(new PeaceGame(1)); // 游戏1: Peace模式
        games.add(new ReversiGame(2)); // 游戏2: Reversi模式
        games.add(new GomokuGame(3)); // 游戏3: Gomoku模式
        
        // 确保默认进入模式1
        currentGameIndex = 0;
    }
    
    public Game getCurrentGame() {
        if (games.isEmpty()) {
            return null;
        }
        return games.get(currentGameIndex);
    }
    
    public List<Game> getAllGames() {
        return games;
    }
    
    public boolean switchGame(int gameId) {
        // 根据游戏ID切换游戏
        for (int i = 0; i < games.size(); i++) {
            if (games.get(i).getGameId() == gameId) {
                currentGameIndex = i;
                return true;
            }
        }
        return false;
    }
    
    public boolean switchGame(String gameType) {
        // 通过游戏类型名称切换游戏
        if (gameType.equalsIgnoreCase("peace")) {
            currentGameIndex = 0;
            return true;
        } else if (gameType.equalsIgnoreCase("reversi")) {
            currentGameIndex = 1;
            return true;
        } else if (gameType.equalsIgnoreCase("gomoku")) {
            currentGameIndex = 2;
            return true;
        }
        return false;
    }
    
    public void addNewGame(String gameType) {
        // 创建新游戏并添加到游戏列表末尾
        int newGameId = games.size() + 1;
        if (gameType.equalsIgnoreCase("peace")) {
            games.add(new PeaceGame(newGameId));
        } else if (gameType.equalsIgnoreCase("reversi")) {
            games.add(new ReversiGame(newGameId));
        } else if (gameType.equalsIgnoreCase("gomoku")) {
            games.add(new GomokuGame(newGameId));
        }
        // 切换到新添加的游戏
        currentGameIndex = games.size() - 1;
    }
    
    public boolean placePiece(int row, int col) {
        Game currentGame = getCurrentGame();
        if (currentGame == null) {
            return false;
        }
        return currentGame.placePiece(row, col);
    }
    
    public boolean pass() {
        Game currentGame = getCurrentGame();
        if (currentGame == null || !(currentGame instanceof ReversiGame)) {
            return false;
        }
        return ((ReversiGame) currentGame).pass();
    }
} 