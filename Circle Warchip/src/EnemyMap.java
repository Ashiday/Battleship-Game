import javax.swing.*;
import java.awt.*;

public class EnemyMap extends JPanel {
    private static final int PANEL_WIDTH = 480;
    private static final int PANEL_HEIGHT = 320;
    private static final int CELL_SIZE = 40;

    public int enemyMap[][] = {
        
        //     1  2  3  4  5  6  7  8  9  10 11 12
        /*1*/ {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        /*2*/ {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        /*3*/ {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        /*4*/ {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        /*5*/ {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        /*6*/ {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        /*7*/ {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        /*8*/ {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    };

    private int Row= 0;
    private int Col = 0;


    public EnemyMap() {
    setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
    setLayout(null);
    // Mencari koordinat awal objek biru (nilai 0) di peta
    
    for (int row = 0; row < enemyMap.length; row++) {
        for (int col = 0; col < enemyMap[row].length; col++) {
            if (enemyMap[row][col] == 0) {
                Row = row;
                Col = col;
                return; // Keluar dari loop jika sudah ditemukan posisi awal objek biru
            }
        }
    }
    }
    public void moveenemyUp() {
        if (Row > 0 && enemyMap[Row - 1][Col] != 7) {
            Row--;
            repaint();
        }
    }

    public void moveenemyLeft() {
        if (Col > 0 && enemyMap[Row][Col - 1] != 7) {
            Col--;
            repaint();
        }
    }

    public void moveenemyDown() {
        if (Row < enemyMap.length - 1 && enemyMap[Row + 1][Col] != 7) {
            Row++;
            repaint();
        }
    }

    public void moveenemyRight() {
        if (Col < enemyMap[Row].length - 1 && enemyMap[Row][Col + 1] != 7) {
            Col++;
            repaint();
        }
    }
    
    public void shootCell(int row, int col) {
    if (row >= 0 && row < enemyMap.length && col >= 0 && col < enemyMap[0].length) {
        if (enemyMap[row][col] > 0) {
            enemyMap[row][col] = 3; // Menandai kapal terkena dengan nilai 2
        } else {
            enemyMap[row][col] = -1; // Menandai tembakan yang tidak mengenai kapal dengan nilai -1
        }
        repaint();
    }
}

    public int getRow() {
        return Row;
    }

    public int getCol() {
        return Col;
    }

    @Override
    protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    for (int row = 0; row < enemyMap.length; row++) {
        for (int col = 0; col < enemyMap[row].length; col++) {
            int cellValue = enemyMap[row][col];
            int x = col * CELL_SIZE;
            int y = row * CELL_SIZE;

            if (cellValue == 0) {
                g.setColor(Color.WHITE);
                g.fillRect(x, y, CELL_SIZE, CELL_SIZE);
                g.setColor(Color.BLACK);
                g.drawRect(x, y, CELL_SIZE, CELL_SIZE);
            } else if (cellValue == 1) {
                g.setColor(Color.WHITE);
                g.fillRect(x, y, CELL_SIZE, CELL_SIZE);
                g.setColor(Color.BLACK);
                g.drawRect(x, y, CELL_SIZE, CELL_SIZE);
            } else if (cellValue == -1) {
                g.setColor(Color.YELLOW);
                g.fillRect(x, y, CELL_SIZE, CELL_SIZE);
                g.setColor(Color.BLACK);
                g.drawRect(x, y, CELL_SIZE, CELL_SIZE);
            } else if (cellValue == 3) {
                g.setColor(Color.WHITE);
                g.fillRect(x, y, CELL_SIZE, CELL_SIZE);
                g.setColor(Color.BLACK);
                g.drawRect(x, y, CELL_SIZE, CELL_SIZE);

                ImageIcon redImageIcon = new ImageIcon("lib\\img\\Starburst-Explosion-PNG-Clipart-Background.png");
                Image redImage = redImageIcon.getImage();
                g.drawImage(redImage, x, y, CELL_SIZE, CELL_SIZE, null);
            }else if (cellValue == 7) {
                continue; // Skip drawing columns with value 7
            }
            
        }
    }

    int enemyX = Col * CELL_SIZE;
    int enemyY = Row * CELL_SIZE;
    ImageIcon blueImageIcon = new ImageIcon("lib/img/kisspng-computer-icons-target-corporation-symbol-illustrat-target-icon-5ab070b9baa139.5116457715215126337645.png");
    Image blueImage = blueImageIcon.getImage();
    g.drawImage(blueImage, enemyX, enemyY, CELL_SIZE, CELL_SIZE, null);
    // Membuat gambar objek biru transparan
    Graphics2D g2d = (Graphics2D) g.create();
    g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.0f)); // Opasitas 100%
    g2d.drawImage(blueImage, enemyX, enemyY, CELL_SIZE, CELL_SIZE, null);
    g2d.dispose();

    repaint();
}
}
