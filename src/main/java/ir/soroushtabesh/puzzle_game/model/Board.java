package ir.soroushtabesh.puzzle_game.model;

import java.util.List;

public class Board {
    private final List<PuzzlePiece> puzzlePieces;

    public Board(List<PuzzlePiece> puzzlePieces) {
        this.puzzlePieces = puzzlePieces;
    }

    public List<PuzzlePiece> getPuzzlePieces() {
        return puzzlePieces;
    }

    public int getMissingPiece() {
        for (PuzzlePiece puzzlePiece : puzzlePieces) {
            if (puzzlePiece.getPieceNumber() == Config.MISSING_PIECE_NUMBER)
                return puzzlePiece.getPieceLocation();
        }
        return -1;
    }

    public PuzzlePiece getPiece(int location) {
        for (PuzzlePiece puzzlePiece : puzzlePieces) {
            if (puzzlePiece.getPieceLocation() == location)
                return puzzlePiece;
        }
        return null;
    }

    public void swapPieces(int i, int j) {
        PuzzlePiece pi = getPiece(i);
        PuzzlePiece pj = getPiece(j);
        int loc_i = pi.getPieceLocation();
        int loc_j = pj.getPieceLocation();
        pi.setPieceLocation(loc_j);
        pj.setPieceLocation(loc_i);
    }

    public boolean checkGameFinished() {
        boolean res = true;
        for (PuzzlePiece piece : puzzlePieces) {
            if (piece.getPieceNumber() != Config.MISSING_PIECE_NUMBER)
                res &= piece.getPieceLocation() + 1 == piece.getPieceNumber();
        }
        return res;
    }
}
