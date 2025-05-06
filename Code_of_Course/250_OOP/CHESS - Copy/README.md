# 黑白棋游戏系统

## 项目说明
这是一个支持多局游戏管理的黑白棋游戏系统，包含两种游戏模式：
1. **Peace模式**：基础的棋子放置游戏，无需遵循黑白棋规则
2. **Reversi模式**：完整的黑白棋游戏，遵循标准黑白棋规则

## 游戏功能
- 支持两种游戏模式
- 可以通过输入1或2直接切换游戏
- 默认启动进入游戏1 (peace模式)
- 允许退出程序（输入quit）

## 命令说明
- `[坐标]`：如 3D，表示在第3行D列落子
- `1`：切换到游戏1 (peace模式)
- `2`：切换到游戏2 (reversi模式)
- `pass`：在Reversi模式下，当没有合法落子位置时，跳过当前回合
- `quit`：退出游戏

## 编译与运行

### 编译
```
javac -encoding UTF-8 -d bin src/*.java
```

### 运行

Windows PowerShell:
```
$env:JAVA_TOOL_OPTIONS="-Dfile.encoding=UTF-8"; java -cp bin ChessGame
```

Windows CMD:
```
set JAVA_TOOL_OPTIONS=-Dfile.encoding=UTF-8
java -cp bin ChessGame
```

Linux/Mac系统:
```
export JAVA_TOOL_OPTIONS="-Dfile.encoding=UTF-8"
java -cp bin ChessGame
```

### 解决乱码问题
如果遇到中文乱码，请确保：
1. 使用`-encoding UTF-8`参数编译
2. 设置JAVA_TOOL_OPTIONS环境变量指定UTF-8编码
3. 确保控制台/终端支持UTF-8编码

## 项目结构
- `src/`：源代码目录
  - `Board.java`：棋盘类
  - `Piece.java`：棋子枚举类
  - `Player.java`：玩家类
  - `Game.java`：游戏抽象基类
  - `PeaceGame.java`：Peace模式游戏类
  - `ReversiGame.java`：Reversi模式游戏类
  - `GameManager.java`：游戏管理器类
  - `ChessGame.java`：主应用类，包含界面和用户交互
- `bin/`：编译后的类文件目录
- `README.md`：项目说明文件 