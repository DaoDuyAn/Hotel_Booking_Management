package dao;

import java.sql.PreparedStatement;


public class hosted_at_dao {
	public int addReservedRoom(int user_id, int occupied_room_id) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();

		String sql = "insert into hosted_at(user_id, occupied_room_id) values(?,?)";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		cmd.setInt(1, user_id);
		cmd.setInt(2, occupied_room_id);

		int res = cmd.executeUpdate();

		cmd.close();
		kn.cn.close();
		return res;
	}
}
