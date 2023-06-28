import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class IsiIP extends JFrame {
    private JPanel panel;
    private JTextField textField;
    private JLabel labelNama;

    public IsiIP() {
        setTitle("Isi IP");
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

        // Label Nama
        labelNama = new JLabel("Isi IP:");
        labelNama.setBounds(156, 332, 280, 25);
        Font font1 = new Font("Poppins", Font.BOLD, 32);
        labelNama.setFont(font1);
        panel.add(labelNama);

        // Membuat input field
        textField = new JTextField();
        textField.setBounds(259, 332, 319, 82);
        Font font = new Font("Poppins", Font.BOLD, 32);
        textField.setFont(font);
        panel.add(textField);

        setContentPane(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(IsiIP::new);
    }
}
