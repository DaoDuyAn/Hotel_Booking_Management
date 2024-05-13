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

	public ArrayList<images_bean> getImagesByRtId(int id) throws Exception {
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

	public images_bean getImagesById(int id) throws Exception {
		images_bean imgbean = null;

		// b1: Kết nối vào csdl
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		// b2: Tạo câu lệnh sql
		String sql = "select * from images where image_id=?";
		// b3: Tạo câu lệnh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		// b4: Truyền tham số vào câu lệnh (nếu có) ...
		cmd.setInt(1, id);
		// b5: Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();
		// b6: Duyệt rs
		if (rs.next()) {
			int image_id = rs.getInt("image_id");
			int room_type_id = rs.getInt("room_type_id");
			String image_link = rs.getString("image_link");
			imgbean = new images_bean(image_id, image_link, room_type_id);
		}

		// b7: Đóng các đối tượng
		rs.close();
		kn.cn.close();

		return imgbean;
	}

	public int addImage(String img_link, int rt_id) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();

		String sql = "insert into images(image_link, room_type_id) values(?,?)";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		cmd.setString(1, img_link);
		cmd.setInt(2, rt_id);

		int res = cmd.executeUpdate();

		kn.cn.close();

		return res;
	}

	public int deleteImage(int img_id) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();

		String sql = "DELETE FROM images\r\n" + "WHERE image_id = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		cmd.setInt(1, img_id);

		int res = cmd.executeUpdate();

		cmd.close();
		kn.cn.close();
		return res;
	}

	public int updateImage(int img_id, String img_link) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();

		String sql = "UPDATE images\r\n" + "SET image_link = ?\r\n" + "WHERE image_id = ?\r\n" + "";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		cmd.setString(1, img_link);
		cmd.setInt(2, img_id);

		int res = cmd.executeUpdate();

		cmd.close();
		kn.cn.close();
		return res;
	}
}
