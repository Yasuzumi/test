package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.UserListDTO;
import com.internousdev.ecsite.util.DBConnector;

public class UserListDAO {
	public ArrayList<UserListDTO> getUserListInfo() throws SQLException{
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ArrayList<UserListDTO> userListDTO = new ArrayList<UserListDTO>();

		String sql = "SELECT * FROM login_user_transaction";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				UserListDTO DTO = new UserListDTO();
				DTO.setId(rs.getInt("id"));
				DTO.setUserId(rs.getString("login_id"));
				DTO.setUserPass(rs.getString("login_pass"));
				DTO.setUserName(rs.getString("user_name"));
				DTO.setInsertDate(rs.getDate("insert_date"));
				DTO.setUpdatedDate(rs.getDate("updated_date"));
				userListDTO.add(DTO);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return userListDTO;
	}
}
