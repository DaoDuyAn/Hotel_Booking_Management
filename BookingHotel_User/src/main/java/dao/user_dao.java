package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import bean.user_bean;

public class user_dao {
	public user_bean getUser(int id) throws Exception {
		user_bean g = null;

		// b1: Kết nối vào csdl
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		// b2: Tạo câu lệnh sql
		String sql = "select * from dbo.[user] where user_id=?";
		// b3: Tạo câu lệnh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		// b4: Truyền tham số vào câu lệnh (nếu có) ...
		cmd.setInt(1, id);

		// b5: Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();

		// b6: Duyệt rs
		if (rs.next()) {
			int user_id = rs.getInt("user_id");
			String name = rs.getString("name");
			String phone_number = rs.getString("phone_number");
			String email = rs.getString("email");
			Date dob = rs.getDate("dob");

			g = new user_bean(user_id, name, phone_number, email, dob);
		}

		// b7: Đóng các đối tượng
		rs.close();
		kn.cn.close();

		return g;
	}
	
	public int getUserID() throws Exception {
		int id = 0;

		// b1: Kết nối vào csdl
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		// b2: Tạo câu lệnh sql
		String sql = "select top(1) * from dbo.[user] order by user_id desc";
		// b3: Tạo câu lệnh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		// b4: Truyền tham số vào câu lệnh (nếu có) ...

		// b5: Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();

		// b6: Duyệt rs
		if (rs.next()) {
			id = rs.getInt("user_id");
		}

		// b7: Đóng các đối tượng
		rs.close();
		kn.cn.close();

		return id;
	}

	public int addUser(String name, Date dob, String phone_number, String email) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();

		String sql = "insert into dbo.[user](name, dob, phone_number, email) values(?,?,?,?)";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, name);
		cmd.setDate(2, new java.sql.Date(dob.getTime()));
		cmd.setString(3, phone_number);
		cmd.setString(4, email);

		int res = cmd.executeUpdate();

		kn.cn.close();

		return res;
	}

//	public static void main(String[] args) {
//		try {
//			user_dao u = new user_dao();
//			user_bean ub = u.getUser(1);
//			if (ub == null) {
//				System.out.println("hah");
//			}
//			System.out.println("hah");
//			System.out.println(ub.getName());
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
}
