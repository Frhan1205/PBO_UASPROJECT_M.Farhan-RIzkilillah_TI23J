import java.sql.*;
import java.util.Scanner;

public class InsertData {
    public static void main(String[] args) {
        try (Connection conn = DBConnection.getConnection()) {
            Scanner input = new Scanner(System.in);
            System.out.print("Kode: ");
            String kode = input.nextLine();
            System.out.print("Nama: ");
            String nama = input.nextLine();
            System.out.print("Harga: ");
            int harga = input.nextInt();
            System.out.print("Stok: ");
            int stok = input.nextInt();

            CallableStatement stmt = conn.prepareCall("{CALL insert_barang(?, ?, ?, ?)}");
            stmt.setString(1, kode);
            stmt.setString(2, nama);
            stmt.setInt(3, harga);
            stmt.setInt(4, stok);
            stmt.execute();

            System.out.println("Data berhasil diinsert.");
        } catch (Exception e) {
            System.out.println("Gagal insert data: " + e.getMessage());
        }
    }
}
