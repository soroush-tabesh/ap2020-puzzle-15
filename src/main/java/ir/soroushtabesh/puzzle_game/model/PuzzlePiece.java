package ir.soroushtabesh.puzzle_game.model;

import ir.soroushtabesh.puzzle_game.view.Drawable;

public class PuzzlePiece {
    private int pieceNumber;
    private int pieceLocation;
    private Drawable pieceView;

    public PuzzlePiece() {
    }

    public Drawable getPieceView() {
        return pieceView;
    }

    public void setPieceView(Drawable pieceView) {
        this.pieceView = pieceView;
    }

    public int getPieceNumber() {
        return pieceNumber;
    }

    public void setPieceNumber(int pieceNumber) {
        this.pieceNumber = pieceNumber;
    }

    public int getPieceLocation() {
        return pieceLocation;
    }

    public void setPieceLocation(int pieceLocation) {
        this.pieceLocation = pieceLocation;
    }

    @Override
    public String toString() {
        return "PuzzlePiece{" +
                "pieceNumber=" + pieceNumber +
                ", pieceLocation=" + pieceLocation +
                ", pieceView=" + pieceView +
                "}\n";
    }
}