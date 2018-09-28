package com.internousdev.amoti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.amoti.dto.CartInfoDTO;
import com.internousdev.amoti.util.DBConnector;

public class CartInfoDAO {

	public List<CartInfoDTO> getCartInfoDtoList(String loginId){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		List<CartInfoDTO> cartInfoDtoList = new ArrayList<CartInfoDTO>();

		String sql = "SELECT "
				+ "ci.id as id,"
				+ "ci.user_id AS user_id,"
				+ "ci.temp_user_id AS temp_user_id,"
				+ "ci.product_id AS product_id,"
				+ "sum(ci.product_count) AS product_count,"
				+ "pi.price AS price,"
				+ "pi.regist_date AS regist_date,"
				+ "pi.update_date AS update_date,"
				+ "pi.product_name AS product_name,"
				+ "pi.product_name_kana AS product_name_kana,"
				+ "pi.product_description AS product_description,"
				+ "pi.category_id AS category_id,"
				+ "pi.image_file_path AS image_file_path,"
				+ "pi.image_file_name AS image_file_name,"
				+ "pi.release_date AS release_date,"
				+ "pi.release_company AS release_company,"
				+ "pi.status AS status,"
				+ "(sum(ci.product_count) * pi.price) AS subtotal "
				+ "FROM cart_info AS ci "
				+ "LEFT JOIN product_info AS pi "
				+ "ON ci.product_id = pi.product_id "
				+ "WHERE ci.user_id = ? "
				+ "group by product_id";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,  loginId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				CartInfoDTO dto = new CartInfoDTO();
				dto.setId(rs.getInt("id"));
				dto.setUserId(rs.getString("user_id"));
				dto.setTempUserId(rs.getString("temp_user_id"));
				dto.setProductId(rs.getInt("product_id"));
				dto.setProductCount(rs.getInt("product_count"));
				dto.setPrice(rs.getInt("price"));
				dto.setRegistDate(rs.getDate("regist_date"));
				dto.setUpdateDate(rs.getDate("update_date"));
				dto.setProductName(rs.getString("product_name"));
				dto.setProductNameKana(rs.getString("product_name_kana"));
				dto.setProductDescription(rs.getString("product_description"));
				dto.setCategoryId(rs.getInt("category_id"));
				dto.setImageFilePath(rs.getString("image_file_path"));
				dto.setImageFileName(rs.getString("image_file_name"));
				dto.setReleaseDate(rs.getDate("release_date"));
				dto.setReleaseCompany(rs.getString("release_company"));
				dto.setStatus(rs.getString("status"));
				dto.setSubtotal(rs.getInt("subtotal"));
				cartInfoDtoList.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return cartInfoDtoList;
	}

	public int getTotalPrice(String userId){
		int totalPrice = 0;
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "SELECT sum(product_count * price) AS total_price FROM cart_info WHERE user_id=? group by user_id";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,  userId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				totalPrice = rs.getInt("total_price");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return totalPrice;
	}

	public int regist(String userId, String tempUserId, int productId, String productCount, int price){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int count = 0;
		String sql = "INSERT INTO cart_info(user_id, temp_user_id, product_id, product_count, price, regist_date) VALUES (?,?,?,?,?, now())";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, tempUserId);
			ps.setInt(3, productId);
			ps.setString(4, productCount);
			ps.setInt(5, price);
			count = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return count;
	}

	public int delete(String id){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int count = 0;
		String sql = "DELETE FROM cart_info WHERE id=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			count = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return count;
	}

	public int delete(String userId, String productId){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int count = 0;
		String sql = "DELETE FROM cart_info WHERE user_id=? AND product_id=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, productId);
			count = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return count;
	}

	public int deleteAll(String loginId) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int count = 0;
		String sql = "DELETE FROM cart_info WHERE user_id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);

			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public boolean isExistsCartInfo(){
		return false;
	}

	public int linkToLoginId(String tempUserId, String loginId){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int count = 0;
		String sql = "UPDATE cart_info SET user_id=?, temp_user_id = null where temp_user_id=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setString(2, tempUserId);
			count = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return count;
	}
}