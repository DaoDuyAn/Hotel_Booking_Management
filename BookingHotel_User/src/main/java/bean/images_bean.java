package bean;

public class images_bean {
	private int image_id, room_type_id;
	private String image_link;

	public images_bean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public images_bean(int image_id, String image_link, int room_type_id) {
		super();
		this.image_id = image_id;
		this.room_type_id = room_type_id;
		this.image_link = image_link;
	}

	public int getImage_id() {
		return image_id;
	}

	public void setImage_id(int image_id) {
		this.image_id = image_id;
	}

	public String getImage_link() {
		return image_link;
	}

	public void setImage_link(String image_link) {
		this.image_link = image_link;
	}

	public int getRoom_type_id() {
		return room_type_id;
	}

	public void setRoom_type_id(int room_type_id) {
		this.room_type_id = room_type_id;
	}

	@Override
	public String toString() {
		return "images_bean [image_id=" + image_id + ", room_type_id=" + room_type_id + ", image_link=" + image_link
				+ "]";
	}

}
