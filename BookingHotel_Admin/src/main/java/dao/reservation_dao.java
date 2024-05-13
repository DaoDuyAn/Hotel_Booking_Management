package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import bean.reservation_bean;

public class reservation_dao {

	public int addReservation(int user_id) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();

		String sql = "insert into reservation(payment_status, booking_date, user_id) values(?,?,?)";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		cmd.setString(1, "Unpaid");

		Date d1 = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dt = sdf.format(d1);
		Date d2 = sdf.parse(dt);
		cmd.setDate(2, new java.sql.Date(d2.getTime()));

		cmd.setInt(3, user_id);

		int res = cmd.executeUpdate();

		cmd.close();
		kn.cn.close();
		return res;
	}

	public int updatePaymentStatusById(int reservation_id, String paymentStatus) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();

		String sql = "UPDATE reservation\r\n" + "SET payment_status = ?\r\n" + "WHERE reservation_id = ?\r\n" + "";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		cmd.setString(1, paymentStatus);
		cmd.setInt(2, reservation_id);

		int res = cmd.executeUpdate();

		cmd.close();
		kn.cn.close();
		return res;
	}

	public int getMaxReservationId() throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();

		String sql = "select max(reservation_id) as reservation_id from reservation";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		ResultSet rs = cmd.executeQuery();

		int reservation_id = 0;
		if (rs.next()) {
			reservation_id = rs.getInt("reservation_id");
		}

		rs.close();
		cmd.close();
		kn.cn.close();
		return reservation_id;
	}

	public ArrayList<reservation_bean> getAllReservation() throws Exception {
		ArrayList<reservation_bean> ds = new ArrayList<reservation_bean>();

		// b1: Kết nối vào csdl
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		// b2: Tạo câu lệnh sql
		String sql = "select *, DATEADD(DAY, 2, booking_date) AS bd from reservation";
		// b3: Tạo câu lệnh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		// b4: Truyền tham số vào câu lệnh (nếu có) ...
		// b5: Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();
		// b6: Duyệt rs
		while (rs.next()) {
			int reservation_id = rs.getInt("reservation_id");
			int user_id = rs.getInt("user_id");
			String payment_status = rs.getString("payment_status");
			Date booking_date = rs.getDate("bd");
			ds.add(new reservation_bean(reservation_id, payment_status, user_id, booking_date));
		}

		// b7: Đóng các đối tượng
		rs.close();
		kn.cn.close();

		return ds;
	}

	public ArrayList<reservation_bean> getReservationById(int id) throws Exception {
		ArrayList<reservation_bean> ds = new ArrayList<reservation_bean>();

		// b1: Kết nối vào csdl
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		// b2: Tạo câu lệnh sql
		String sql = "select *, DATEADD(DAY, 2, booking_date) AS bd from reservation where user_id = ?";
		// b3: Tạo câu lệnh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		// b4: Truyền tham số vào câu lệnh (nếu có) ...
		cmd.setInt(1, id);
		// b5: Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();
		// b6: Duyệt rs
		while (rs.next()) {
			int reservation_id = rs.getInt("reservation_id");
			int user_id = rs.getInt("user_id");
			String payment_status = rs.getString("payment_status");
			Date booking_date = rs.getDate("bd");
			ds.add(new reservation_bean(reservation_id, payment_status, user_id, booking_date));
		}

		// b7: Đóng các đối tượng
		rs.close();
		kn.cn.close();

		return ds;
	}

	public String statistic_1() throws Exception {
		String s = "";
		// b1: Kết nối vào csdl
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		// b2: Tạo câu lệnh sql
		String sql = "SELECT u.user_id, u.name, COUNT(r.reservation_id) AS total\r\n" + "FROM dbo.[user] u\r\n"
				+ "JOIN reservation r ON u.user_id = r.user_id\r\n" + "GROUP BY u.user_id, u.name\r\n"
				+ "HAVING COUNT(r.reservation_id) = (\r\n" + "    SELECT MAX(rv_count)\r\n" + "    FROM (\r\n"
				+ "        SELECT rv.user_id, COUNT(reservation_id) AS rv_count\r\n" + "        FROM reservation rv\r\n"
				+ "        GROUP BY rv.user_id\r\n" + "    ) AS counts\r\n" + ")";
		// b3: Tạo câu lệnh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		// b4: Truyền tham số vào câu lệnh (nếu có) ...

		// b5: Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();
		// b6: Duyệt rs
		if (rs.next()) {
			s = rs.getString("user_id") + ";" + rs.getString("name") + ";" + rs.getString("total");
		}

		// b7: Đóng các đối tượng
		rs.close();
		kn.cn.close();

		return s;

	}
}
