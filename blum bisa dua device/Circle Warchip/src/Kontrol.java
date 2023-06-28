import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Kontrol implements KeyListener {
    private Map mapPanel;
    private EnemyMap enemyMap;

    public Kontrol(Map mapPanel, EnemyMap enemyMap) {
        this.mapPanel = mapPanel;
        this.enemyMap = enemyMap;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (mapPanel.getNumObjects() < 5) {
            if (key == KeyEvent.VK_W) {
                mapPanel.moveshipUp();
            } else if (key == KeyEvent.VK_A) {
                mapPanel.moveshipLeft();
            } else if (key == KeyEvent.VK_S) {
                mapPanel.moveshipDown();
            } else if (key == KeyEvent.VK_D) {
                mapPanel.moveshipRight();
            } else if (key == KeyEvent.VK_ENTER) {
                int currentObject = 1;
                mapPanel.addObject(currentObject);
            }
        } else {
            if (enemyMap != null) {
                if (key == KeyEvent.VK_W) {
                    enemyMap.moveenemyUp();
                } else if (key == KeyEvent.VK_A) {
                    enemyMap.moveenemyLeft();
                } else if (key == KeyEvent.VK_S) {
                    enemyMap.moveenemyDown();
                } else if (key == KeyEvent.VK_D) {
                    enemyMap.moveenemyRight();
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
