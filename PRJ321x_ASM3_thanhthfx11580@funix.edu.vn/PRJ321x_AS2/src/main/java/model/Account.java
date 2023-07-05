package model;

public class Account {
	private String userMail;
	private String password;
	private int role;
	private String userName;
	private String address;
	private String phone;
	
	public Account() {
	}

	public Account(String userMail, String password, int role, String userName, String address, String phone) {
		this.userMail = userMail;
		this.password = password;
		this.role = role;
		this.userName = userName;
		this.address = address;
		this.phone = phone;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
