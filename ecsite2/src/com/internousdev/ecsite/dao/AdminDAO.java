package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.dto.AdminDTO;
import com.internousdev.ecsite.util.DBConnector;

public class AdminDAO {
	public AdminDTO getAdminUserInfo(String adminUserId,String adminPassword){
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		AdminDTO adminDTO = new AdminDTO();
		String sql = "SELECT * FROM admin_user_transaction WHERE admin_id = ? AND admin_pass = ?";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, adminUserId);
			preparedStatement.setString(2, adminPassword);

			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){
				adminDTO.setAdminId(resultSet.getString("admin_id"));
				adminDTO.setAdminPassword(resultSet.getString("admin_pass"));
				adminDTO.setAdminName(resultSet.getString("admin_name"));

				if(!(resultSet.getString("admin_id").equals(null))){
					adminDTO.setAdminFlg(true);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return adminDTO;
	}

}
