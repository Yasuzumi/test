package com.internousdev.ecsite.dto;

public class ItemInfoDTO {
	private int id;
	private String itemName;
	private int itemPrice;
	private int itemStock;
	private String insertDate;
	private String updateDate;

	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}

	public String getItemName(){
		return itemName;
	}
	public void setItemName(String itemName){
		this.itemName = itemName;
	}

	public int getItemPrice(){
		return itemPrice;
	}
	public void setItemPrice(int itemPrice){
		this.itemPrice = itemPrice;
	}

	public int getItemStock(){
		return itemStock;
	}
	public void setItemStock(int itemStock){
		this.itemStock = itemStock;
	}

	public String getInsertDate(){
		return insertDate;
	}
	public void setInsertDate(String insertDate){
		this.insertDate = insertDate;
	}

	public String getUpdateDate(){
		return updateDate;
	}
	public void setUpdateDate(String updateDate){
		this.updateDate = updateDate;
	}
}
