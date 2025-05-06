import java.util.List;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;
import java.io.IOException;

public class ChessGame {
    private GameManager gameManager;
    private Scanner scanner;
    
    public ChessGame() {
        gameManager = new GameManager();
        scanner = new Scanner(System.in, StandardCharsets.UTF_8.name());
    }
    
    public void start() {
        boolean quit = false;
        
        // 显示欢迎信息
        System.out.println("欢迎来到黑白棋游戏系统！");
        System.out.println("默认进入游戏1 (peace模式)");
        System.out.println("按回车键继续...");
        scanner.nextLine();
        
        while (!quit) {
            clearScreen();
            displayGame();
            
            System.out.print("请输入命令：");
            String input = scanner.nextLine().trim();
            
            if (input.equalsIgnoreCase("quit")) {
                quit = true;
            } else if (input.matches("\\d+")) {  // 检查输入是否为数字
                // 直接通过数字切换游戏
                int gameId = Integer.parseInt(input);
                if (!gameManager.switchGame(gameId)) {
                    System.out.println("游戏编号不存在！");
                    waitForEnter();
                } else {
                    System.out.println("已切换到游戏" + gameId);
                    waitForEnter();
                }
            } else if (input.equalsIgnoreCase("peace") || input.equalsIgnoreCase("reversi") || input.equalsIgnoreCase("gomoku")) {
                // 添加新游戏到列表末尾
                gameManager.addNewGame(input);
                System.out.println("已添加并切换到新游戏: " + input);
                waitForEnter();
            } else if (input.equalsIgnoreCase("pass")) {
                if (gameManager.getCurrentGame() instanceof ReversiGame) {
                    if (!gameManager.pass()) {
                        System.out.println("当前有合法落子位置，无法执行pass！");
                        waitForEnter();
                    }
                } else {
                    System.out.println("当前游戏模式不支持pass操作！");
                    waitForEnter();
                }
            } else {
                // 解析落子坐标，例如：3D
                try {
                    if (input.length() >= 2) {
                        int row = Integer.parseInt(input.substring(0, 1)) - 1;
                        char colChar = Character.toUpperCase(input.charAt(1));
                        int col = colChar - 'A';
                        
                        if (!gameManager.placePiece(row, col)) {
                            System.out.println("无效的落子位置！");
                            waitForEnter();
                        }
                    } else {
                        System.out.println("命令格式错误！");
                        waitForEnter();
                    }
                } catch (Exception e) {
                    System.out.println("输入格式错误！请使用如 3D 的格式或其他有效命令。");
                    waitForEnter();
                }
            }
        }
        
        scanner.close();
    }
    
    private void displayGame() {
        Game currentGame = gameManager.getCurrentGame();
        if (currentGame == null) {
            System.out.println("没有可用的游戏！");
            return;
        }
        
        Board board = currentGame.getBoard();
        List<int[]> validMoves = currentGame.getValidMoves();
        
        // 构建标题行，在Reversi模式下显示得分
        String scoreInfo = "";
        if (currentGame instanceof ReversiGame) {
            ReversiGame reversiGame = (ReversiGame) currentGame;
            int blackScore = reversiGame.getScore(currentGame.getPlayer1());
            int whiteScore = reversiGame.getScore(currentGame.getPlayer2());
            scoreInfo = String.format("黑方得分: %d  白方得分: %d", blackScore, whiteScore);
        }
        
        // 获取所有游戏列表
        List<Game> allGames = gameManager.getAllGames();
        
        // 左侧显示棋盘
        System.out.println("  A B C D E F G H    游戏信息             游戏列表");
        System.out.println("  ---------------    ----------------    ----------------");
        
        for (int i = 0; i < Board.SIZE; i++) {
            System.out.print((i + 1) + " ");
            
            for (int j = 0; j < Board.SIZE; j++) {
                if (currentGame.getGameType().equals("reversi") && isValidMove(validMoves, i, j)) {
                    System.out.print("+ ");
                } else {
                    System.out.print(board.getPiece(i, j).getSymbol() + " ");
                }
            }
            
            // 中间显示游戏状态
            if (i == 0) {
                System.out.print("   游戏编号: " + currentGame.getGameId());
            } else if (i == 1) {
                System.out.print("   游戏类型: " + currentGame.getGameType());
            } else if (i == 2) {
                Player player1 = currentGame.getPlayer1();
                System.out.print("   " + player1.getName() + ": " + player1.getPiece().getSymbol());
                if (currentGame.getCurrentPlayer() == player1) {
                    System.out.print(" ←");
                }
            } else if (i == 3) {
                Player player2 = currentGame.getPlayer2();
                System.out.print("   " + player2.getName() + ": " + player2.getPiece().getSymbol());
                if (currentGame.getCurrentPlayer() == player2) {
                    System.out.print(" ←");
                }
            } else if (i == 4 && currentGame instanceof ReversiGame) {
                System.out.print("   " + scoreInfo);
            } else if (i == 4 && currentGame instanceof GomokuGame) {
                GomokuGame gomokuGame = (GomokuGame) currentGame;
                System.out.print("   当前轮数: " + gomokuGame.getMoveCount());
            }
            
            // 右侧显示游戏列表
            if (i == 0) {
                System.out.println("    游戏列表:");
            } else if (i < allGames.size() + 1) {
                Game game = allGames.get(i - 1);
                System.out.println("    " + game.getGameId() + ". " + game.getGameType());
            } else {
                System.out.println();
            }
        }
        
        // 显示游戏结束信息
        if (currentGame.isOver()) {
            System.out.println("\n游戏结束！");
            if (currentGame instanceof ReversiGame) {
                ReversiGame reversiGame = (ReversiGame) currentGame;
                Player winner = reversiGame.getWinner();
                if (winner != null) {
                    System.out.println(winner.getName() + " 获胜！");
                } else {
                    System.out.println("平局！");
                }
            } else if (currentGame instanceof GomokuGame) {
                GomokuGame gomokuGame = (GomokuGame) currentGame;
                Player winner = gomokuGame.getWinner();
                if (winner != null) {
                    System.out.println(winner.getName() + " 获胜！");
                } else {
                    System.out.println("平局！");
                }
            }
        }
        
        System.out.println("\n命令: [坐标] - 落子, 数字 - 切换游戏, peace/reversi/gomoku - 添加新游戏, pass - 跳过, quit - 退出");
    }
    
    private boolean isValidMove(List<int[]> validMoves, int row, int col) {
        for (int[] move : validMoves) {
            if (move[0] == row && move[1] == col) {
                return true;
            }
        }
        return false;
    }
    
    private void clearScreen() {
        try {
            // 根据操作系统选择不同的清屏命令
            String os = System.getProperty("os.name").toLowerCase();
            
            if (os.contains("windows")) {
                // Windows系统使用cls命令清屏
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Linux/Mac系统使用clear命令清屏
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException e) {
            // 如果清屏命令执行失败，退回到使用换行的方式
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }
    
    private void waitForEnter() {
        System.out.println("按回车键继续...");
        scanner.nextLine();
    }
    
    public static void main(String[] args) {
        ChessGame game = new ChessGame();
        game.start();
    }
} 