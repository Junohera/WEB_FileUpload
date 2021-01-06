package com.juno.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.juno.dto.ProductVO;
import com.juno.util.DataBaseManager;

public class ProductDAO {
	private ProductDAO() {}
	private static ProductDAO ist = new ProductDAO();
	public static ProductDAO getIst() {return ist;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<ProductVO> selectAll() {
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		String sql = "select * from product order by code desc";
		try {
			con = DataBaseManager.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ProductVO product = new ProductVO();
				product.setCode(rs.getInt("code"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getInt("price"));
				product.setPictureurl(rs.getString("pictureurl"));
				product.setDescription(rs.getString("description"));
				list.add(product);
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally {DataBaseManager.close(con, pstmt, rs);}
		return list;
	}

	public ProductVO getProductOne(int code) {
		ProductVO product = null;
		String sql = "select * from product where code = ?";
		try {
			con = DataBaseManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, code);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				product = new ProductVO();
				product.setCode(rs.getInt("code"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getInt("price"));
				product.setPictureurl(rs.getString("pictureurl"));
				product.setDescription(rs.getString("description"));
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally {DataBaseManager.close(con, pstmt, rs);}
		return product;
	}

	public void insertProduct(ProductVO product) {
		String sql = "INSERT INTO PRODUCT (CODE, NAME, PRICE, PICTUREURL, DESCRIPTION) VALUES (PRODUCT_SEQ.NEXTVAL, ?, ?, ?, ?)";
		try {
			con = DataBaseManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, product.getName());
			pstmt.setInt(2, product.getPrice());
			pstmt.setString(3, product.getPictureurl());
			pstmt.setString(4, product.getDescription());
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally {DataBaseManager.close(con, pstmt, rs);}
	}

	public void updateProduct(ProductVO product) {
		String sql = "UPDATE PRODUCT SET NAME = ?, PRICE = ?, PICTUREURL = ?, DESCRIPTION = ? WHERE CODE = ?";                                                                                                                                                             
		try {
			con = DataBaseManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, product.getName());
			pstmt.setInt(2, product.getPrice());
			pstmt.setString(3, product.getPictureurl());
			pstmt.setString(4, product.getDescription());
			pstmt.setInt(5, product.getCode());
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally {DataBaseManager.close(con, pstmt, rs);}
	}

}
