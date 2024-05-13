package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import bean.room_bean;

public class room_dao {
	public int getCountRoomAvail(String check_in, String check_out, int room_type_id) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		
		String sql = "SELECT COUNT(DISTINCT r.room_id) AS count_available_rooms\r\n"
				+ "FROM room r\r\n"
				+ "WHERE NOT EXISTS\r\n"
				+ "(\r\n"
				+ "    SELECT 1 FROM occupied_room b\r\n"
				+ "    WHERE b.room_id = r.room_id\r\n"
				+ "    AND \r\n"
				+ "    (\r\n"
				+ "         ? > b.check_in AND ? < b.check_out OR\r\n"
				+ "         ? > b.check_in AND ? < b.check_out OR\r\n"
				+ "         (b.check_in >= ? AND b.check_out <= ?)\r\n"
				+ "    ) \r\n"
				+ ") \r\n"
				+ "AND r.room_type_id = ?\r\n"
				+ "";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = sdf.parse(check_in);
		Date d2 = sdf.parse(check_out);

		cmd.setDate(1, new java.sql.Date(d1.getTime()));
		cmd.setDate(2, new java.sql.Date(d1.getTime()));


		cmd.setDate(3, new java.sql.Date(d2.getTime()));
		cmd.setDate(4, new java.sql.Date(d2.getTime()));
		
		cmd.setDate(5, new java.sql.Date(d1.getTime()));
		cmd.setDate(6, new java.sql.Date(d2.getTime()));
		
		cmd.setInt(7, room_type_id);

		ResultSet rs = cmd.executeQuery();

		int cnt = 0;
		if (rs.next()) {
			cnt = rs.getInt("count_available_rooms");
		}

