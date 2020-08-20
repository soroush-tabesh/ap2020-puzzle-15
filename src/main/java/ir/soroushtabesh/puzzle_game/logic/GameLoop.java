package ir.soroushtabesh.puzzle_game.logic;

import ir.soroushtabesh.puzzle_game.model.GameState;

import java.util.Timer;
import java.util.TimerTask;

public class GameLoop {
    private final Timer timer = new Timer();
    private final KeyHandles listener = new KeyHandles();
    private boolean isLooping = false;

    public void startGameLoop() {
        if (isLooping)
            return;
        isLooping = true;
        attachListeners();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Game.getInstance().getGameFrame().repaint();
                checkFinished();
            }
        };
        timer.schedule(task, 0, 50);
    }

    private void checkFinished() {
        if (Game.getInstance().getGameState() == GameState.FINISHED) {
            Game.getInstance().getGameFrame().showGameOver();
            stopGameLoop();
        }
    }

    public void stopGameLoop() {
        if (!isLooping)
            return;
        detachListeners();
        timer.cancel();
        isLooping = false;
    }

    private void attachListeners() {
        Game.getInstance().getGameFrame().addKeyListener(listener);
    }

    private void detachListeners() {
        Game.getInstance().getGameFrame().removeKeyListener(listener);
    }

}
