package com.internousdev.ecsite.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.LoginKanriDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.dto.LoginKanriDTO;
import com.opensymphony.xwork2.ActionSupport;


public class LoginKanriAction extends ActionSupport implements SessionAware {

			private String loginUserId;
			private String loginPassword;
			public Map<String,Object> session;
			private LoginKanriDAO loginKanriDAO = new LoginKanriDAO();
			private LoginKanriDTO loginKanriDTO = new LoginKanriDTO();
			private BuyItemDAO buyItemDAO = new BuyItemDAO();


			public String execute(){
				String result = ERROR;
				loginKanriDTO = loginKanriDAO.getLoginUserInfo(loginUserId, loginPassword);
				session.put("loginUser", loginKanriDTO);

				if(((LoginKanriDTO) session.get("loginUser")).getLoginFlg()) {
					result = SUCCESS;
					BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();

					session.put("login_user_id",loginKanriDTO.getLoginId());
					session.put("id", buyItemDTO.getId());
					session.put("buyItem_name",buyItemDTO.getItemName());
					session.put("buyItem_price",buyItemDTO.getItemPrice());


						return result;

				}
				return result;

			}

			public String getLoginUserId(){
					return loginUserId;
			}

			public void setLoginUserId(String loginUserId){
					this.loginUserId = loginUserId;

			}

			public String getLoginPassword(){
					return loginPassword;
			}

			public void setLoginPassword(String loginPassword){
					this.loginPassword = loginPassword;
			}

			public Map<String, Object> getSession(){
					return session;
			}

			@Override
			public void setSession(Map<String,Object> session){
				this.session = session;


			}



}