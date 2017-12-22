package com.csmkong.ModiNailService.DTO;

public class ItemDTO {
	private String brand;
	private String item_type;
	private int item_code;
	private String item_name;
	private String fileName;
	
	public ItemDTO() {
		// TODO Auto-generated constructor stub
	}


	public ItemDTO(String brand, String item_type, int item_code, String item_name, String fileName) {
		super();
		this.brand = brand;
		this.item_type = item_type;
		this.item_code = item_code;
		this.item_name = item_name;
		this.fileName = fileName;
	}



	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	
	public String getItem_type() {
		return item_type;
	}


	public void setItem_type(String item_type) {
		this.item_type = item_type;
	}


	public int getItem_code() {
		return item_code;
	}

	public void setItem_code(int item_code) {
		this.item_code = item_code;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
}
