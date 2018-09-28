package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.internousdev.ecsite.util.DBConnector;

public class ItemInfoDAO {

	public List<ItemInfoDTO> getItemInfoList(){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		List<ItemInfoDTO> itemInfoDTOList = new ArrayList<ItemInfoDTO>();
		String sql = "SELECT * FROM item_info_transaction";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				ItemInfoDTO dto = new ItemInfoDTO();
				dto.setId(rs.getInt("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getInt("item_price"));
				dto.setItemStock(rs.getInt("item_stock"));
				dto.setInsertDate(rs.getString("insert_date"));
				dto.setUpdateDate(rs.getString("update_date"));
				itemInfoDTOList.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return itemInfoDTOList;
	}

	public ItemInfoDTO getItemInfo(int id){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ItemInfoDTO dto = new ItemInfoDTO();
		String sql = "SELECT * FROM item_info_transaction WHERE id = ?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				dto.setId(rs.getInt("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getInt("item_price"));
				dto.setItemStock(rs.getInt("item_stock"));
				dto.setInsertDate(rs.getString("insert_date"));
				dto.setUpdateDate(rs.getString("update_date"));
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
