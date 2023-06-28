import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Fire implements KeyListener {
    private EnemyMap enemyMap;
    private Map mapPanel;

    public Fire(Map mapPanel, EnemyMap enemyMap) {
        this.mapPanel = mapPanel;
        this.enemyMap = enemyMap;
    }


    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
             if (key == KeyEvent.VK_SPACE) {
                int bulletRow = enemyMap.getRow();
                int bulletCol = enemyMap.getCol();

                int numObjects = mapPanel.getNumObjects();
                if (numObjects >= 5) {
                    enemyMap.shootCell(bulletRow, bulletCol);
                }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}

