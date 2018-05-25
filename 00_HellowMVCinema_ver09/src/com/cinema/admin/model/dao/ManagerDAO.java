package com.cinema.admin.model.dao;

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

import com.cinema.admin.model.vo.Local;
import com.cinema.admin.model.vo.Manager;

public class ManagerDAO {
	private Properties prop = new Properties();

	public ManagerDAO() {
		URL fileUrl = ManagerDAO.class.getResource("/sql/manager/manager-query.properties");
		String fileName = fileUrl.getPath();
		System.out.println("fileName@MembserDAO="+fileName);
		try {
			prop.load(new FileReader(fileName));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int loginCheck(Connection conn, String id, String pw) {
		int result = -1;
		PreparedStatement pstmt = null;
		ResultSet rset =null;
		
		String query = prop.getProperty("LOGINCHECK");
		
		//1. 미완성쿼리를 가지고 객체생성
		
		try {
			pstmt = conn.prepareStatement(query);
			//2. 쿼리문 변수대입
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, id);
			//3. 쿼리문 실행
			System.out.println(id);
			System.out.println(pw);
			rset = pstmt.executeQuery();
			//4. 결과를 result에 담기
			if(rset.next()) {
				result = rset.getInt("login_check");
			}
			System.out.println("result@MemberDAO.loginCheck="+result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}

	public Manager selectManager(Connection conn, String id) {
		Manager m = new Manager();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = prop.getProperty("selectManager");
		try {
			//미완성쿼리객체생성
			pstmt = conn.prepareStatement(query);
			//쿼리완성
			pstmt.setString(1, id);
			//쿼리실행
			rs = pstmt.executeQuery();
			//rset 데이터를 m에 대입
			if(rs.next()) {
				m.setNid(rs.getInt("NID"));
				m.setTid(rs.getInt("TID"));
				m.setId(rs.getString("ID"));
				m.setPw(rs.getString("PW"));
				m.setName(rs.getString("NAME"));
				m.setPhoto(rs.getString("PHOTO"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return m;
	}

	public int insertMananger(Connection conn, Manager m) {
		int result =0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("INSERTMANAGER");
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, m.getTid());
			pstmt.setString(2, m.getId());
			pstmt.setString(3, m.getPw());
			pstmt.setString(4, m.getName());
			pstmt.setString(5, m.getPhoto());
			//regDate
			System.out.println(pstmt);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int insertLocal(Connection conn, int code ,String local) {
		int result =0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("INSERTLOCAL");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, code);
			pstmt.setString(2, local);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public List<Local> selectLocalList(Connection conn) {
		List<Local> llist = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = prop.getProperty("SELECTLOCAL");
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

	public int deleteLocal(Connection conn, int code) {

		int result =0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("deleteLocal");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, code);
			result = pstmt.executeUpdate();
			System.out.println("MANAGERDAO ____" + result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public Manager selectManagerTid(Connection conn, String tid) {
		Manager m = new Manager();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = prop.getProperty("selectManagerTid");
		try {
			//미완성쿼리객체생성
			pstmt = conn.prepareStatement(query);
			//쿼리완성
			pstmt.setString(1, tid);
			//쿼리실행
			rs = pstmt.executeQuery();
			//rset 데이터를 m에 대입
			if(rs.next()) {
				m.setNid(rs.getInt("NID"));
				m.setTid(rs.getInt("TID"));
				m.setId(rs.getString("ID"));
				m.setPw(rs.getString("PW"));
				m.setName(rs.getString("NAME"));
				m.setPhoto(rs.getString("PHOTO"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return m;
	}

}
