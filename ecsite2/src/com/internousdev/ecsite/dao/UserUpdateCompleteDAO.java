package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class UserUpdateCompleteDAO{
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();
	private DateUtil du = new DateUtil();

	private String sql = "UPDATE login_user_transaction SET login_id = ?, login_pass = ?, user_name = ?, updated_date = ? WHERE id = ?";

	public void updateUser(String loginId, String loginPass, String userName, String id) throws SQLException{
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setString(2, loginPass);
			ps.setString(3, userName);
			ps.setString(4, du.getDate());
			ps.setString(5, id);
			ps.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
	}
}
