package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import bean.room_type_bean;

public class room_type_dao {
	public ArrayList<room_type_bean> getAllRoomType() throws Exception {
		ArrayList<room_type_bean> ds = new ArrayList<room_type_bean>();

		// b1: Kết nối vào csdl
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		// b2: Tạo câu lệnh sql
		String sql = "select * from room_type";
		// b3: Tạo câu lệnh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		// b4: Truyền tham số vào câu lệnh (nếu có) ...
		// b5: Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();

		// b6: Duyệt rs
		while (rs.next()) {
			int room_type_id = rs.getInt("room_type_id");
			int capacity = rs.getInt("capacity");
			int size = rs.getInt("size");
			String description = rs.getString("description");
			String room_type_name = rs.getString("room_type_name");
			Long price = rs.getLong("price");
			ds.add(new room_type_bean(room_type_id, capacity, size, description, room_type_name, price));
		}

		// b7: Đóng các đối tượng
		rs.close();
		kn.cn.close();

		return ds;
	}

	public ArrayList<room_type_bean> getTop5RoomType() throws Exception {
		ArrayList<room_type_bean> ds = new ArrayList<room_type_bean>();

		// b1: Kết nối vào csdl
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		// b2: Tạo câu lệnh sql
		String sql = "select TOP(5) * from room_type";
		// b3: Tạo câu lệnh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		// b4: Truyền tham số vào câu lệnh (nếu có) ...
		// b5: Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();

		// b6: Duyệt rs
		while (rs.next()) {
			int room_type_id = rs.getInt("room_type_id");
			int capacity = rs.getInt("capacity");
			int size = rs.getInt("size");
			String description = rs.getString("description");
			String room_type_name = rs.getString("room_type_name");
			Long price = rs.getLong("price");
			ds.add(new room_type_bean(room_type_id, capacity, size, description, room_type_name, price));
		}

		// b7: Đóng các đối tượng
		rs.close();
		kn.cn.close();

		return ds;
	}

	public room_type_bean getRoomTypeById(int id) throws Exception {
		room_type_bean rt = null;

		// b1: Kết nối vào csdl
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		// b2: Tạo câu lệnh sql
		String sql = "select * from room_type where room_type_id = ?";
		// b3: Tạo câu lệnh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		// b4: Truyền tham số vào câu lệnh (nếu có) ...
		cmd.setInt(1, id);
		// b5: Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();

		// b6: Duyệt rs
		if (rs.next()) {
			int room_type_id = rs.getInt("room_type_id");
			int capacity = rs.getInt("capacity");
			int size = rs.getInt("size");
			String description = rs.getString("description");
			String room_type_name = rs.getString("room_type_name");
			Long price = rs.getLong("price");
			rt = new room_type_bean(room_type_id, capacity, size, description, room_type_name, price);
		}

		// b7: Đóng các đối tượng
		rs.close();
		kn.cn.close();

		return rt;
	}

	public room_type_bean getRoomTypeByName(String name) throws Exception {
		room_type_bean rt = null;

		// b1: Kết nối vào csdl
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		// b2: Tạo câu lệnh sql
		String sql = "select * from room_type where room_type_name = ?";
		// b3: Tạo câu lệnh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		// b4: Truyền tham số vào câu lệnh (nếu có) ...
		cmd.setString(1, name);
		// b5: Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();

		// b6: Duyệt rs
		if (rs.next()) {
			int room_type_id = rs.getInt("room_type_id");
			int capacity = rs.getInt("capacity");
			int size = rs.getInt("size");
			String description = rs.getString("description");
			String room_type_name = rs.getString("room_type_name");
			Long price = rs.getLong("price");
			rt = new room_type_bean(room_type_id, capacity, size, description, room_type_name, price);
		}

		// b7: Đóng các đối tượng
		rs.close();
		kn.cn.close();

		return rt;
	}

