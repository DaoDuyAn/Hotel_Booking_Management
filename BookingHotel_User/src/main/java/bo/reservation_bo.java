package bo;

import java.util.ArrayList;

import bean.reservation_bean;
import dao.reservation_dao;

public class reservation_bo {
	reservation_dao rdao = new reservation_dao();
	ArrayList<reservation_bean> ds;
	
	public ArrayList<reservation_bean> getAllReservation() throws Exception {
		ds = rdao.getAllReservation();
		return ds;
	}
	
	public ArrayList<reservation_bean> getReservationById(int id) throws Exception {
		return rdao.getReservationById(id);
	}
	
	public int addReservation(int user_id, String status) throws Exception {
		return rdao.addReservation(user_id, status);
	}
	
	public int updateReservation(int reservation_id, String payment_status) throws Exception {
		return rdao.updateReservation(reservation_id, payment_status);
	}

	public int getMaxReservationId() throws Exception {
		return rdao.getMaxReservationId();
	}
}
