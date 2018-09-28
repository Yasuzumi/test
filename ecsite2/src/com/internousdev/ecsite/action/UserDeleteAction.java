package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserDeleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserDeleteAction extends ActionSupport implements SessionAware{
	private String deleteFlg;
	private String message;
	public Map<String,Object> session;
	private UserDeleteDAO dao = new UserDeleteDAO();

	public String execute() throws SQLException{
		if(deleteFlg.equals("1")){
			delete();
		}
		String result = SUCCESS;
		return result;
	}

	public void delete() throws SQLException{
		String id = session.get("id").toString();
		int res = dao.userDelete(id);

		if(res > 0){
			setMessage("ユーザー情報を正しく削除しました。");
		}else if(res == 0){
			setMessage("ユーザー情報を正しく削除できませんでした。");
		}
	}

	public String getDeleteFlg() {
		return deleteFlg;
	}

	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public UserDeleteDAO getDao() {
		return dao;
	}

	public void setDao(UserDeleteDAO dao) {
		this.dao = dao;
	}

}
