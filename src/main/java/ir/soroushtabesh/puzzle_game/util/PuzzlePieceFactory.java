package ir.soroushtabesh.puzzle_game.util;

import ir.soroushtabesh.puzzle_game.model.Config;
import ir.soroushtabesh.puzzle_game.model.PuzzlePiece;
import ir.soroushtabesh.puzzle_game.view.PuzzlePieceView;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class PuzzlePieceFactory {
    private static final PuzzlePieceFactory instance = new PuzzlePieceFactory();

    private PuzzlePieceFactory() {
    }

    public static PuzzlePieceFactory getInstance() {
        return instance;
    }

    public PuzzlePiece buildPiece(int number) {
        Config config = ConfigLoader.getInstance().getCurrentConfig();
        PuzzlePiece puzzlePiece = null;
        try {
            InputStream stream = getClass().getClassLoader()
                    .getResourceAsStream("images/" + config.getImages().get(number));
            if (stream == null) {
                throw new RuntimeException("Config error: no such image");
            }
            Image img = ImageIO.read(stream);

            puzzlePiece = new PuzzlePiece();
            PuzzlePieceView pieceView = new PuzzlePieceView(img, puzzlePiece);

            puzzlePiece.setPieceView(pieceView);
            puzzlePiece.setPieceNumber(number);
            puzzlePiece.setPieceLocation(config.getPiecesOrder().indexOf(number));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return puzzlePiece;
    }

    public List<PuzzlePiece> buildAll() {
        List<PuzzlePiece> list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            list.add(buildPiece(i));
        }
        return list;
    }
}
