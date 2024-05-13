package bo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import bean.booking_bean;

public class booking_bo {
	public ArrayList<booking_bean> ds = new ArrayList<booking_bean>();

	public Long getTotal(String checkin, String checkout, Long price, int numOfRooms) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date1 = sdf.parse(checkin);
			Date date2 = sdf.parse(checkout);

			long difference = Math.abs(date2.getTime() - date1.getTime());
			long diff = TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS) + 1;

			return (long) (diff * price * numOfRooms);
		} catch (Exception e) {

			e.printStackTrace();
			return (long) 0;
		}
	}

	public void addBooking(int roomTypeId, String checkin, String checkout, int numOfRooms, int guestCount,
			int paymentStatus, String roomTypeName, Long price) throws Exception {
		for (booking_bean bkItem : ds) {
			if (bkItem.getRoom_type_id() == roomTypeId) {
				int num = bkItem.getNum_of_rooms() + numOfRooms;
				bkItem.setNum_of_rooms(num);
				bkItem.setTotal(getTotal(checkin, checkout, bkItem.getPrice(), num));

				return;
			}
		}

		booking_bean bookingItem = new booking_bean(ds.size() + 1, roomTypeId, numOfRooms, guestCount, paymentStatus,
				roomTypeName, checkin, checkout, price, getTotal(checkin, checkout, price, numOfRooms));

		ds.add(bookingItem);

	}

	public void updateBooking(int bookingId, String checkin, String checkout, int numOfRooms, int guestCount,
			int paymentStatus) throws Exception {

		for (booking_bean bkItem : ds) {
			if (bkItem.getBooking_id() == bookingId) {

				bkItem.setCheckin(checkin);
				bkItem.setCheckout(checkout);
				bkItem.setGuest_count(guestCount);
				bkItem.setNum_of_rooms(numOfRooms);
				bkItem.setPayment_status(paymentStatus);
				bkItem.setTotal(getTotal(checkin, checkout, bkItem.getPrice(), numOfRooms));

				return;
			}
		}
	}

	public void deleteBooking(int bookingId) throws Exception {
		for (booking_bean bkItem : ds) {
			if (bkItem.getBooking_id() == bookingId) {
				ds.remove(bkItem);
				return;
			}
		}
	}

	public void deleteAll() {
		ds.clear();
	}

	public double getPrepayment() throws Exception {

		double s = 0;
		for (booking_bean bkItem : ds) {
			s += (bkItem.getTotal() * ((double) bkItem.getPayment_status() / 100.0));

		}

		return s;
	}

	public long getToTalPrice() throws Exception {

		long s = 0;
		for (booking_bean bkItem : ds) {
			s += bkItem.getTotal();
		}

		return s;
	}

	public boolean isEveryReservationFullyPaid(ArrayList<booking_bean> lst) {
		for (booking_bean bkItem : lst) {
			if (bkItem.getPayment_status() == 10) {
				return false;
			}
		}

		return true;
	}
}
