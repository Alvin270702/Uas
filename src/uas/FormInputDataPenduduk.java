package uas;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;

public class FormInputDataPenduduk {

    String jk = "";

    public FormInputDataPenduduk() {

        JFrame frame = new JFrame("Registrasi");
        frame.setSize(800, 1027);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font font1 = new Font("Serif", Font.PLAIN, 20);

        //label judul
        JLabel judul = new JLabel("Input ");
        judul.setBounds(330, 5, 500, 60);
        judul.setFont(new Font("Serif", Font.BOLD, 35));

        JLabel nikLabel = new JLabel("Email");
        nikLabel.setBounds(50, 75, 90, 40);
        nikLabel.setFont(font1);

        JTextField nik = new JTextField();
        nik.setBounds(240, 80, 310, 30);
        nik.setFont(font1);

        JLabel namaLabel = new JLabel("Nama");
        namaLabel.setBounds(50, 115, 90, 40);
        namaLabel.setFont(font1);

        JTextField nama = new JTextField();
        nama.setBounds(240, 120, 310, 30);
        nama.setFont(font1);

        JLabel fotoLabel = new JLabel("Foto");
        fotoLabel.setBounds(50, 730, 150, 40);
        fotoLabel.setFont(font1);

        JButton foto = new JButton("Open");
        foto.setBounds(240, 735, 70, 30);

        JLabel fotoPath = new JLabel("no file selected");
        fotoPath.setBounds(340, 730, 200, 30);
        fotoPath.setFont(font1);
        JLabel iconFoto = new JLabel();
        foto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                int r = j.showSaveDialog(null);
                if (r == JFileChooser.APPROVE_OPTION) {
                    File f = j.getSelectedFile();
                    BufferedImage bufferedImage = null;
                    fotoPath.setText(j.getSelectedFile().getAbsolutePath());
                    try {
                        bufferedImage = ImageIO.read(f);
                    } catch (IOException ex) {
                        Logger.getLogger(FormInputDataPenduduk.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Image fotoResize = bufferedImage.getScaledInstance(150, 170, Image.SCALE_DEFAULT);
                    ImageIcon foto = new ImageIcon(fotoResize);
                    iconFoto.setIcon(foto);
                }
            }
        });

        JButton insert = new JButton("Insert");
        insert.setBounds(600, 500, 100, 50);

        JButton update = new JButton("Update");
        update.setBounds(600, 500, 100, 50);
        update.setVisible(false);

        insert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                if ((nik.getText().isEmpty()
                        || nama.getText().isEmpty()
                        || foto == null)) {
                    JOptionPane.showMessageDialog(null, "Isi semua field!");
                } else {
//                    new HasilKTP(
//                            title.getText(),
//                            nik.getText(),
//                            nama.getText(),
//                            tempatLahir.getText(),
//                            ttl,
//                            jk,
//                            goldar,
//                            alamat.getText(),
//                            rtRw.getText(),
//                            kelurahan.getText(),
//                            kecamatan.getText(),
//                            (String) cbAgama.getItemAt(cbAgama.getSelectedIndex()),
//                            (String) cbStatusKawin.getItemAt(cbStatusKawin.getSelectedIndex()),
//                            pekerjaan,
//                            kewarganegaraan,
//                            berlakuHingga.getText(),
//                            iconFoto.getIcon(),
//                            iconTtd.getIcon(),
//                            kotaPembuatan.getText(),
//                            tglPembuatan
//                    );
                }
            }

        });
    }
}
