package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.ItemListDTO;
import com.internousdev.ecsite.util.DBConnector;

public class ItemListDAO {
	public ArrayList<ItemListDTO> getItemListInfo() throws SQLException{
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ArrayList<ItemListDTO> itemListDTO = new ArrayList<ItemListDTO>();

		String sql = "SELECT * FROM item_info_transaction";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				ItemListDTO DTO = new ItemListDTO();
				DTO.setId(rs.getInt("id"));
				DTO.setItemName(rs.getString("item_name"));
				DTO.setItemPrice(rs.getInt("item_price"));
				DTO.setItemStock(rs.getInt("item_stock"));
				DTO.setInsertDate(rs.getDate("insert_date"));
				DTO.setUpdateDate(rs.getDate("update_date"));
				itemListDTO.add(DTO);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return itemListDTO;
	}
}
