package test;

import javax.swing.*;
import java.awt.*;
// import java.awt.event.KeyEvent;
// import java.awt.event.KeyListener;

public class Map extends JPanel {
    private static final int PANEL_WIDTH = 800;
    private static final int PANEL_HEIGHT = 600;
    private static final int CELL_SIZE = 40;

    private int[][] tankMap;

    private int playerRow;
    private int playerCol;

    public Map(int[][] tankMap) {
        this.tankMap = tankMap;
        this.playerRow = 0;
        this.playerCol = 0;
    }

    public int[][] getTankMap() {
        return tankMap;
    }

    public int getPlayerRow() {
        return playerRow;
    }

    public int getPlayerCol() {
        return playerCol;
    }

    public void movePlayer(int newRow, int newCol) {
        if (isValidMove(newRow, newCol)) {
            tankMap[playerRow][playerCol] = 0; // Hapus pemain dari posisi sebelumnya
            playerRow = newRow;
            playerCol = newCol;
            tankMap[playerRow][playerCol] = 1; // Tandai pemain di posisi baru
            repaint(); // Gambar ulang peta
        }
    }

    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < tankMap.length && col >= 0 && col < tankMap[row].length && tankMap[row][col] != 1;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int row = 0; row < tankMap.length; row++) {
            for (int col = 0; col < tankMap[row].length; col++) {
                if (tankMap[row][col] == 1) {
                    g.setColor(Color.BLACK);
                } else {
                    g.setColor(Color.WHITE);
                }
                int x = col * CELL_SIZE;
                int y = row * CELL_SIZE;
                g.fillRect(x, y, CELL_SIZE, CELL_SIZE);
                g.setColor(Color.BLACK);
                g.drawRect(x, y, CELL_SIZE, CELL_SIZE);
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(PANEL_WIDTH, PANEL_HEIGHT);
    }
}
