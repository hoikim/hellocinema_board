package com.cinema.local.model.dao;

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

import com.cinema.admin.model.dao.ManagerDAO;
import com.cinema.admin.model.vo.Local;

public class LocalDAO {

	
	
	
	private Properties prop = new Properties();

	public LocalDAO() {
		URL fileUrl = LocalDAO.class.getResource("/sql/local/local-query.properties");
		String fileName = fileUrl.getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public List<Local> LocalList(Connection conn) {
		List<Local> llist = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = prop.getProperty("LocalList");
		try {
			//미완성쿼리객체생성
			pstmt = conn.prepareStatement(query);
			//쿼리완성
			//쿼리실행
			rs = pstmt.executeQuery();
			//rset 데이터를 m에 대입
			while(rs.next()) {
				Local l = new Local();
				l.setLid(rs.getInt("LID"));
				l.setLname(rs.getString("LNAME"));
				llist.add(l);
				System.out.println(l);
			}   
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return llist;
	}
}
