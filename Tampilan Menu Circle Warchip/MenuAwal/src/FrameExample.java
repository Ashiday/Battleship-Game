import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class FrameExample extends JFrame {
    private JPanel panel;

    public FrameExample() {
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

        ButtonExample2 buttonExample2 = new ButtonExample2();
        JButton button2 = buttonExample2.createButton2();
        panel.add(button2);

        setContentPane(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FrameExample::new);
    }
}

class ButtonExample {
    public JButton createButton() {
        JButton button1 = new JButton("Server");
        button1.setBounds(259, 332, 319, 82);
        button1.setBorderPainted(false);
        button1.setBackground(new Color(255, 255, 255));
        Font font = new Font("Poppins", Font.BOLD, 32);
        button1.setFont(font);
        button1.setFocusPainted(false);
        return button1;
    }
}

class ButtonExample2 {
    public JButton createButton2() {
        JButton button2 = new JButton("Client");
        button2.setBounds(631, 332, 319, 82);
        button2.setBorderPainted(false);
        button2.setBackground(new Color(255, 255, 255));
        Font font = new Font("Poppins", Font.BOLD, 32);
        button2.setFont(font);
        button2.setFocusPainted(false);
        return button2;
    }
}
