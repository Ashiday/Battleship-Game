import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class MenungguPemain extends JFrame {
    private JPanel panel;

    public MenungguPemain() {
        setTitle("Frame Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Membuat panel utama
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        panel.setPreferredSize(new Dimension(1203, 500));

        // Memuat gambar latar belakang
        try {
            File imageFile = new File("1-12 1.png");
            BufferedImage backgroundImage = ImageIO.read(imageFile);
            JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
            backgroundLabel.setBounds(0, 0, backgroundImage.getWidth(), backgroundImage.getHeight());
            panel.add(backgroundLabel);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Membuat tombol menggunakan kelas ButtonExample
        ButtonExample buttonExample = new ButtonExample();
        JButton button1 = buttonExample.createButton();
        panel.add(button1);

        setContentPane(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MenungguPemain::new);
    }
}

class ButtonExample {
    public JButton createButton() {
        JButton button1 = new JButton("Menunggu Pemain Lain");
        button1.setBounds(308, 332, 587, 86);
        button1.setBorderPainted(false);
        button1.setBackground(new Color(255, 255, 255));
        Font font = new Font("Poppins", Font.BOLD, 32);
        button1.setFont(font);
        button1.setFocusPainted(false);
        return button1;
    }
}

