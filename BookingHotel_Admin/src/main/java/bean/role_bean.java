package bean;

public class role_bean {
	private int role_id;
	private String name, description;

	public role_bean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public role_bean(int role_id, String name, String description) {
		super();
		this.role_id = role_id;
		this.name = name;
		this.description = description;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "role_bean [role_id=" + role_id + ", name=" + name + ", description=" + description + "]";
	}

}
