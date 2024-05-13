package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class occupied_room_dao {
	public int addOccupiedRoom(int reservation_id, int room_id, String checkin, String checkout) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();

		String sql = "insert into occupied_room(reservation_id, room_id, check_in, check_out) values(?,?,?,?)";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		cmd.setInt(1, reservation_id);
		cmd.setInt(2, room_id);
		System.out.println(room_id);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = sdf.parse(checkin);
		Date d2 = sdf.parse(checkout);

		cmd.setDate(3, new java.sql.Date(d1.getTime()));
		cmd.setDate(4, new java.sql.Date(d2.getTime()));

		int res = cmd.executeUpdate();

		cmd.close();
		kn.cn.close();
		return res;
	}
	
	public int getMaxOccupiedRooomId() throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();

		String sql = "select max(occupied_room_id) as occupied_room_id from occupied_room";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		ResultSet rs = cmd.executeQuery();

		int occupied_room_id = 0;
		if (rs.next()) {
			occupied_room_id = rs.getInt("occupied_room_id");
		}

		rs.close();
		cmd.close();
		kn.cn.close();
		return occupied_room_id;
	}
	
	public int deleteOccupiedRoom(int reservation_id, int room_type_id) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		System.out.println("reservation_id: " + reservation_id + " room_type_id: " + room_type_id);
		String sql = "DELETE FROM occupied_room\r\n"
				+ "WHERE reservation_id = ?\r\n"
				+ "  AND room_id IN (SELECT room_id FROM room WHERE room_type_id = ?);\r\n"
				+ "";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		cmd.setInt(1, reservation_id);
		cmd.setInt(2, room_type_id);

		
		int res = cmd.executeUpdate();

		cmd.close();
		kn.cn.close();
		return res;
	}
}
