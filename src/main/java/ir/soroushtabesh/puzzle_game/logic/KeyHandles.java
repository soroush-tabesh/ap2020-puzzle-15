package ir.soroushtabesh.puzzle_game.logic;

import ir.soroushtabesh.puzzle_game.model.GameState;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyHandles extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        final Game game = Game.getInstance();
        if (game.getGameState() == GameState.FINISHED) {
            return;
        }
        int missingPieceIndex = game.getGamePanel().getBoard().getMissingPiece();
        if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {

            if (missingPieceIndex % 3 == 2) {
                return;
            }
            game.getGamePanel().getBoard().swapPieces(missingPieceIndex, missingPieceIndex + 1);
        } else if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
            if (missingPieceIndex % 3 == 0) {
                return;
            }
            game.getGamePanel().getBoard().swapPieces(missingPieceIndex, missingPieceIndex - 1);
        } else if (keyEvent.getKeyCode() == KeyEvent.VK_UP) {
            if (missingPieceIndex <= 2) {
                return;
            }
            game.getGamePanel().getBoard().swapPieces(missingPieceIndex, missingPieceIndex - 3);
        } else if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
            if (missingPieceIndex >= 6) {
                return;
            }
            game.getGamePanel().getBoard().swapPieces(missingPieceIndex, missingPieceIndex + 3);
        }
        if (game.getGamePanel().getBoard().checkGameFinished()) {
            game.setGameState(GameState.FINISHED);
        }
    }

}