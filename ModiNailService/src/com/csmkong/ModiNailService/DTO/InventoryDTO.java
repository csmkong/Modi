package com.csmkong.ModiNailService.DTO;
import java.sql.Timestamp;

public class InventoryDTO {
	private int sid;
	private int itemCode;
	private Timestamp lastDate;
	
	public InventoryDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public InventoryDTO(int sid, int itemCode, Timestamp lastDate) {
		super();
		this.sid = sid;
		this.itemCode = itemCode;
		this.lastDate = lastDate;
	}


	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getItemCode() {
		return itemCode;
	}
	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
	}
	public Timestamp getLastDate() {
		return lastDate;
	}
	public void setLastDate(Timestamp lastDate) {
		this.lastDate = lastDate;
	}
	
	
}
