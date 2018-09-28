package com.internousdev.ecsite.dto;

import java.util.Date;

public class ItemListDTO {
	private int id;
	private String itemName;
	private int itemPrice;
	private int itemStock;
	private Date insertDate;
	private Date updateDate;

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

	public Date getInsertDate(){
		return insertDate;
	}
	public void setInsertDate(Date insertDate){
		this.insertDate = insertDate;
	}

	public Date getUpdateDate(){
		return updateDate;
	}
	public void setUpdateDate(Date updateDate){
		this.updateDate = updateDate;
	}
}
