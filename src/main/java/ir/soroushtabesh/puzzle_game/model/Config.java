package ir.soroushtabesh.puzzle_game.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Config implements Serializable {
    public static final int MISSING_PIECE_NUMBER = 0;
    private static final long serialVersionUID = 2598531692650881190L;
    private final List<String> images;
    private final List<Integer> piecesOrder;
    private String name;

    public Config() {
        images = new ArrayList<>();
        piecesOrder = new ArrayList<>();
    }

    public Config(List<String> images, List<Integer> piecesOrder) {
        this.images = images;
        this.piecesOrder = piecesOrder;
    }

    public List<String> getImages() {
        return images;
    }

    public List<Integer> getPiecesOrder() {
        return piecesOrder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
