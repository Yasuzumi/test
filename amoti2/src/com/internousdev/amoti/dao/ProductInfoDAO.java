package com.internousdev.amoti.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.amoti.dto.ProductInfoDTO;
import com.internousdev.amoti.util.DBConnector;

public class ProductInfoDAO {

	public List<ProductInfoDTO> getProductInfoList() {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		List<ProductInfoDTO> productInfoDtoList = new ArrayList<ProductInfoDTO>();
		String sql = "select * from product_info";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ProductInfoDTO productInfoDto = new ProductInfoDTO();
				productInfoDto.setId(resultSet.getInt("id"));
				productInfoDto.setProductId(resultSet.getInt("product_id"));
				productInfoDto.setProductName(resultSet.getString("product_name"));
				productInfoDto.setProductNameKana(resultSet.getString("product_name_kana"));
				productInfoDto.setProductDescription(resultSet.getString("product_description"));
				productInfoDto.setCategoryId(resultSet.getInt("category_id"));
				productInfoDto.setPrice(resultSet.getInt("price"));
				productInfoDto.setImageFilePath(resultSet.getString("image_file_path"));
				productInfoDto.setImageFileName(resultSet.getString("image_file_name"));
				productInfoDto.setReleaseDate(resultSet.getDate("release_date"));
				productInfoDto.setReleaseCompany(resultSet.getString("release_company"));
				productInfoDto.setStatus(resultSet.getInt("status"));
				productInfoDto.setRegistDate(resultSet.getDate("regist_date"));
				productInfoDto.setUpdateDate(resultSet.getDate("update_date"));
				productInfoDtoList.add(productInfoDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productInfoDtoList;
	}

	public ProductInfoDTO getProductInfo(int productId) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		ProductInfoDTO productInfoDTO = new ProductInfoDTO();
		String sql = "select * from product_info where product_id=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, productId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				productInfoDTO.setId(resultSet.getInt("id"));
				productInfoDTO.setProductId(resultSet.getInt("product_id"));
				productInfoDTO.setProductName(resultSet.getString("product_name"));
				productInfoDTO.setProductNameKana(resultSet.getString("product_name_kana"));
				productInfoDTO.setProductDescription(resultSet.getString("product_description"));
				productInfoDTO.setCategoryId(resultSet.getInt("category_id"));
				productInfoDTO.setPrice(resultSet.getInt("price"));
				productInfoDTO.setImageFilePath(resultSet.getString("image_file_path"));
				productInfoDTO.setImageFileName(resultSet.getString("image_file_name"));
				productInfoDTO.setReleaseDate(resultSet.getDate("release_date"));
				productInfoDTO.setReleaseCompany(resultSet.getString("release_company"));
				productInfoDTO.setStatus(resultSet.getInt("status"));
				productInfoDTO.setUpdateDate(resultSet.getDate("regist_date"));
				productInfoDTO.setUpdateDate(resultSet.getDate("update_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productInfoDTO;
	}

		public List<ProductInfoDTO> getProductInfoListByCategoryId(int categoryId, int productId, int limitOffset,
				int limitRowCount) {
			DBConnector dbConnector = new DBConnector();
			Connection connection = dbConnector.getConnection();
			List<ProductInfoDTO> productInfoDtoList = new ArrayList<ProductInfoDTO>();
			String sql = "select * from product_info where category_id=? and product_id not in(?) order by rand() limit ?,?";
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, categoryId);
				preparedStatement.setInt(2, productId);
				preparedStatement.setInt(3, limitOffset);
				preparedStatement.setInt(4, limitRowCount);
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					ProductInfoDTO productInfoDTO = new ProductInfoDTO();
					productInfoDTO.setId(resultSet.getInt("id"));
					productInfoDTO.setProductId(resultSet.getInt("product_id"));
					productInfoDTO.setProductName(resultSet.getString("product_name"));
					productInfoDTO.setProductNameKana(resultSet.getString("product_name_kana"));
					productInfoDTO.setProductDescription(resultSet.getString("product_description"));
					productInfoDTO.setCategoryId(resultSet.getInt("category_id"));
					productInfoDTO.setPrice(resultSet.getInt("price"));
					productInfoDTO.setImageFilePath(resultSet.getString("image_file_path"));
					productInfoDTO.setImageFileName(resultSet.getString("image_file_name"));
					productInfoDTO.setReleaseDate(resultSet.getDate("release_date"));
					productInfoDTO.setReleaseCompany(resultSet.getString("release_company"));
					productInfoDTO.setStatus(resultSet.getInt("status"));
					productInfoDTO.setUpdateDate(resultSet.getDate("regist_date"));
					productInfoDTO.setUpdateDate(resultSet.getDate("update_date"));
					productInfoDtoList.add(productInfoDTO);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return productInfoDtoList;
		}

		public List<ProductInfoDTO> getProductInfoListAll(String[] keywordsList) {
			DBConnector dbConnector = new DBConnector();
			Connection connection = dbConnector.getConnection();
			List<ProductInfoDTO> productInfoDtoList = new ArrayList<ProductInfoDTO>();
			String sql = "select * from product_info where";
			boolean initializeFlag = true;
			for (String keyword : keywordsList) {
				if (initializeFlag) {
					sql += " (product_name like '%" + keyword + "%' or product_name_kana like '%" + keyword + "%')";
					initializeFlag = false;
				} else {
					sql += " or (product_name like '%" + keyword + "%' or product_name_kana like '%" + keyword + "%')";
				}
			}
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					ProductInfoDTO productInfoDTO = new ProductInfoDTO();
					productInfoDTO.setId(resultSet.getInt("id"));
					productInfoDTO.setProductId(resultSet.getInt("product_id"));
					productInfoDTO.setProductName(resultSet.getString("product_name"));
					productInfoDTO.setProductNameKana(resultSet.getString("product_name_kana"));
					productInfoDTO.setProductDescription(resultSet.getString("product_description"));
					productInfoDTO.setCategoryId(resultSet.getInt("category_id"));
					productInfoDTO.setPrice(resultSet.getInt("price"));
					productInfoDTO.setImageFilePath(resultSet.getString("image_file_path"));
					productInfoDTO.setImageFileName(resultSet.getString("image_file_name"));
					productInfoDTO.setReleaseDate(resultSet.getDate("release_date"));
					productInfoDTO.setReleaseCompany(resultSet.getString("release_company"));
					productInfoDTO.setStatus(resultSet.getInt("status"));
					productInfoDTO.setUpdateDate(resultSet.getDate("regist_date"));
					productInfoDTO.setUpdateDate(resultSet.getDate("update_date"));
					productInfoDtoList.add(productInfoDTO);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return productInfoDtoList;
		}

		public List<ProductInfoDTO> getProductInfoListByKeywords(String[] keywordsList, int categoryId) {
			DBConnector dbConnector = new DBConnector();
			Connection connection = dbConnector.getConnection();
			List<ProductInfoDTO> productInfoDtoList = new ArrayList<ProductInfoDTO>();
			String sql = "select * from product_info where";
			boolean initializeFlag = true;
			for (String keyword : keywordsList) {
				if (initializeFlag) {
					sql += " category_id=" + categoryId + " and (product_name like '%" + keyword + "%' or product_name_kana like '%" + keyword + "%')";
					initializeFlag = false;
				} else {
					sql += " or category_id=" + categoryId + " and (product_name like '%" + keyword + "%' or product_name_kana like '%" + keyword + "%')";
				}
			}
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					ProductInfoDTO productInfoDTO = new ProductInfoDTO();
					productInfoDTO.setId(resultSet.getInt("id"));
					productInfoDTO.setProductId(resultSet.getInt("product_id"));
					productInfoDTO.setProductName(resultSet.getString("product_name"));
					productInfoDTO.setProductNameKana(resultSet.getString("product_name_kana"));
					productInfoDTO.setProductDescription(resultSet.getString("product_description"));
					productInfoDTO.setCategoryId(resultSet.getInt("category_id"));
					productInfoDTO.setPrice(resultSet.getInt("price"));
					productInfoDTO.setImageFilePath(resultSet.getString("image_file_path"));
					productInfoDTO.setImageFileName(resultSet.getString("image_file_name"));
					productInfoDTO.setReleaseDate(resultSet.getDate("release_date"));
					productInfoDTO.setReleaseCompany(resultSet.getString("release_company"));
					productInfoDTO.setStatus(resultSet.getInt("status"));
					productInfoDTO.setRegistDate(resultSet.getDate("regist_date"));
					productInfoDTO.setUpdateDate(resultSet.getDate("update_date"));
					productInfoDtoList.add(productInfoDTO);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return productInfoDtoList;
		}
		// 商品情報をすべて取得するメソッド。
		// ProductListAction で使用。
		public List<ProductInfoDTO> getProductInfoAllList() throws SQLException {
			ArrayList<ProductInfoDTO> productInfoAllDtoList = new ArrayList<ProductInfoDTO>();
			DBConnector db = new DBConnector();
			Connection con = db.getConnection();
			String sql = "SELECT * from product_info";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					ProductInfoDTO pInfo = new ProductInfoDTO();
					pInfo.setId(rs.getInt("id"));
					pInfo.setProductId(rs.getInt("product_id"));
					pInfo.setProductName(rs.getString("product_name"));
					pInfo.setProductNameKana(rs.getString("product_name_kana"));
					pInfo.setProductDescription(rs.getString("product_description"));
					pInfo.setCategoryId(rs.getInt("category_id"));
					pInfo.setPrice(rs.getInt("price"));
					pInfo.setImageFilePath(rs.getString("image_file_path"));
					pInfo.setImageFileName(rs.getString("image_file_name"));
					pInfo.setReleaseDate(rs.getDate("release_date"));
					pInfo.setReleaseCompany(rs.getString("release_company"));
					pInfo.setStatus(rs.getInt("status"));
					pInfo.setRegistDate(rs.getDate("regist_date"));
					pInfo.setUpdateDate(rs.getDate("update_date"));
					productInfoAllDtoList.add(pInfo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				con.close();
			}
			return productInfoAllDtoList;
		}
}
