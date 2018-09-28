package com.internousdev.amoti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.amoti.dto.PurchaseHistoryInfoDTO;
import com.internousdev.amoti.util.DBConnector;

public class PurchaseHistoryInfoDAO {

	/* 一般購入履歴 */
	public List<PurchaseHistoryInfoDTO> getPurchaseHistoryList(String loginId){

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		List<PurchaseHistoryInfoDTO> purchaseHistoryInfoDTOList = new ArrayList<PurchaseHistoryInfoDTO>();
		String sql = "select"
				+ " phi.id as id,"
				+ " phi.user_id as user_id,"
				+ " phi.product_count as product_count,"
				+ " pi.product_id as product_id,"
				+ " pi.product_name as product_name,"
				+ " pi.product_name_kana as product_name_kana,"
				+ " pi.product_description as product_description,"
				+ " pi.category_id as category_id,"
				+ " pi.price,"
				+ " pi.image_file_name as image_file_name,"
				+ " pi.image_file_path as image_file_path,"
				+ " pi.release_company,"
				+ " pi.release_date,"
				+ " phi.price as price,"
				+ " phi.regist_date as regist_date,"
				+ " phi.update_date as update_date,"
				+ " di.family_name as family_name,"
				+ " di.first_name as first_name,"
				+ " di.family_name_kana as family_name_kana,"
				+ " di.first_name_kana as first_name_kana,"
				+ " di.email as email,"
				+ " di.tel_number as tel_number,"
				+ " di.user_address as user_address"
				+ " FROM purchase_history_info as phi"
				+ " LEFT JOIN product_info as pi"
				+ " ON phi.product_id = pi.product_id"
				+ " LEFT JOIN destination_info as di"
				+ " ON phi.destination_id = di.id"
				+ " WHERE phi.user_id = ?"
				+ " ORDER BY regist_date DESC";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				PurchaseHistoryInfoDTO purchaseHistoryInfoDto = new PurchaseHistoryInfoDTO();
				purchaseHistoryInfoDto.setId(resultSet.getInt("id"));
				purchaseHistoryInfoDto.setUserId(resultSet.getString("user_id"));
				purchaseHistoryInfoDto.setProductId(resultSet.getInt("product_id"));
				purchaseHistoryInfoDto.setProductCount(resultSet.getInt("product_count"));
				purchaseHistoryInfoDto.setPrice(resultSet.getInt("price"));
				purchaseHistoryInfoDto.setRegistDate(resultSet.getDate("regist_date"));
				purchaseHistoryInfoDto.setUpdateDate(resultSet.getDate("update_date"));
				purchaseHistoryInfoDto.setProductName(resultSet.getString("product_name"));
				purchaseHistoryInfoDto.setProductNameKana(resultSet.getString("product_name_kana"));
				purchaseHistoryInfoDto.setProductDescription(resultSet.getString("product_description"));
				purchaseHistoryInfoDto.setCategoryId(resultSet.getInt("category_id"));
				purchaseHistoryInfoDto.setImageFileName(resultSet.getString("image_file_name"));
				purchaseHistoryInfoDto.setImageFilePath(resultSet.getString("image_file_path"));
				purchaseHistoryInfoDto.setReleaseCompany(resultSet.getString("release_company"));
				purchaseHistoryInfoDto.setReleaseDate(resultSet.getDate("release_date"));
				purchaseHistoryInfoDto.setFamilyName(resultSet.getString("family_name"));
				purchaseHistoryInfoDto.setFirstName(resultSet.getString("first_name"));
				purchaseHistoryInfoDto.setFamilyNameKana(resultSet.getString("family_name_kana"));
				purchaseHistoryInfoDto.setFirstNameKana(resultSet.getString("first_name_kana"));
				purchaseHistoryInfoDto.setEmail(resultSet.getString("email"));
				purchaseHistoryInfoDto.setTelNumber(resultSet.getString("tel_number"));
				purchaseHistoryInfoDto.setUserAddress(resultSet.getString("user_address"));
				purchaseHistoryInfoDTOList.add(purchaseHistoryInfoDto);

			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return purchaseHistoryInfoDTOList;
	}

	/* 購入履歴追加 */
	public int regist(String loginId, int productId, int productCount, int destinationId, int price){

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		String sql = "insert into purchase_history_info(user_id, product_id, product_count, price, destination_id, regist_date, update_date) values (?, ?, ?, ?, ?, now(), '0000-01-01')";
		int count = 0;
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginId);
			preparedStatement.setInt(2, productId);
			preparedStatement.setInt(3, productCount);
			preparedStatement.setInt(4, price);
			preparedStatement.setInt(5, destinationId);
			count = preparedStatement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return count;
	}


	/* 購入履歴全削除 */
	public int deleteAll(String loginId){

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		String sql = "delete from purchase_history_info where user_id=?";
		int count = 0;
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginId);
			count = preparedStatement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return count;
	}
}
