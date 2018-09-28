package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dto.UserInfoDTO;
import com.internousdev.ecsite.util.DBConnector;

public class UserInfoDAO {
	public List<UserInfoDTO> getUserInfoList(){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		List<UserInfoDTO> userInfoDTOList = new ArrayList<UserInfoDTO>();
		String sql = "SELECT * FROM login_user_transaction";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				UserInfoDTO dto = new UserInfoDTO();
				dto.setId(rs.getInt("id"));
				dto.setLoginId(rs.getString("login_id"));
				dto.setLoginPass(rs.getString("login_pass"));
				dto.setUserName(rs.getString("user_name"));
				dto.setInsertDate(rs.getString("insert_date"));
				dto.setUpdatedDate(rs.getString("update_date"));
				userInfoDTOList.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return userInfoDTOList;
	}

	public UserInfoDTO getUserInfo(int id){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		UserInfoDTO dto = new UserInfoDTO();
		String sql = "SELECT * FROM login_user_transaction WHERE id = ?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				dto.setId(rs.getInt("id"));
				dto.setLoginId(rs.getString("login_id"));
				dto.setLoginPass(rs.getString("login_pass"));
				dto.setUserName(rs.getString("user_name"));
				dto.setInsertDate(rs.getString("insert_date"));
				dto.setUpdatedDate(rs.getString("updated_date"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return dto;
	}
}
