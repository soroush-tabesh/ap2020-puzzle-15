package ir.soroushtabesh.puzzle_game.view;

import ir.soroushtabesh.puzzle_game.logic.Game;
import ir.soroushtabesh.puzzle_game.model.Location;
import ir.soroushtabesh.puzzle_game.model.PuzzlePiece;
import ir.soroushtabesh.puzzle_game.util.Util;

import java.awt.*;

public class PuzzlePieceView implements Drawable {
    private final Image img;
    private final PuzzlePiece pieceModel;

    public PuzzlePieceView(Image img, PuzzlePiece pieceModel) {
        this.img = img;
        this.pieceModel = pieceModel;
    }

    @Override
    public void draw(Graphics g) {
        Location location = Util.getLocationByIndex(pieceModel.getPieceLocation());
        g.drawImage(img,
                location.getX(),
                location.getY(),
                (int) Game.getInstance().getGamePanel().getSize().getWidth() / 3,
                (int) Game.getInstance().getGamePanel().getSize().getHeight() / 3,
                null);
    }
}
