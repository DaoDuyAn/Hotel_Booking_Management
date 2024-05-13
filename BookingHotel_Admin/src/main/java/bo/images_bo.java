package bo;

import java.util.ArrayList;

import bean.images_bean;
import dao.images_dao;

public class images_bo {
	images_dao imagesdao = new images_dao();
	ArrayList<images_bean> ds;

	public ArrayList<images_bean> getAllImages() throws Exception {
		ds = imagesdao.getAllImages();
		return ds;
	}

	public ArrayList<images_bean> getImagesByRtId(int id) throws Exception {
		return imagesdao.getImagesByRtId(id);
	}
	
	public images_bean getImagesById(int id) throws Exception {
		return imagesdao.getImagesById(id);
	}

	public int addImage(String img_link, int rt_id) throws Exception {
		return imagesdao.addImage(img_link, rt_id);
	}

	public int deleteImage(int img_id) throws Exception {
		return imagesdao.deleteImage(img_id);
	}

	public int updateImage(int img_id, String img_link) throws Exception {
		return imagesdao.updateImage(img_id, img_link);
	}
}
