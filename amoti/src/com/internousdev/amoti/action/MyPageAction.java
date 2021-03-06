package com.internousdev.amoti.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.amoti.dao.UserInfoDAO;
import com.internousdev.amoti.dto.MCategoryDTO;
import com.internousdev.amoti.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware{

	private String categoryId;
	private String keywords;
	private List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>();

	private Map<String,Object> session;

	public String execute(){

		String result = ERROR;
		UserInfoDAO userInfoDAO = new UserInfoDAO();
		UserInfoDTO userInfoDTO = new UserInfoDTO();
		userInfoDTO = userInfoDAO.getUserInfo(String.valueOf(session.get("loginId")));

		if(userInfoDTO!=null){
			session.put("familyName", userInfoDTO.getFamilyName());
			session.put("firstName",userInfoDTO.getFirstName());
			session.put("familyNameKana", userInfoDTO.getFamilyNameKana());
			session.put("firstNameKana",userInfoDTO.getFirstNameKana());
			session.put("sex", userInfoDTO.getSex());
			session.put("email",userInfoDTO.getEmail());
			result = SUCCESS;
		}
		return result;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public List<MCategoryDTO> getmCategoryDtoList() {
		return mCategoryDtoList;
	}

	public void setmCategoryDtoList(List<MCategoryDTO> mCategoryDtoList) {
		this.mCategoryDtoList = mCategoryDtoList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}




}
