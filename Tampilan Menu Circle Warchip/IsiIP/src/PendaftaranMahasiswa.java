import javax.swing.*;
import java.awt.*;

public class PendaftaranMahasiswa extends JFrame {
    private JPanel panel;
    private JLabel labelNama;
    private JTextField textFieldNama;
    private JLabel labelNIM;
    private JTextField textFieldNIM;
    private JLabel labelJurusan;
    private JComboBox<String> comboBoxJurusan;
    private JButton buttonSubmit;

    public PendaftaranMahasiswa() {
        setTitle("Pendaftaran Mahasiswa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Membuat panel utama
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        panel.setPreferredSize(new Dimension(400, 200));

        // Membuat label "Nama"
        labelNama = new JLabel("Nama:");
        labelNama.setBounds(10, 10, 280, 25);
        panel.add(labelNama);

        // Membuat input field untuk nama
        textFieldNama = new JTextField();
        textFieldNama.setBounds(100, 10, 280, 25);
        panel.add(textFieldNama);

        // Membuat label "NIM"
        labelNIM = new JLabel("NIM:");
        labelNIM.setBounds(10, 40, 80, 25);
        panel.add(labelNIM);

        // Membuat input field untuk NIM
        textFieldNIM = new JTextField();
        textFieldNIM.setBounds(100, 40, 280, 25);
        panel.add(textFieldNIM);

        // Membuat label "Jurusan"
        labelJurusan = new JLabel("Jurusan:");
        labelJurusan.setBounds(10, 70, 80, 25);
        panel.add(labelJurusan);

        // Membuat combo box untuk jurusan
        String[] jurusan = {"Teknik Informatika", "Sistem Informasi", "Teknik Elektro", "Teknik Industri"};
        comboBoxJurusan = new JComboBox<>(jurusan);
        comboBoxJurusan.setBounds(100, 70, 280, 25);
        panel.add(comboBoxJurusan);

        // Membuat tombol submit
        buttonSubmit = new JButton("Submit");
        buttonSubmit.setBounds(150, 110, 100, 25);
        panel.add(buttonSubmit);

        setContentPane(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PendaftaranMahasiswa::new);
    }
}
