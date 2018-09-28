package com.internousdev.amoti.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.amoti.dao.CartInfoDAO;
import com.internousdev.amoti.dto.CartInfoDTO;
import com.internousdev.amoti.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class AddCartAction extends ActionSupport implements SessionAware{

	private int productId;
	private String productName;
	private String productNameKana;
	private String imageFilePath;
	private String imageFileName;
	private int price;
	private String productCount;
	private String releaseCompany;
	private Date releaseDate;
	private String productDescription;
	private String categoryId;
	private Map<String, Object> session;

	public String execute(){
		String result = ERROR;
		String userId = null;
		String tempUserId = null;
		session.remove("checkListErrorMessageList");
//ログインしてなくて一時ログインもしてないときはランダムでid設定して一時ログインします//
		if(!(session.containsKey("loginId")) && !(session.containsKey("tempUserId"))){
			CommonUtility cu = new CommonUtility();
			session.put("tempUserId", cu.getRamdomValue());
		}
//ログインしてるときはuserIdにloginIdを入れます//
		if(session.containsKey("loginId")){
			userId = String.valueOf(session.get("loginId"));
		}
//ログインしてなくて一時ログインしてるときはuserIdとtempUserIdに一時ログインIDを入れます//
		if(!(session.containsKey("loginId")) && session.containsKey("tempUserId")){
			userId = String.valueOf(session.get("tempUserId"));
			tempUserId = String.valueOf(session.get("tempUserId"));
		}
		productCount = String.valueOf((productCount.split(" ,",0))[0]);
//DBに送ります//
		CartInfoDAO dao = new CartInfoDAO();
		int count = dao.regist(userId, tempUserId, productId, productCount, price);
		if(count > 0){
			result = SUCCESS;
		}
		List<CartInfoDTO> dtoList = new ArrayList<CartInfoDTO>();
		dtoList = dao.getCartInfoDtoList(userId);
		Iterator<CartInfoDTO> iterator = dtoList.iterator();
		if(!(iterator.hasNext())){
			dtoList = null;
		}

		session.put("cartInfoDtoList", dtoList);
		int totalPrice = Integer.parseInt(String.valueOf(dao.getTotalPrice(userId)));
		session.put("totalPrice", totalPrice);
		return result;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductNameKana() {
		return productNameKana;
	}

	public void setProductNameKana(String productNameKana) {
		this.productNameKana = productNameKana;
	}

	public String getImageFilePath() {
		return imageFilePath;
	}

	public void setImageFilePath(String imageFilePath) {
		this.imageFilePath = imageFilePath;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getProductCount() {
		return productCount;
	}

	public void setProductCount(String productCount) {
		this.productCount = productCount;
	}

	public String getReleaseCompany() {
		return releaseCompany;
	}

	public void setReleaseCompany(String releaseCompany) {
		this.releaseCompany = releaseCompany;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
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
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
