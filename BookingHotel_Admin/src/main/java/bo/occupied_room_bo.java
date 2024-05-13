package bo;

import java.util.ArrayList;

import bean.occupied_room_bean;
import dao.occupied_room_dao;

public class occupied_room_bo {
	occupied_room_dao ocdao = new occupied_room_dao();
	ArrayList<occupied_room_bean> ds = new ArrayList<occupied_room_bean>();
	
	public int addOccupiedRoom(int reservation_id, int room_id, String checkin, String checkout) throws Exception {
		return ocdao.addOccupiedRoom(reservation_id, room_id, checkin, checkout);
	}
	
	public int getMaxOccupiedRooomId() throws Exception {
		return ocdao.getMaxOccupiedRooomId();
	}
	
	public int deleteOccupiedRoom(int reservation_id, int room_type_id) throws Exception {
		return ocdao.deleteOccupiedRoom(reservation_id, room_type_id);
	}
}
