package bean;

public class room_bean {
	private int room_id, room_type_id;

	public room_bean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public room_bean(int room_id, int room_type_id) {
		super();
		this.room_id = room_id;
		this.room_type_id = room_type_id;
	}

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public int getRoom_type_id() {
		return room_type_id;
	}

	public void setRoom_type_id(int room_type_id) {
		this.room_type_id = room_type_id;
	}

	@Override
	public String toString() {
		return "room_bean [room_id=" + room_id + ", room_type_id=" + room_type_id + "]";
	}

}
