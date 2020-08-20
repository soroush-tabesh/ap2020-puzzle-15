package ir.soroushtabesh.puzzle_game.logic;

import ir.soroushtabesh.puzzle_game.model.Board;
import ir.soroushtabesh.puzzle_game.model.Config;
import ir.soroushtabesh.puzzle_game.model.GameState;
import ir.soroushtabesh.puzzle_game.util.BoardFactory;
import ir.soroushtabesh.puzzle_game.util.ConfigLoader;
import ir.soroushtabesh.puzzle_game.util.Util;
import ir.soroushtabesh.puzzle_game.view.GameFrame;
import ir.soroushtabesh.puzzle_game.view.GamePanel;

public class Game {
    private static final Game instance = new Game();
    private final GamePanel gamePanel = new GamePanel();
    private final GameFrame gameFrame = new GameFrame();
    private final GameLoop gameLoop = new GameLoop();
    private GameState gameState = GameState.IDLE;
    private boolean initialized = false;

    private Game() {
    }

    public static Game getInstance() {
        return instance;
    }

    public void init() {
        if (initialized)
            return;
        initialized = true;
        getGameFrame().init();
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public GameFrame getGameFrame() {
        return gameFrame;
    }

    public GameLoop getGameLoop() {
        return gameLoop;
    }

    public void startGame() {
        if (!initialized)
            throw new IllegalStateException();
        Config config = ConfigLoader.getInstance().getCurrentConfig();
        Board board = BoardFactory.getInstance().generateBoard();
        getGamePanel().setBoard(board);
        if (Util.solvable(config.getPiecesOrder())) {
            getGameLoop().startGameLoop();
            setGameState(GameState.RUNNING);
            getGameFrame().setVisible(true);
        } else {
            getGameFrame().showUnsolvable();
        }
    }

    public void stopGame() {
        if (!initialized)
            throw new IllegalStateException();
        setGameState(GameState.FINISHED);
        getGameLoop().stopGameLoop();
    }
}
