package com.internousdev.amoti.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.amoti.dao.CartInfoDAO;
import com.internousdev.amoti.dao.MCategoryDAO;
import com.internousdev.amoti.dto.CartInfoDTO;
import com.internousdev.amoti.dto.MCategoryDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport implements SessionAware{
	private String categoryId;
	private String keywords;
	private Map<String, Object> session;
	public String execute(){
		List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>();
		String result = ERROR;
		String userId = null;
		CartInfoDAO dao = new CartInfoDAO();
		List<CartInfoDTO> dtoList = new ArrayList<CartInfoDTO>();
		session.remove("checkListErrorMessageList");
//ログインしてるか一時ログインか見分けます//
		if(session.containsKey("loginId")){
			userId = String.valueOf(session.get("loginId"));
		}else if(session.containsKey("tempUserId")){
			userId = String.valueOf(session.get("tempUserId"));
		}
		dtoList = dao.getCartInfoDtoList(userId);
		Iterator<CartInfoDTO> iterator = dtoList.iterator();
		if(!(iterator.hasNext())){
			dtoList = null;
		}
		session.put("cartInfoDtoList", dtoList);

		int totalPrice = Integer.parseInt(String.valueOf(dao.getTotalPrice(userId)));
		session.put("totalPrice", totalPrice);
		result = SUCCESS;

		if(!session.containsKey("mCategoryList")){
			MCategoryDAO mDao = new MCategoryDAO();
			mCategoryDtoList = mDao.getMCategoryList();
			session.put("mCategoryDtoList", mCategoryDtoList);
		}

		if(dtoList != null){
			session.put("checkListErrorMessageList", null);
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
	public Map<String, Object> getSession() {
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
