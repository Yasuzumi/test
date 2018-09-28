package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class ItemUpdateCompleteDAO {
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();
	private DateUtil du = new DateUtil();

	private String sql = "UPDATE item_info_transaction SET item_name = ?, item_price = ?, item_stock = ?, update_date = ? WHERE id = ?";

	public void updateItem(String itemName, String itemPrice, String itemStock, String id) throws SQLException{
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, itemName);
			ps.setString(2, itemPrice);
			ps.setString(3, itemStock);
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
