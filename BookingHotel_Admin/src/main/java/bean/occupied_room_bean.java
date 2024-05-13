package bean;

import java.util.Date;

public class occupied_room_bean {
	private int occupied_room_id, room_id, reservation_id;
	private Date check_in, check_out;

	public occupied_room_bean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public occupied_room_bean(int occupied_room_id, int room_id, int reservation_id, Date check_in, Date check_out) {
		super();
		this.occupied_room_id = occupied_room_id;
		this.room_id = room_id;
		this.reservation_id = reservation_id;
		this.check_in = check_in;
		this.check_out = check_out;
	}

	public int getOccupied_room_id() {
		return occupied_room_id;
	}

	public void setOccupied_room_id(int occupied_room_id) {
		this.occupied_room_id = occupied_room_id;
	}

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public int getReservation_id() {
		return reservation_id;
	}

	public void setReservation_id(int reservation_id) {
		this.reservation_id = reservation_id;
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

	@Override
	public String toString() {
		return "occupied_room_bean [occupied_room_id=" + occupied_room_id + ", room_id=" + room_id + ", reservation_id="
				+ reservation_id + ", check_in=" + check_in + ", check_out=" + check_out + "]";
	}

}
