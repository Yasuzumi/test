package com.internousdev.amoti.action;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.amoti.dao.DestinationInfoDAO;
import com.internousdev.amoti.dto.DestinationInfoDTO;
import com.internousdev.amoti.dto.PurchaseHistoryInfoDTO;
import com.internousdev.amoti.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class SettlementConfirmAction extends ActionSupport implements SessionAware{


	private String categoryId;
	private Collection<String> checkList;
	private String productId;
	private String productName;
	private String productNameKana;
	private String imageFilePath;
	private String imageFileName;
	private String price;
	private String releaseCompany;
	private String releaseDate;
	private String productCount;
	private String subtotal;
	private Map<String, Object> session;
	public String execute() {
		String result = ERROR;
		session.remove("loginIdErrorMessageList");
		session.remove("passwordErrorMessageList");

		session.remove("familyName");
		session.remove("firstName");
		session.remove("familyNameKana");
		session.remove("firstNameKana");
		session.remove("sex");
		session.remove("email");
		session.remove("telNumber");
		session.remove("userAddress");

		if(session.containsKey("loginId")) {
			DestinationInfoDAO destinationInfoDAO = new DestinationInfoDAO();
			List<DestinationInfoDTO> destinationInfoDtoList = new ArrayList<>();
			try {
				destinationInfoDtoList = destinationInfoDAO.getDestinationInfo(String.valueOf(session.get("loginId")));
				Iterator<DestinationInfoDTO> iterator = destinationInfoDtoList.iterator();
				if(!(iterator.hasNext())) {
					destinationInfoDtoList = null;
				}
				session.put("destinationInfoDtoList", destinationInfoDtoList);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if(productId != null){

			List<PurchaseHistoryInfoDTO> purchaseHistoryInfoDtoList = new ArrayList<PurchaseHistoryInfoDTO>();

			CommonUtility commonUtility = new CommonUtility();
			String[] productIdList = commonUtility.parseArrayList(String.valueOf(productId));
			String[] productNameList = commonUtility.parseArrayList(String.valueOf(productName));
			String[] productNameKanaList = commonUtility.parseArrayList(String.valueOf(productNameKana));
			String[] imageFilePathList = commonUtility.parseArrayList(String.valueOf(imageFilePath));
			String[] imageFileNameList = commonUtility.parseArrayList(String.valueOf(imageFileName));
			String[] priceList = commonUtility.parseArrayList(String.valueOf(price));
			String[] releaseCompanyList = commonUtility.parseArrayList(String.valueOf(releaseCompany));
			String[] releaseDateList = commonUtility.parseArrayList(String.valueOf(releaseDate));
			String[] productCountList = commonUtility.parseArrayList(String.valueOf(productCount));
			String[] subtotalList = commonUtility.parseArrayList(String.valueOf(subtotal));
			for(int i=0;i<productIdList.length;i++) {
				PurchaseHistoryInfoDTO purchaseHistoryInfoDTO = new PurchaseHistoryInfoDTO();
				purchaseHistoryInfoDTO.setUserId(String.valueOf(session.get("loginId")));
				purchaseHistoryInfoDTO.setProductId(Integer.parseInt(String.valueOf(productIdList[i])));
				purchaseHistoryInfoDTO.setProductName(String.valueOf(productNameList[i]));
				purchaseHistoryInfoDTO.setProductNameKana(String.valueOf(productNameKanaList[i]));
				purchaseHistoryInfoDTO.setImageFilePath(String.valueOf(imageFilePathList[i]));
				purchaseHistoryInfoDTO.setImageFileName(String.valueOf(imageFileNameList[i]));
				purchaseHistoryInfoDTO.setPrice(Integer.parseInt(String.valueOf(priceList[i])));
				purchaseHistoryInfoDTO.setReleaseCompany(String.valueOf(releaseCompanyList[i]));
				try {
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
					purchaseHistoryInfoDTO.setReleaseDate(simpleDateFormat.parse(String.valueOf(releaseDateList[i])));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				purchaseHistoryInfoDTO.setProductCount(Integer.parseInt(String.valueOf(productCountList[i])));
				purchaseHistoryInfoDTO.setSubtotal(Integer.parseInt(String.valueOf(subtotalList[i])));
				purchaseHistoryInfoDtoList.add(purchaseHistoryInfoDTO);
			}
		session.put("purchaseHistoryInfoDtoList", purchaseHistoryInfoDtoList);
		}

		if(session.containsKey("loginId")) {
			result = SUCCESS;
		}else if(session.containsKey("tempUserId")){
			session.put("settlementFlg", "1");
		}
		return result;
	}

	public Collection<String> getCheckList() {
		return checkList;
	}

	public void setCheckList(Collection<String> checkList) {
		this.checkList = checkList;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getReleaseCompany() {
		return releaseCompany;
	}

	public void setReleaseCompany(String releaseCompany) {
		this.releaseCompany = releaseCompany;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getProductCount() {
		return productCount;
	}

	public void setProductCount(String productCount) {
		this.productCount = productCount;
	}

	public String getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(String subtotal) {
		this.subtotal = subtotal;
	}
}
