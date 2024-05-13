package dao;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.account_bean;

public class account_dao {
	public int checkLogin(String un, String pw, int role_id) throws Exception {
		int id = 0;

		String enrpass = ecrypt(pw);
//		String enrpass = pw;

		// b1: Kết nối vào csdl
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		// b2: Tạo câu lệnh sql
		String sql = "select * from account where username=? and pass=? and role_id=?";
		// b3: Tạo câu lệnh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		// b4: Truyền tham số vào câu lệnh (nếu có) ...
		cmd.setString(1, un);
		cmd.setString(2, enrpass);
		cmd.setInt(3, role_id);
		
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

	// Mã hóa
	public static String ecrypt(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String enrtext;
		MessageDigest msd = MessageDigest.getInstance("MD5");

		byte[] srctextbyte = text.getBytes("UTF-8");
		byte[] enrtextbyte = msd.digest(srctextbyte);

		BigInteger big = new BigInteger(1, enrtextbyte);
		enrtext = big.toString(16);

		return enrtext;
	}

	public account_bean getAccount(String un, int roleId) throws Exception {
		account_bean g = null;

		// b1: Kết nối vào csdl
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		// b2: Tạo câu lệnh sql
		String sql = "select * from account where username=? and role_id=?";
		// b3: Tạo câu lệnh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		// b4: Truyền tham số vào câu lệnh (nếu có) ...
		cmd.setString(1, un);
		cmd.setInt(2, roleId);
		// b5: Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();
		// b6: Duyệt rs
		if (rs.next()) {
			int account_id = rs.getInt("account_id");
			int role_id = rs.getInt("role_id");
			int user_id = rs.getInt("user_id");

			String username = rs.getString("username");
			String pass = rs.getString("pass");

			g = new account_bean(account_id, role_id, user_id, username, pass);
		}

		// b7: Đóng các đối tượng
		rs.close();
		kn.cn.close();

		return g;
	}

	public int addAccount(String username, String pass, int user_id) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();

		String enrpass = ecrypt(pass);

		String sql = "insert into account(username, pass, user_id, role_id) values(?,?,?,2)";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, username);
		cmd.setString(2, enrpass);
		cmd.setInt(3, user_id);

		int res = cmd.executeUpdate();

		kn.cn.close();

		return res;
	}

}
