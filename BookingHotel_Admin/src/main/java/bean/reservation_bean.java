package bean;

import java.util.Date;

public class reservation_bean {
	private int reservation_id, guest_id;
	private String payment_status;
	private Date booking_date;

	public reservation_bean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public reservation_bean(int reservation_id, String payment_status, int guest_id, Date booking_date) {
		super();
		this.reservation_id = reservation_id;
		this.payment_status = payment_status;
		this.guest_id = guest_id;
		this.booking_date = booking_date;
	}

	public int getReservation_id() {
		return reservation_id;
	}

	public void setReservation_id(int reservation_id) {
		this.reservation_id = reservation_id;
	}

	public String getPayment_status() {
		return payment_status;
	}

	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}

	public int getGuest_id() {
		return guest_id;
	}

	public void setGuest_id(int guest_id) {
		this.guest_id = guest_id;
	}

	public Date getBooking_date() {
		return booking_date;
	}

	public void setBooking_date(Date booking_date) {
		this.booking_date = booking_date;
	}

	@Override
	public String toString() {
		return "reservation_bean [reservation_id=" + reservation_id + ", guest_id=" + guest_id + ", payment_status="
				+ payment_status + ", booking_date=" + booking_date + "]";
	}

}
