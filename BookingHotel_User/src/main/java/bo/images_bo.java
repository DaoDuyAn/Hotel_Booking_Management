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
	
	public ArrayList<images_bean> getImagesById(int id) throws Exception {
		return imagesdao.getImagesById(id);
	}
}
