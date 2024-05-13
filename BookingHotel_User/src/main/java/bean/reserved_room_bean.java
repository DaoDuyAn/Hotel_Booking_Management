package bean;

import java.util.Date;

public class reserved_room_bean {
	private int reserved_room_id, reservation_id, room_type_id, num_of_rooms, guest_count, payment_status;
	private Long price, total;
	private Date check_in, check_out;
	private String status, room_type_name;

	public reserved_room_bean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public reserved_room_bean(int reserved_room_id, int reservation_id, int room_type_id, int num_of_rooms,
			int guest_count, int payment_status, Long price, Long total, Date check_in, Date check_out, String status,
			String room_type_name) {
		super();
		this.reserved_room_id = reserved_room_id;
		this.reservation_id = reservation_id;
		this.room_type_id = room_type_id;
		this.num_of_rooms = num_of_rooms;
		this.guest_count = guest_count;
		this.payment_status = payment_status;
		this.price = price;
		this.total = total;
		this.check_in = check_in;
		this.check_out = check_out;
		this.status = status;
		this.room_type_name = room_type_name;
	}

	public int getReserved_room_id() {
		return reserved_room_id;
	}

	public void setReserved_room_id(int reserved_room_id) {
		this.reserved_room_id = reserved_room_id;
	}

	public int getReservation_id() {
		return reservation_id;
	}

	public void setReservation_id(int reservation_id) {
		this.reservation_id = reservation_id;
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

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Date getCheck_in() {
		return check_in;
	}

	public void setCheck_in(Date check_in) {
		this.check_in = check_in;
	}

	public Date getCheck_out() {
		return check_out;
	}

	public void setCheck_out(Date check_out) {
		this.check_out = check_out;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public String getRoom_type_name() {
		return room_type_name;
	}

	public void setRoom_type_name(String room_type_name) {
		this.room_type_name = room_type_name;
	}

}
