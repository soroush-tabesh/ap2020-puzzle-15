package ir.soroushtabesh.puzzle_game.util;

import ir.soroushtabesh.puzzle_game.model.Board;

public class BoardFactory {
    public static final BoardFactory instance = new BoardFactory();

    private BoardFactory() {
    }

    public static BoardFactory getInstance() {
        return instance;
    }

    public Board generateBoard() {
        return new Board(PuzzlePieceFactory.getInstance().buildAll());
    }
}
