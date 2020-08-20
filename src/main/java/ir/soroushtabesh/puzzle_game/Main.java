package ir.soroushtabesh.puzzle_game;

import ir.soroushtabesh.puzzle_game.logic.Game;

public class Main {
    public static void main(String[] args) {
        Game game = Game.getInstance();
        game.init();
        game.startGame();
    }
}
