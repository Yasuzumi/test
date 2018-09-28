package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemInfoDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemInfoAction extends ActionSupport implements SessionAware{
	private int id;
	private List<ItemInfoDTO> dto = new ArrayList<ItemInfoDTO>();
	private Map<String,Object> session;
	public String execute(){
		String result = SUCCESS;
		ItemInfoDAO Dao = new ItemInfoDAO();
		ItemInfoDTO Dto = new ItemInfoDTO();
		Dto = Dao.getItemInfo(id);
		session.put("id", Dto.getId());
		session.put("itemName", Dto.getItemName());
		session.put("itemPrice", Dto.getItemPrice());
		session.put("itemStock", Dto.getItemStock());
		session.put("insertDate", Dto.getInsertDate());
		session.put("updateDate", Dto.getUpdateDate());
		return result;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<ItemInfoDTO> getDto() {
		return dto;
	}
	public void setDto(List<ItemInfoDTO> dto) {
		this.dto = dto;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
