package ir.soroushtabesh.puzzle_game.view;

import ir.soroushtabesh.puzzle_game.model.Board;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private Board board;

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        getBoard().getPuzzlePieces().forEach((pce) -> pce.getPieceView().draw(g));
    }

}