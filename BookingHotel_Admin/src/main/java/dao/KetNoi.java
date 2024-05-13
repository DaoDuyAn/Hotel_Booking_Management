package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class KetNoi {
	public Connection cn;

	public void ketnoi() throws Exception {

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // Xác định HQTCSDL
		System.out.println("Da nap Driver");
		String st = "jdbc:sqlserver://LAPCN-DUYAN\\\\SQLEXPRESS:1433;databaseName=booking_hotel_db;user=sa; password=123";
		cn = DriverManager.getConnection(st);
		System.out.println("Da ket noi den csdl booking_hotel_db");

	}
}
