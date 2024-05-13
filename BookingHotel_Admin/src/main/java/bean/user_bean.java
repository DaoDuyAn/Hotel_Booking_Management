package bean;

import java.util.Date;

public class user_bean {
	private int user_id;
	private String name, phone_number, email;
	private Date dob;

	public user_bean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public user_bean(int user_id, String name, String phone_number, String email, Date dob) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.phone_number = phone_number;
		this.email = email;
		this.dob = dob;
	}


	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "user_bean [user_id=" + user_id + ", name=" + name + ", phone_number=" + phone_number + ", email="
				+ email + ", dob=" + dob + "]";
	}

}