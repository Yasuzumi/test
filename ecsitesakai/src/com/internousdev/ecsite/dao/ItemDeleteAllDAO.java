package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class ItemDeleteAllDAO {
	public int ItemDeleteAll() throws SQLException{
		int result = 0;
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "DELETE FROM item_info_transaction";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			result = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return result;
	}
}
