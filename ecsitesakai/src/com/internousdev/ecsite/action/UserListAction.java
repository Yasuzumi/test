package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserListDAO;
import com.internousdev.ecsite.dto.UserListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;
	private ArrayList<UserListDTO> userList = new ArrayList<UserListDTO>();
	private UserListDAO userListDAO = new UserListDAO();

	public String execute() throws SQLException{
		userList = userListDAO.getUserListInfo();

		String result = SUCCESS;
		return result;
	}

	public Map<String, Object> getSession(){
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}

	public ArrayList<UserListDTO> getUserList(){
		return userList;
	}
	public void setUserList(ArrayList<UserListDTO> userList){
		this.userList = userList;
	}
}
