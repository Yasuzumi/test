package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserInfoDAO;
import com.internousdev.ecsite.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserInfoAction extends ActionSupport implements SessionAware{
	private int id;
	private List<UserInfoDTO> dto = new ArrayList<UserInfoDTO>();
	private Map<String,Object> session;
	public String execute(){
		String result = SUCCESS;
		UserInfoDAO Dao = new UserInfoDAO();
		UserInfoDTO Dto = new UserInfoDTO();
		Dto = Dao.getUserInfo(id);
		session.put("id",Dto.getId());
		session.put("loginId",Dto.getLoginId());
		session.put("loginPass",Dto.getLoginPass());
		session.put("userName",Dto.getUserName());
		session.put("insertDate",Dto.getInsertDate());
		session.put("updatedDate",Dto.getUpdatedDate());
		return result;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<UserInfoDTO> getDto() {
		return dto;
	}
	public void setDto(List<UserInfoDTO> dto) {
		this.dto = dto;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
