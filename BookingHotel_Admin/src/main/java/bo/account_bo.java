package bo;

import bean.account_bean;
import dao.account_dao;

public class account_bo {
	account_dao accdao = new account_dao();
	
	public int checkLogin(String un, String pw, int roleId) throws Exception {
		return accdao.checkLogin(un, pw, roleId);
	}
	
	public account_bean getAccount(String un, int roleId) throws Exception {
		return accdao.getAccount(un, roleId);
	}
	
	public int addAccount(String username, String pass, int user_id) throws Exception {
		return accdao.addAccount(username, pass, user_id);
	}
}
