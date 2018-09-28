package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserUpdateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserUpdateCompleteAction extends ActionSupport implements SessionAware{
	public Map<String,Object> session;
	private UserUpdateCompleteDAO dao = new UserUpdateCompleteDAO();

	public String execute() throws SQLException{
		dao.updateUser(session.get("loginId").toString(),
				session.get("loginPass").toString(),
				session.get("userName").toString(),
				session.get("id").toString());
		String result = SUCCESS;
		return result;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
