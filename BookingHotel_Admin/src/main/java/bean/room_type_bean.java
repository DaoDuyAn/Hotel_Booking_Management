package bean;

public class room_type_bean {
	private int room_type_id, capacity, size;
	private String description, room_type_name;
	private Long price;

	public room_type_bean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public room_type_bean(int room_type_id, int capacity, int size, String description, String room_type_name,
			Long price) {
		super();
		this.room_type_id = room_type_id;
		this.capacity = capacity;
		this.size = size;
		this.description = description;
		this.price = price;
		this.room_type_name = room_type_name;
	}

	public int getRoom_type_id() {
		return room_type_id;
	}

	public void setRoom_type_id(int room_type_id) {
		this.room_type_id = room_type_id;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getRoom_type_name() {
		return room_type_name;
	}

	public void setRoom_type_name(String room_type_name) {
		this.room_type_name = room_type_name;
	}

	@Override
	public String toString() {
		return "room_type_bean [room_type_id=" + room_type_id + ", capacity=" + capacity + ", size=" + size
				+ ", description=" + description + ", room_type_name=" + room_type_name + ", price=" + price + "]";
	}

}