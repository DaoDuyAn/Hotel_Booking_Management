package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import bean.reserved_room_bean;



public class reserved_room_dao {
	public ArrayList<reserved_room_bean> getAllReservedRoom() throws Exception {
		ArrayList<reserved_room_bean> ds = new ArrayList<reserved_room_bean>();

		// b1: Kết nối vào csdl
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		// b2: Tạo câu lệnh sql
		String sql = "select rd.*, DATEADD(DAY, 2, rd.check_in) AS ci, DATEADD(DAY, 2, rd.check_out) AS co, rt.room_type_name, ((DATEDIFF(day, rd.check_out, rd.check_in) + 1) * rd.num_of_rooms * rd.price) as total\r\n"
				+ "from reserved_room as rd join room_type as rt on rd.room_type_id = rt.room_type_id";
		// b3: Tạo câu lệnh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		// b4: Truyền tham số vào câu lệnh (nếu có) ...
		// b5: Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();
		// b6: Duyệt rs
		while (rs.next()) {
			int reserved_room_id = rs.getInt("reserved_room_id");
			int reservation_id = rs.getInt("reservation_id");
			int room_type_id = rs.getInt("room_type_id");
			int num_of_rooms = rs.getInt("num_of_rooms");
			int guest_count = rs.getInt("guest_count");
			int payment_status = rs.getInt("payment_status");
			Long price = rs.getLong("price");
			Long total = rs.getLong("total");
			Date check_in = rs.getDate("ci");
			Date check_out = rs.getDate("co");
			String room_type_name = rs.getString("room_type_name");
			String status = rs.getString("status");
			ds.add(new reserved_room_bean(reserved_room_id, reservation_id, room_type_id, num_of_rooms, guest_count, payment_status, price, total, check_in, check_out, status, room_type_name));
		}

		// b7: Đóng các đối tượng
		rs.close();
		kn.cn.close();

		return ds;
	}
	
	public ArrayList<reserved_room_bean> getReservedRoomById(int id) throws Exception {
		ArrayList<reserved_room_bean> ds = new ArrayList<reserved_room_bean>();

		// b1: Kết nối vào csdl
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		// b2: Tạo câu lệnh sql
		String sql = "select rd.*, DATEADD(DAY, 2, rd.check_in) AS ci, DATEADD(DAY, 2, rd.check_out) AS co, rt.room_type_name, ((DATEDIFF(day, rd.check_out, rd.check_in) + 1) * rd.num_of_rooms * rd.price) as total\r\n"
				+ "from reserved_room as rd join room_type as rt on rd.room_type_id = rt.room_type_id\r\n"
				+ "where reservation_id = ?";
		// b3: Tạo câu lệnh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		// b4: Truyền tham số vào câu lệnh (nếu có) ...
		cmd.setInt(1, id);
		// b5: Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();
		// b6: Duyệt rs
		while (rs.next()) {
			int reserved_room_id = rs.getInt("reserved_room_id");
			int reservation_id = rs.getInt("reservation_id");
			int room_type_id = rs.getInt("room_type_id");
			int num_of_rooms = rs.getInt("num_of_rooms");
			int guest_count = rs.getInt("guest_count");
			int payment_status = rs.getInt("payment_status");
			Long price = rs.getLong("price");
			Long total = rs.getLong("total");
			Date check_in = rs.getDate("ci");
			Date check_out = rs.getDate("co");
			String room_type_name = rs.getString("room_type_name");
			String status = rs.getString("status");
			ds.add(new reserved_room_bean(reserved_room_id, reservation_id, room_type_id, num_of_rooms, guest_count, payment_status, price, total, check_in, check_out, status, room_type_name));
		}

		// b7: Đóng các đối tượng
		rs.close();
		kn.cn.close();

		return ds;
	}
	
	
	public reserved_room_bean getReservedRoomByRid(int id) throws Exception {
		reserved_room_bean rbean = null;

		// b1: Kết nối vào csdl
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		// b2: Tạo câu lệnh sql
		String sql = "select rd.*, DATEADD(DAY, 2, rd.check_in) AS ci, DATEADD(DAY, 2, rd.check_out) AS co, rt.room_type_name, ((DATEDIFF(day, rd.check_out, rd.check_in) + 1) * rd.num_of_rooms * rd.price) as total\r\n"
				+ "from reserved_room as rd join room_type as rt on rd.room_type_id = rt.room_type_id\r\n"
				+ "where reserved_room_id = ?";
		// b3: Tạo câu lệnh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		// b4: Truyền tham số vào câu lệnh (nếu có) ...
		cmd.setInt(1, id);
		// b5: Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();
		// b6: Duyệt rs
		if (rs.next()) {
			int reserved_room_id = rs.getInt("reserved_room_id");
			int reservation_id = rs.getInt("reservation_id");
			int room_type_id = rs.getInt("room_type_id");
			int num_of_rooms = rs.getInt("num_of_rooms");
			int guest_count = rs.getInt("guest_count");
			int payment_status = rs.getInt("payment_status");
			Long price = rs.getLong("price");
			Long total = rs.getLong("total");
			Date check_in =rs.getDate("ci");
			Date check_out = rs.getDate("co");
			String room_type_name = rs.getString("room_type_name");
			String status = rs.getString("status");
			rbean = new reserved_room_bean(reserved_room_id, reservation_id, room_type_id, num_of_rooms, guest_count, payment_status, price, total, check_in, check_out, status, room_type_name);
		}

		// b7: Đóng các đối tượng
		rs.close();
		kn.cn.close();

		return rbean;
	}
	
