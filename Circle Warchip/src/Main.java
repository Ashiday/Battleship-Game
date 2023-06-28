import javax.swing.*;
import javax.swing.plaf.IconUIResource;
import java.awt.Color;

public class Main {
    public static void main(String[] args) {
        try {
            // Mengatur Look and Feel (LAF) default
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

            // Mengatur ikon peringatan kustom
            Icon customWarningIcon = new ImageIcon("lib\\img\\pngegg.png");
            UIManager.put("OptionPane.warningIcon", new IconUIResource(customWarningIcon));
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Circle Battleship");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Warna background frame
            frame.getContentPane().setBackground(Color.decode("#AFF3FF"));

            Map mapPanel = new Map();
            EnemyMap enemyPanel = new EnemyMap();
            mapPanel.setBounds(41, 26, 480, 320); // Mengatur posisi dan ukuran mapPanel
            enemyPanel.setBounds(641, 26, 480, 320); // Mengatur posisi dan ukuran enemyPanel
            frame.setLayout(null); // Mengatur layout frame menjadi null
            frame.add(mapPanel);
            frame.add(enemyPanel);

            Kontrol kontrol = new Kontrol(mapPanel, enemyPanel);
            frame.addKeyListener(kontrol);

            Fire fire = new Fire(mapPanel, enemyPanel);
            frame.addKeyListener(fire);

            frame.setFocusable(true);
            frame.requestFocus();

            frame.setSize(1200, 500);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
