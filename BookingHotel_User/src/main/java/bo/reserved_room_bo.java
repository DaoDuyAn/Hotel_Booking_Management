package bo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import bean.booking_bean;
import bean.reserved_room_bean;
import dao.reserved_room_dao;

public class reserved_room_bo {
	reserved_room_dao rdao = new reserved_room_dao();
	ArrayList<reserved_room_bean> ds;

	public ArrayList<reserved_room_bean> getAllReservedRoom() throws Exception {
		ds = rdao.getAllReservedRoom();
		return ds;
	}

	public ArrayList<reserved_room_bean> getReservedRoomById(int id) throws Exception {
		return rdao.getReservedRoomById(id);
	}

	public reserved_room_bean getReservedRoomByRid(int id) throws Exception {
		return rdao.getReservedRoomByRid(id);
	}

	public int addReservedRoom(int reservation_id, int room_type_id, int num_of_rooms, int guest_count, Long price,
			String checkin, String checkout, int payment_status) throws Exception {
		return rdao.addReservedRoom(reservation_id, room_type_id, num_of_rooms, guest_count, price, checkin, checkout,
				payment_status);
	}

	public Long getTotal(Date checkin, Date checkout, Long price, int numOfRooms) {
		try {

			long difference = Math.abs(checkout.getTime() - checkin.getTime());
			long diff = TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS) + 1;

			return (long) (diff * price * numOfRooms);
		} catch (Exception e) {

			e.printStackTrace();
			return (long) 0;
		}
	}

	public double getPrepayment(ArrayList<reserved_room_bean> ds) throws Exception {

		double s = 0;
		for (reserved_room_bean rdItem : ds) {
			s += (rdItem.getTotal() * ((double) rdItem.getPayment_status() / 100.0));
		}

		return s;
	}
	
	public double getPrepaymentItem(reserved_room_bean rbean) throws Exception {

		double s = (rbean.getTotal() * ((double) rbean.getPayment_status() / 100.0));
	
		return s;
	}

	public long getToTalPrice(ArrayList<reserved_room_bean> ds) throws Exception {

		long s = 0;
		for (reserved_room_bean rdItem : ds) {
			s += rdItem.getTotal();
		}

		return s;
	}

	public int updateReservedRoom(int reserved_room_id, int reservation_id, int room_type_id, int num_of_rooms,
			int guest_count, Long price, Date checkin, Date checkout, int payment_status, String status)
			throws Exception {
		return rdao.updateReservedRoom(reserved_room_id, reservation_id, room_type_id, num_of_rooms, guest_count, price,
				checkin, checkout, payment_status, status);
	}
}
