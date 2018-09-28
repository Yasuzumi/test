package com.internousdev.amoti.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.amoti.dao.UserInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements SessionAware{
	private String categoryId;
	private Map<String, Object> session;
	public String execute() {
		String result = ERROR;

		UserInfoDAO userInfoDao = new UserInfoDAO();
		String loginId = String.valueOf(session.get("loginId"));
		boolean savedLoginIdFlg = Boolean.valueOf(String.valueOf(session.get("savedLoginIdFlg")));
		int count = userInfoDao.logout(loginId);
		session.clear();
		if(count > 0) {
			session.put("savedLoginIdFlg", savedLoginIdFlg);
			session.put("savedLoginId", loginId);
		}
		result = SUCCESS;
		return result;
	}

	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


}
