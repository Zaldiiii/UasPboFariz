import java.sql.Connection;

import static com.fariz.webappml.util.DBUtil.getConnection;



public static void main(String[] args) {
    try (Connection conn = getConnection()) {
        System.out.println("Koneksi berhasil!");
    } catch (Exception e) {
        System.out.println("Gagal koneksi: " + e.getMessage());
    }
}