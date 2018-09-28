package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class UserUpdateConfirmAction extends ActionSupport implements SessionAware{
	private String loginId;
	private String loginPass;
	private String userName;
	public Map<String,Object> session;
	private String errorMessage;

	public String execute(){
		String result = SUCCESS;

		if(!(loginId.equals(""))
		&& !(loginPass.equals(""))
		&& !(userName.equals(""))){
			session.put("loginId",loginId);
			session.put("loginPass",loginPass);
			session.put("userName",userName);
		}else{
			setErrorMessage("未入力の項目があります。");
		}
		return result;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getLoginPass() {
		return loginPass;
	}
	public void setLoginPass(String loginPass) {
		this.loginPass = loginPass;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
