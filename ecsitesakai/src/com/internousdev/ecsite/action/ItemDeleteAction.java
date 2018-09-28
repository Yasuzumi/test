package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemDeleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemDeleteAction extends ActionSupport implements SessionAware{
	private String deleteFlg;
	public Map<String,Object> session;
	private String message;
	private ItemDeleteDAO dao = new ItemDeleteDAO();

	public String execute() throws SQLException{
		if(deleteFlg.equals("1")){
			delete();
		}
		String result = SUCCESS;
		return result;
	}

	public void delete() throws SQLException{

		String id = session.get("id").toString();
		int res = dao.ItemDelete(id);

		if(res > 0){
			setMessage("商品情報を正しく削除しました。");
		}else if(res == 0){
			setMessage("商品情報を削除できませんでした。");
		}
	}

	public String getDeleteFlg(){
		return deleteFlg;
	}
	public void setDeleteFlg(String deleteFlg){
		this.deleteFlg = deleteFlg;
	}

	public Map<String,Object> getSession(){
		return session;
	}
	@Override
	public void setSession(Map<String,Object> session){
		this.session = session;
	}

	public String getMessage(){
		return message;
	}
	public void setMessage(String message){
		this.message = message;
	}
}
