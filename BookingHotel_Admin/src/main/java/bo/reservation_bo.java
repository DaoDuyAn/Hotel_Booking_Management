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
	
	public int addReservation(int user_id) throws Exception {
		return rdao.addReservation(user_id);
	}
	
	public int updatePaymentStatusById(int reservation_id, String paymentStatus) throws Exception {
		return rdao.updatePaymentStatusById(reservation_id, paymentStatus);
	}

	public int getMaxReservationId() throws Exception {
		return rdao.getMaxReservationId();
	}
	
	public String statistic_1() throws Exception {
		return rdao.statistic_1();
	}
}
