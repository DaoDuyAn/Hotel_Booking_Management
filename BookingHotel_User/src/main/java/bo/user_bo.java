package bo;

import java.util.Date;

import bean.user_bean;
import dao.user_dao;

public class user_bo {
	user_dao userdao = new user_dao();
	
	public user_bean getUser(int id) throws Exception {
		return userdao.getUser(id);
	}
	
	public int getUserID() throws Exception {
		return userdao.getUserID();
	}
	
	public int addUser(String name, Date dob, String phone_number, String email) throws Exception {
		return userdao.addUser(name, dob, phone_number, email);
	}
}
