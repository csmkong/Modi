package com.csmkong.ModiNailService.DTO;

public class UserInfoDTO {
	private String id;
	private String pw;
	private String name;
	private String email;
	private String phone1;
	private String phone2;
	private String phone3;
	
	public UserInfoDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public UserInfoDTO(String id, String pw, String name, String email, String phone1, String phone2, String phone3) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.phone3 = phone3;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getPhone3() {
		return phone3;
	}
	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}
}
