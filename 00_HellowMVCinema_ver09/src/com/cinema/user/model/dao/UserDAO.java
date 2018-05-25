package com.cinema.user.model.dao;

import static com.cinema.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.cinema.movie.model.dao.MovieDAO;
import com.cinema.user.model.vo.User;
public class UserDAO {
	private Properties prop = new Properties();
	
	
	public UserDAO() {
		URL fileUrl = MovieDAO.class.getResource("/sql/user/user-query.properties");
		String fileName = fileUrl.getPath();
		
		try {
			prop.load(new FileReader(fileName));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public int joinUser(Connection conn, User u) {
		int result =0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertUserSet");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, u.getId());
			pstmt.setString(2, u.getPw());
			pstmt.setString(3, u.getName());
			pstmt.setString(4, u.getBirth());
			pstmt.setString(5, u.getPhone());
			pstmt.setString(6, u.getEmail());
			pstmt.setString(7, u.getGender());
			
			System.out.println(query);
			System.out.println(u.getId()+u.getPw()+u.getName()+u.getBirth()+u.getPhone()+u.getEmail());
			result = pstmt.executeUpdate();
			System.out.println("USERDAO = " + result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}


	public int loginCheck(Connection conn, String id, String pw) {
		int result = -1;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		String query = prop.getProperty("LOGINCHECK");
		
		//1. 미완성쿼리를 가지고 객체생성
		
		try {
			pstmt = conn.prepareStatement(query);
			//2. 쿼리문 변수대입
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, id);
			//3. 쿼리문 실행

			rs = pstmt.executeQuery();
			//4. 결과를 result에 담기
			if(rs.next()) {
				result = rs.getInt("login_check");
			}
			System.out.println("result@MemberDAO.loginCheck="+result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}


	public User selectUser(Connection conn, String id) {
		User u = new User();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = prop.getProperty("SELECTUSER");
		try {
			//미완성쿼리객체생성
			pstmt = conn.prepareStatement(query);
			//쿼리완성
			pstmt.setString(1, id);
			//쿼리실행
			rs = pstmt.executeQuery();
			//rset 데이터를 m에 대입
			if(rs.next()) {
				u.setUsid(rs.getInt("USID"));
				u.setId(id);
				u.setName(rs.getString("NAME"));
				u.setBirth(rs.getString("BIRTH"));
				u.setPhone(rs.getString("PHONE"));
				u.setEmail(rs.getString("EMAIL"));
				u.setLv(rs.getInt("LV"));
				u.setGender(rs.getString("GENDER"));
				u.setRegdate(rs.getDate("REGDATE"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return u;
	}

}
