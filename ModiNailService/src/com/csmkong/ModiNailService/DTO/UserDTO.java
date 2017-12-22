package com.csmkong.ModiNailService.DTO;

public class UserDTO {
	private int sid;
	private String id;
	private int activate;
	
	public UserDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public UserDTO(int sid, String id, int activate) {
		this.sid = sid;
		this.id = id;
		this.activate = activate;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getActivate() {
		return activate;
	}

	public void setActivate(int activate) {
		this.activate = activate;
	}
	
}
