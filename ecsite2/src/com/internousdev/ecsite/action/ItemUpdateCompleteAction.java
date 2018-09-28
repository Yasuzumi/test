package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemUpdateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemUpdateCompleteAction extends ActionSupport implements SessionAware{
	public Map<String,Object> session;
	private ItemUpdateCompleteDAO dao = new ItemUpdateCompleteDAO();

	public String execute() throws SQLException{
		dao.updateItem(session.get("itemName").toString(),
				session.get("itemPrice").toString(),
				session.get("itemStock").toString(),
				session.get("id").toString());
		return SUCCESS;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
