package ir.soroushtabesh.puzzle_game.util;

import ir.soroushtabesh.puzzle_game.logic.Game;
import ir.soroushtabesh.puzzle_game.model.Config;
import ir.soroushtabesh.puzzle_game.model.Location;

import java.util.List;

public class Util {
    private Util() {
    }

    public static boolean solvable(List<Integer> piecesOrder) {
        int missingPiece = piecesOrder.indexOf(Config.MISSING_PIECE_NUMBER);
        if (missingPiece == -1)
            return false;
        int inversionCount = 0;
        for (int i = 0; i < piecesOrder.size(); i++) {
            for (int j = i + 1; j < piecesOrder.size(); j++) {
                if (piecesOrder.get(i) > piecesOrder.get(j)) {
                    inversionCount += 1;
                }
            }
        }
        int parity = inversionCount % 2;
        int distanceOfMissingPiece = (2 - (missingPiece % 3)) + (2 - (missingPiece / 3));
        parity ^= (distanceOfMissingPiece % 2);
        return parity == 0;
    }

    public static Location getLocationByIndex(int index, double width, double height) {
        return new Location((int) height / 3 * (index % 3),
                (int) width / 3 * (index / 3));
    }

    public static Location getLocationByIndex(int index) {
        return getLocationByIndex(index, Game.getInstance().getGamePanel().getWidth()
                , Game.getInstance().getGamePanel().getHeight());
    }
}
