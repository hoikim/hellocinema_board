package com.cinema.theater.model.dao;

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

import com.cinema.theater.model.vo.Theater;

public class TheaterDAO {
	
	private Properties prop = new Properties();
	public TheaterDAO() {
		URL fileUrl = TheaterDAO.class.getResource("/sql/theater/theater-query.properties");
		String fileName = fileUrl.getPath();
		
		try {
			prop.load(new FileReader(fileName));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Theater selectTheater(Connection conn, String theaterNo) {
		
		Theater t =null;
		PreparedStatement pstmt =null;
		
		ResultSet rs = null;
		
		String query = prop.getProperty("theaterSelect");
		System.out.println(theaterNo);
		System.out.println(query);
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, theaterNo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				t= new Theater();
				t.setTid(rs.getInt("TID"));
				t.setLid(rs.getInt("LID"));
				t.setName(rs.getString("NAME"));
				t.setAddr(rs.getString("ADDR"));
				t.setTel(rs.getString("TEL"));
			}
			
			System.out.println("t값 DAO"+ t);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t;
	}

	public List<Theater> showAllTheater(Connection conn) {
		List<Theater> tlist = new ArrayList<>();
		PreparedStatement pstmt =null;
		
		ResultSet rs = null;
		
		String query = prop.getProperty("showAllTheater");
		
		
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Theater t= new Theater();
				t.setTid(rs.getInt("TID"));
				t.setLid(rs.getInt("LID"));
				t.setName(rs.getString("NAME"));
				t.setAddr(rs.getString("ADDR"));
				t.setTel(rs.getString("TEL"));
				tlist.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tlist;
	}

	public int insertTheater(Connection conn, Theater t) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("insertTheater");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, t.getLid());
			pstmt.setString(2, t.getName());
			pstmt.setString(3, t.getAddr());
			pstmt.setString(4, t.getTel());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public List<Theater> selectTheaterLocalNo(Connection conn, String localNo) {
		List<Theater> tlist = new ArrayList<>(); 
		PreparedStatement pstmt =null;
		
		ResultSet rs = null;
		
		String query = prop.getProperty("selectTheaterLocalNo");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, localNo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Theater t= new Theater();
				t.setTid(rs.getInt("TID"));
				t.setLid(rs.getInt("LID"));
				t.setName(rs.getString("NAME"));
				t.setAddr(rs.getString("ADDR"));
				t.setTel(rs.getString("TEL"));
				tlist.add(t);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(tlist);
		return tlist;
	}

}