	public int addReservedRoom(int reservation_id, int room_type_id, int num_of_rooms, int guest_count, Long price,
			String checkin, String checkout, int payment_status) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();

		String sql = "insert into reserved_room(reservation_id, room_type_id, num_of_rooms, guest_count, price, check_in, check_out, payment_status, status) values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		cmd.setInt(1, reservation_id);
		cmd.setInt(2, room_type_id);
		cmd.setInt(3, num_of_rooms);
		cmd.setInt(4, guest_count);
		cmd.setLong(5, price);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = sdf.parse(checkin);
		Date d2 = sdf.parse(checkout);
		
		cmd.setDate(6, new java.sql.Date(d1.getTime()));
		cmd.setDate(7, new java.sql.Date(d2.getTime()));

		cmd.setInt(8, payment_status);
		cmd.setString(9, "Pending approval"); // "Pending cancellation" 

		int res = cmd.executeUpdate();

		cmd.close();
		kn.cn.close();
		return res;
	}
	
	public int updateReservedRoom(int reserved_room_id, int reservation_id, int room_type_id, int num_of_rooms, int guest_count, Long price,
			Date checkin, Date checkout, int payment_status, String status) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();

		String sql = "UPDATE reserved_room\r\n"
				+ "SET\r\n"
				+ "  room_type_id = ?,\r\n"
				+ "  num_of_rooms = ?,\r\n"
				+ "  guest_count = ?,\r\n"
				+ "  price = ?,\r\n"
				+ "  check_in = ?,\r\n"
				+ "  check_out = ?,\r\n"
				+ "  payment_status = ?,\r\n"
				+ "  status = ?\r\n"
				+ "WHERE reserved_room_id = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		
		cmd.setInt(1, room_type_id);
		cmd.setInt(2, num_of_rooms);
		cmd.setInt(3, guest_count);
		cmd.setLong(4, price);
		cmd.setDate(5, new java.sql.Date(checkin.getTime()));
		cmd.setDate(6, new java.sql.Date(checkout.getTime()));
		cmd.setInt(7, payment_status);
		cmd.setString(8, status);
		cmd.setInt(9, reserved_room_id);
		
		int res = cmd.executeUpdate();

		cmd.close();
		kn.cn.close();
		return res;
	}
}
