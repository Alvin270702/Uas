package uas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.Icon;

public class InController {

    public String InputController(String nama, String email, String password, String foto1, String kategori) {
        String query;
        try {
            DBHandler conn = new DBHandler();
            conn.connect();
            PreparedStatement stmt;
            query = "INSERT INTO dataPengguna(email,nama,pass,foto,Kategori) VALUES(?,?,?,?,?)";
            stmt = conn.con.prepareStatement(query);
            stmt.setString(1, email);
            stmt.setString(2, nama);
            stmt.setString(3, password);
            stmt.setString(4, foto1);
            stmt.setString(5, kategori);
            stmt.executeUpdate();
            return "Berhasil";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Gagal";
        }
    }
}
