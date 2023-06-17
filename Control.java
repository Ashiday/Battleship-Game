package test;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Control implements KeyListener {
    private Map map;

    public Control(Map map) {
        this.map = map;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        int playerRow = map.getPlayerRow();
        int playerCol = map.getPlayerCol();

        if (key == KeyEvent.VK_UP) {
            map.movePlayer(playerRow - 1, playerCol);
        } else if (key == KeyEvent.VK_DOWN) {
            map.movePlayer(playerRow + 1, playerCol);
        } else if (key == KeyEvent.VK_LEFT) {
            map.movePlayer(playerRow, playerCol - 1);
        } else if (key == KeyEvent.VK_RIGHT) {
            map.movePlayer(playerRow, playerCol + 1);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Tidak digunakan
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Tidak digunakan
    }
}
