package bo;

import java.util.ArrayList;

import bean.room_bean;
import dao.room_dao;

public class room_bo {
	room_dao roomdao = new room_dao();
	ArrayList<room_bean> ds;

	public ArrayList<room_bean> getAllRoomAvail(int number_of_rooms, String check_in, String check_out,
			int room_type_id) throws Exception {
		ds = roomdao.getAllRoomAvail(number_of_rooms, check_in, check_out, room_type_id);
		return ds;
	}
	
	public ArrayList<room_bean> getAllRoomAvailUpdate(int number_of_rooms, String check_in, String check_out,
			int room_type_id, int reserved_room_id) throws Exception {
		return roomdao.getAllRoomAvailUpdate(number_of_rooms, check_in, check_out, room_type_id, reserved_room_id);
	}
	

	public int getCountRoomAvail(String check_in, String check_out, int room_type_id) throws Exception {
		return roomdao.getCountRoomAvail(check_in, check_out, room_type_id);
	}
	
	public int getCountRoomAvailUpdate(String check_in, String check_out, int room_type_id, int reserved_room_id) throws Exception {
		return roomdao.getCountRoomAvailUpdate(check_in, check_out, room_type_id, reserved_room_id);
	}

}
