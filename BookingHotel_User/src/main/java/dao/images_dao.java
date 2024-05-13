package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.images_bean;

public class images_dao {
	public ArrayList<images_bean> getAllImages() throws Exception {
		ArrayList<images_bean> ds = new ArrayList<images_bean>();

		// b1: Kết nối vào csdl
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		// b2: Tạo câu lệnh sql
		String sql = "select * from images";
		// b3: Tạo câu lệnh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		// b4: Truyền tham số vào câu lệnh (nếu có) ...
		// b5: Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();
		// b6: Duyệt rs
		while (rs.next()) {
			int image_id = rs.getInt("image_id");
			int room_type_id = rs.getInt("room_type_id");
			String image_link = rs.getString("image_link");
			ds.add(new images_bean(image_id, image_link, room_type_id));
		}

		// b7: Đóng các đối tượng
		rs.close();
		kn.cn.close();

		return ds;
	}
	
	
	public ArrayList<images_bean> getImagesById(int id) throws Exception {
		ArrayList<images_bean> ds = new ArrayList<images_bean>();

		// b1: Kết nối vào csdl
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		// b2: Tạo câu lệnh sql
		String sql = "select * from images where room_type_id=?";
		// b3: Tạo câu lệnh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		// b4: Truyền tham số vào câu lệnh (nếu có) ...
		cmd.setInt(1, id);
		// b5: Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();
		// b6: Duyệt rs
		while (rs.next()) {
			int image_id = rs.getInt("image_id");
			int room_type_id = rs.getInt("room_type_id");
			String image_link = rs.getString("image_link");
			ds.add(new images_bean(image_id, image_link, room_type_id));
		}

		// b7: Đóng các đối tượng
		rs.close();
		kn.cn.close();

		return ds;
	}
}