	public ArrayList<room_type_bean> getRoomTypeByKey(int rt_id, int val) throws Exception {
		ArrayList<room_type_bean> ds = new ArrayList<room_type_bean>();

		// b1: Kết nối vào csdl
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		// b2: Tạo câu lệnh sql

		String sql = "";

		// b3: Tạo câu lệnh

		if (val == 0 && rt_id != 0) {
			sql = "select * from room_type where room_type_id = ?";
		}

		int mx = 0, mn = 0;
		if (val == 1) {
			mn = 1;
			mx = 2;
		} else if (val == 2) {
			mn = 3;
			mx = 4;
		} else {
			mn = 5;
			mx = 88;
		}

		if (rt_id == 0 && val != 0) {
			sql = "select * from room_type where capacity >= ? and capacity <= ?";
		}

		if (rt_id != 0 && val != 0) {
			sql = "select * from room_type where (room_type_id = ?) or (capacity >= ? and capacity <= ?)";
		}

		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		if (val == 0 && rt_id != 0) {
			cmd.setInt(1, rt_id);
		}

		if (rt_id == 0 && val != 0) {
			cmd.setInt(1, mn);
			cmd.setInt(2, mx);
		}

		if (rt_id != 0 && val != 0) {
			cmd.setInt(1, rt_id);
			cmd.setInt(2, mn);
			cmd.setInt(3, mx);
		}
		// b4: Truyền tham số vào câu lệnh (nếu có) ...
		// b5: Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();

		// b6: Duyệt rs
		while (rs.next()) {
			int room_type_id = rs.getInt("room_type_id");
			int capacity = rs.getInt("capacity");
			int size = rs.getInt("size");
			String description = rs.getString("description");
			String room_type_name = rs.getString("room_type_name");
			Long price = rs.getLong("price");
			ds.add(new room_type_bean(room_type_id, capacity, size, description, room_type_name, price));
		}

		// b7: Đóng các đối tượng
		rs.close();
		kn.cn.close();

		return ds;
	}

	public int getCapacity(int id) throws Exception {
		int capacity = 0;

		// b1: Kết nối vào csdl
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		// b2: Tạo câu lệnh sql
		String sql = "select capacity from room_type where room_type_id = ?";
		// b3: Tạo câu lệnh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		// b4: Truyền tham số vào câu lệnh (nếu có) ...
		cmd.setInt(1, id);
		// b5: Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();

		// b6: Duyệt rs
		if (rs.next()) {
			capacity = rs.getInt("capacity");
		}

		// b7: Đóng các đối tượng
		rs.close();
		kn.cn.close();

		return capacity;
	}

	public int addRoomType(String roomTypeName, int size, int capacity, Long price, String desc) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();

		String sql = "insert into room_type(room_type_name, description, size, capacity, price) values(?,?,?,?,?)";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		cmd.setString(1, roomTypeName);
		cmd.setString(2, desc);
		cmd.setInt(3, size);
		cmd.setInt(4, capacity);
		cmd.setLong(5, price);

		int res = cmd.executeUpdate();

		cmd.close();
		kn.cn.close();
		return res;
	}

	public int updateRoomType(int roomTypeID, String roomTypeName, int size, int capacity, Long price, String desc)
			throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();

		String sql = "UPDATE room_type\r\n" + "SET\r\n" + "  room_type_name = ?,\r\n" + "  description = ?,\r\n"
				+ "  size = ?,\r\n" + "  capacity = ?,\r\n" + "  price = ?\r\n" + "  WHERE room_type_id = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		cmd.setString(1, roomTypeName);
		cmd.setString(2, desc);
		cmd.setInt(3, size);
		cmd.setInt(4, capacity);
		cmd.setLong(5, price);
		cmd.setInt(6, roomTypeID);

		int res = cmd.executeUpdate();

		cmd.close();
		kn.cn.close();
		return res;
	}

	public int deleteRoomType(int roomTypeID) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();

		String sql = "DELETE FROM room_type WHERE room_type_id = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		cmd.setInt(1, roomTypeID);

		int res = cmd.executeUpdate();

		cmd.close();
		kn.cn.close();
		return res;
	}
}
