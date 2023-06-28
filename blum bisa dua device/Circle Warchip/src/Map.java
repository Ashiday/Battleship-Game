import javax.swing.*;
import java.awt.*;

public class Map extends JPanel {
    private static final int PANEL_WIDTH = 480;
    private static final int PANEL_HEIGHT = 320;
    private static final int CELL_SIZE = 40;

    private int shipMap[][] = {
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

    private int row = 0;
    private int col = 0;
    private int numObjects = 0;

    public Map() {
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setLayout(null);

        // Mencari koordinat awal objek biru (nilai 0) di peta
        for (int row = 0; row < shipMap.length; row++) {
            for (int col = 0; col < shipMap[row].length; col++) {
                if (shipMap[row][col] == 0) {
                    this.row = row;
                    this.col = col;
                    return; // Keluar dari loop jika sudah ditemukan posisi awal objek biru
                }
            }
        }
    }

    public void moveshipUp() {
        if (row > 0 && shipMap[row - 1][col] != 7) {
            row--;
            repaint();
        }
    }

    public void moveshipLeft() {
        if (col > 0 && shipMap[row][col - 1] != 7) {
            col--;
            repaint();
        }
    }

    public void moveshipDown() {
        if (row < shipMap.length - 1 && shipMap[row + 1][col] != 7) {
            row++;
            repaint();
        }
    }

    public void moveshipRight() {
        if (col < shipMap[row].length - 1 && shipMap[row][col + 1] != 7) {
            col++;
            repaint();
        }
    }

    public void addObject(int objectValue) {
        if (numObjects < 5) {
            if (shipMap[row][col] == 0) {
                shipMap[row][col] = objectValue;
                numObjects++;
            } else {
                JOptionPane.showMessageDialog(this, "Kapal sudah ada di sini.",
                    "LAPOR KOMANDAN", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public int getNumObjects() {
        return numObjects;
    }

    @Override
    protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    for (int row = 0; row < shipMap.length; row++) {
        for (int col = 0; col < shipMap[row].length; col++) {
            int cellValue = shipMap[row][col];
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

                ImageIcon greenImageIcon = new ImageIcon("lib/img/Desain_tanpa_judul__1_-removebg-preview.png");
                Image greenImage = greenImageIcon.getImage();
                g.drawImage(greenImage, x, y, CELL_SIZE, CELL_SIZE, null);
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

                ImageIcon redImageIcon = new ImageIcon("lib/img/Starburst-Explosion-PNG-Clipart-Background.png");
                Image redImage = redImageIcon.getImage();
                g.drawImage(redImage, x, y, CELL_SIZE, CELL_SIZE, null);
            } else if (cellValue == 7) {
                continue; // Skip drawing columns with value 7
            }
        }
    }
        int shipX = col * CELL_SIZE;
        int shipY = row * CELL_SIZE;
        ImageIcon blueImageIcon = new ImageIcon("lib/img/kisspng-computer-icons-target-corporation-symbol-illustrat-target-icon-5ab070b9baa139.5116457715215126337645.png");
        Image blueImage = blueImageIcon.getImage();
        g.drawImage(blueImage, shipX, shipY, CELL_SIZE, CELL_SIZE, null);
        // Membuat gambar objek biru transparan
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.0f)); // Opasitas 100%
        g2d.drawImage(blueImage, shipX, shipY, CELL_SIZE, CELL_SIZE, null);
        g2d.dispose();

        repaint();
    
}

}