package com.internousdev.ecsite.dto;

import java.util.Date;

public class UserListDTO {
	private int id;
	private String userId;
	private String userPass;
	private String userName;
	private Date insertDate;
	private Date updatedDate;

	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}

	public String getUserId(){
		return userId;
	}
	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getUserPass(){
		return userPass;
	}
	public void setUserPass(String userPass){
		this.userPass = userPass;
	}

	public String getUserName(){
		return userName;
	}
	public void setUserName(String userName){
		this.userName = userName;
	}

	public Date getInsertDate(){
		return insertDate;
	}
	public void setInsertDate(Date insertDate){
		this.insertDate = insertDate;
	}

	public Date getUpdatedDate(){
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate){
		this.updatedDate = updatedDate;
	}
}
