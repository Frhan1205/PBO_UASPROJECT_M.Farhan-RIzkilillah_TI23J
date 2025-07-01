import java.sql.*;

public class TampilView {
    public static void main(String[] args) {
        try (Connection conn = DBConnection.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM view_barang");

            while (rs.next()) {
                System.out.printf("%s | %s | %d | %d | %d\n",
                        rs.getString("kode"),
                        rs.getString("nama"),
                        rs.getInt("harga"),
                        rs.getInt("stok"),
                        rs.getInt("total_nilai")
                );
            }
        } catch (Exception e) {
            System.out.println("Gagal tampilkan data: " + e.getMessage());
        }
    }
}
