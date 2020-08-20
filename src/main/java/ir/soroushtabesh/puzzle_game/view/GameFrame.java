package ir.soroushtabesh.puzzle_game.view;

import ir.soroushtabesh.puzzle_game.logic.Game;
import ir.soroushtabesh.puzzle_game.util.Messages;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    public GameFrame() {
    }

    public void init() {
        initWindow();
        initContent();
    }

    private void initWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLocationByPlatform(true);
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        int maxSize = Math.max(screenWidth, screenHeight) / 3;
        setSize(maxSize, maxSize);
    }

    private void initContent() {
        Game.getInstance().getGamePanel().setSize(getWidth(), getHeight());
        setContentPane(Game.getInstance().getGamePanel());
    }

    public void showUnsolvable() {
        JOptionPane.showMessageDialog(this,
                Messages.UNSOLVABLE,
                Messages.UNSOLVABLE_TITLE,
                JOptionPane.WARNING_MESSAGE);
    }

    public void showGameOver() {
        JOptionPane.showMessageDialog(this,
                Messages.GAME_FINISHED,
                Messages.GAME_FINISHED_TITLE,
                JOptionPane.INFORMATION_MESSAGE);
    }

}
