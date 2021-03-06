package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.dto.LoginKanriDTO;
import com.internousdev.ecsite.util.DBConnector;

public class LoginKanriDAO{



	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private LoginKanriDTO loginKanriDTO = new LoginKanriDTO();


	public LoginKanriDTO getLoginUserInfo(String loginUserId,String loginPassword){

		String sql = "SELECT * FROM kanri_user_transaction where kanri_id = ?AND kanri_pass = ?";



	try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, loginUserId);
			preparedStatement.setString(2, loginPassword);

			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){
					loginKanriDTO.setLoginId(resultSet.getString("kanri_id"));
					loginKanriDTO.setLoginPassword(resultSet.getString("kanri_pass"));
					loginKanriDTO.setUserName(resultSet.getString("kanri_name"));

					if(!(resultSet.getString("kanri_id").equals(null))){
							loginKanriDTO.setLoginFlg(true);
					}
			}
			}catch(Exception e){
					e.printStackTrace();
			}
			return loginKanriDTO;
	}

	public LoginKanriDTO getLoginKanriDTO(){
			return loginKanriDTO;





	}

}

