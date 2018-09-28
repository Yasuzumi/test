package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class ItemDeleteDAO{
	public int ItemDelete(String id) throws SQLException{
		int result = 0;
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "DELETE FROM item_info_transaction WHERE id = ?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			result = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return result;
	}
}
