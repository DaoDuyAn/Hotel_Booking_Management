package bo;

import java.util.ArrayList;

import bean.room_type_bean;
import dao.room_type_dao;

public class room_type_bo {
	room_type_dao roomTypedao = new room_type_dao();
	ArrayList<room_type_bean> ds;

	public ArrayList<room_type_bean> getAllRoomType() throws Exception {
		ds = roomTypedao.getAllRoomType();
		return ds;
	}
	
	public ArrayList<room_type_bean> getTop5RoomType() throws Exception {
		return roomTypedao.getTop5RoomType();
	}
	
	public ArrayList<room_type_bean> getRoomTypeByKey(int rt_id, int val) throws Exception {
		return roomTypedao.getRoomTypeByKey(rt_id, val);
	}
	
	public room_type_bean getRoomTypeById(int id) throws Exception {
		return roomTypedao.getRoomTypeById(id);
	}
	
	public room_type_bean getRoomTypeByName(String name) throws Exception {
		return roomTypedao.getRoomTypeByName(name);
	}
	
	public int getCapacity(int id) throws Exception {
		return roomTypedao.getCapacity(id);
	}
	
	public int s() {
		return 88;
	}
}
