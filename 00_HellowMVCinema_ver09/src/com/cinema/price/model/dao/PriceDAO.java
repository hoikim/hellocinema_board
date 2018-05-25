package com.cinema.price.model.dao;

import static com.cinema.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.cinema.price.model.vo.Price;

public class PriceDAO {
	
	private Properties prop = new Properties();
	public PriceDAO() {
		URL fileUrl = PriceDAO.class.getResource("/sql/price/price-query.properties");
		String fileName = fileUrl.getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int setPrice(Connection conn, Price price) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("setPrice");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public List<Price> getPrice(Connection conn) {
		List<Price> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		String query = prop.getProperty("getPrice");
		
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Price price = new Price();
				price.setPid(rs.getInt("PID"));
				price.setPrice(rs.getInt("PRICE"));
				price.setName(rs.getString("NAME"));
				price.setKind(rs.getString("KIND"));
				price.setEtc(rs.getString("ETC"));
				list.add(price);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	public List<Price> getPriceNameType(Connection conn) {
		List<Price> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		String query = prop.getProperty("getPrice");
		
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

	public Price getPriceETC(Connection conn, String etc) {
		Price price = new Price();
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		String query = prop.getProperty("getPriceETC");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, etc);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				price.setPid(rs.getInt("PID"));
				price.setPrice(rs.getInt("PRICE"));
				price.setName(rs.getString("NAME"));
				price.setKind(rs.getString("KIND"));
				price.setEtc(rs.getString("ETC"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return price;
	}

	public List<Price> getPriceKind(Connection conn, String kind) {
		List<Price> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		String query = prop.getProperty("getPriceKind");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, kind);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Price price = new Price();
				price.setPid(rs.getInt("PID"));
				price.setPrice(rs.getInt("PRICE"));
				price.setName(rs.getString("NAME"));
				price.setKind(rs.getString("KIND"));
				price.setEtc(rs.getString("ETC"));
				list.add(price);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

}
