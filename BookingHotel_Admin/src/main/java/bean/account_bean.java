package bean;

public class account_bean {
	private int account_id, role_id, user_id;
	private String username, pass;

	public account_bean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public account_bean(int account_id, int role_id, int user_id, String username, String pass) {
		super();
		this.account_id = account_id;
		this.role_id = role_id;
		this.user_id = user_id;
		this.username = username;
		this.pass = pass;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "account_bean [account_id=" + account_id + ", role_id=" + role_id + ", user_id=" + user_id
				+ ", username=" + username + ", pass=" + pass + "]";
	}

}