		rs.close();
		cmd.close();
		kn.cn.close();
		return cnt;
	}
	
	
	public int getCountRoomAvailUpdate(String check_in, String check_out, int room_type_id, int reserved_room_id) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		System.out.println(check_in + " " + check_out+ " " + room_type_id + " " + reserved_room_id);

		String sql = "SELECT COUNT(DISTINCT r.room_id) AS count_available_rooms\r\n"
				+ "FROM room r\r\n"
				+ "WHERE NOT EXISTS (\r\n"
				+ "    SELECT 1 \r\n"
				+ "    FROM occupied_room b \r\n"
				+ "    JOIN reservation rv ON b.reservation_id = rv.reservation_id\r\n"
				+ "    JOIN reserved_room rd ON rv.reservation_id = rd.reservation_id\r\n"
				+ "    WHERE (\r\n"
				+ "        b.room_id = r.room_id\r\n"
				+ "        AND (\r\n"
				+ "            (? > b.check_in AND ? < b.check_out) OR\r\n"
				+ "            (? > b.check_in AND ? < b.check_out) OR\r\n"
				+ "            (b.check_in >= ? AND b.check_out <= ?)\r\n"
				+ "        )\r\n"
				+ "        AND rd.reserved_room_id <> ? \r\n"
				+ "    )\r\n"
				+ ")AND r.room_type_id = ?"
				+ "";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = sdf.parse(check_in);
		Date d2 = sdf.parse(check_out);

		cmd.setDate(1, new java.sql.Date(d1.getTime()));
		cmd.setDate(2, new java.sql.Date(d1.getTime()));


		cmd.setDate(3, new java.sql.Date(d2.getTime()));
		cmd.setDate(4, new java.sql.Date(d2.getTime()));
		
		cmd.setDate(5, new java.sql.Date(d1.getTime()));
		cmd.setDate(6, new java.sql.Date(d2.getTime()));
		
		cmd.setInt(7, reserved_room_id);
		cmd.setInt(8, room_type_id);
		
		ResultSet rs = cmd.executeQuery();

		int cnt = 0;
		if (rs.next()) {
			cnt = rs.getInt("count_available_rooms");
		}

		rs.close();
		cmd.close();
		kn.cn.close();
		return cnt;
	}

	public ArrayList<room_bean> getAllRoomAvail(int number_of_rooms, String check_in, String check_out,
			int room_type_id) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();

		ArrayList<room_bean> ds = new ArrayList<room_bean>();

		String sql = "SELECT TOP(?) r.room_id, r.room_type_id\r\n"
				+ "FROM room r\r\n"
				+ "WHERE NOT EXISTS\r\n"
				+ "(\r\n"
				+ "    SELECT 1 FROM occupied_room b\r\n"
				+ "    WHERE b.room_id = r.room_id\r\n"
				+ "    AND \r\n"
				+ "    (\r\n"
				+ "         ? > b.check_in AND ? < b.check_out OR\r\n"
				+ "         ? > b.check_in AND ? < b.check_out OR\r\n"
				+ "         (b.check_in >= ? AND b.check_out <= ?)\r\n"
				+ "    ) \r\n"
				+ ") and r.room_type_id = ?\r\n"
				+ "";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setInt(1, number_of_rooms);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = sdf.parse(check_in);
		Date d2 = sdf.parse(check_out);

		cmd.setDate(2, new java.sql.Date(d1.getTime()));
		cmd.setDate(3, new java.sql.Date(d1.getTime()));


		cmd.setDate(4, new java.sql.Date(d2.getTime()));
		cmd.setDate(5, new java.sql.Date(d2.getTime()));
		
		cmd.setDate(6, new java.sql.Date(d1.getTime()));
		cmd.setDate(7, new java.sql.Date(d2.getTime()));
		
		cmd.setInt(8, room_type_id);

		ResultSet rs = cmd.executeQuery();

		while (rs.next()) {
			int roomId = rs.getInt("room_id");
			int roomTypeId = rs.getInt("room_type_id");

			ds.add(new room_bean(roomId, room_type_id));
		}

		rs.close();
		cmd.close();
		kn.cn.close();
		return ds;
	}
	
	public ArrayList<room_bean> getAllRoomAvailUpdate(int number_of_rooms, String check_in, String check_out,
			int room_type_id, int reserved_room_id) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();

		ArrayList<room_bean> ds = new ArrayList<room_bean>();

		String sql = "SELECT TOP(?) r.room_id, r.room_type_id\r\n"
				+ "FROM room r\r\n"
				+ "WHERE NOT EXISTS (\r\n"
				+ "    SELECT 1 \r\n"
				+ "    FROM occupied_room b \r\n"
				+ "    JOIN reservation rv ON b.reservation_id = rv.reservation_id\r\n"
				+ "    JOIN reserved_room rd ON rv.reservation_id = rd.reservation_id\r\n"
				+ "    WHERE (\r\n"
				+ "        b.room_id = r.room_id\r\n"
				+ "        AND (\r\n"
				+ "            (? > b.check_in AND ? < b.check_out) OR\r\n"
				+ "            (? > b.check_in AND ? < b.check_out) OR\r\n"
				+ "            (b.check_in >= ? AND b.check_out <= ?)\r\n"
				+ "        )\r\n"
				+ "        AND rd.reserved_room_id <> ?\r\n"
				+ "    )\r\n"
				+ ")AND r.room_type_id = ?";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setInt(1, number_of_rooms);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = sdf.parse(check_in);
		Date d2 = sdf.parse(check_out);

		cmd.setDate(2, new java.sql.Date(d1.getTime()));
		cmd.setDate(3, new java.sql.Date(d1.getTime()));


		cmd.setDate(4, new java.sql.Date(d2.getTime()));
		cmd.setDate(5, new java.sql.Date(d2.getTime()));
		
		cmd.setDate(6, new java.sql.Date(d1.getTime()));
		cmd.setDate(7, new java.sql.Date(d2.getTime()));

		cmd.setInt(8, reserved_room_id);
		cmd.setInt(9, room_type_id);

		ResultSet rs = cmd.executeQuery();

		while (rs.next()) {
			int roomId = rs.getInt("room_id");
			int roomTypeId = rs.getInt("room_type_id");

			ds.add(new room_bean(roomId, room_type_id));
		}

		rs.close();
		cmd.close();
		kn.cn.close();
		return ds;
	}
}
