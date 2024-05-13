package bean;

import java.util.Date;

public class booking_bean {
	private int booking_id, room_type_id, num_of_rooms, guest_count, payment_status;
	private String room_type_name, checkin, checkout;
	private Long price, total;

	public booking_bean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public booking_bean(int booking_id, int room_type_id, int num_of_rooms, int guest_count, int payment_status,
			String room_type_name, String checkin, String checkout, Long price, Long total) {
		super();
		this.booking_id = booking_id;
		this.room_type_id = room_type_id;
		this.num_of_rooms = num_of_rooms;
		this.guest_count = guest_count;
		this.payment_status = payment_status;
		this.room_type_name = room_type_name;
		this.checkin = checkin;
		this.checkout = checkout;
		this.price = price;
		this.total = total;
	}

	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public int getRoom_type_id() {
		return room_type_id;
	}

	public void setRoom_type_id(int room_type_id) {
		this.room_type_id = room_type_id;
	}

	public int getNum_of_rooms() {
		return num_of_rooms;
	}

	public void setNum_of_rooms(int num_of_rooms) {
		this.num_of_rooms = num_of_rooms;
	}

	public int getGuest_count() {
		return guest_count;
	}

	public void setGuest_count(int guest_count) {
		this.guest_count = guest_count;
	}

	public int getPayment_status() {
		return payment_status;
	}

	public void setPayment_status(int payment_status) {
		this.payment_status = payment_status;
	}

	public String getRoom_type_name() {
		return room_type_name;
	}

	public void setRoom_type_name(String room_type_name) {
		this.room_type_name = room_type_name;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public String getCheckin() {
		return checkin;
	}

	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}

	public String getCheckout() {
		return checkout;
	}

	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}

}
