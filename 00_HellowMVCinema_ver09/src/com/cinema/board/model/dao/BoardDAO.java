package com.cinema.board.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.cinema.admin.model.vo.Local;
import com.cinema.board.model.vo.Board;
import com.cinema.theater.model.vo.Theater;

public class BoardDAO {
	Properties prop = new Properties();
	public BoardDAO() {
		String fileName = BoardDAO.class.getResource("/sql/board/board-query.properties").getPath(); 
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public Board selectBoard(Connection conn, int bdid) {
		Board b = new Board();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectBoard");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,bdid);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				b.setBdid(rset.getInt("bdid"));
				b.setContent(rset.getString("content"));
				b.setEndterm(rset.getDate("endterm"));
				b.setImg(rset.getString("img"));
				b.setRegdate(rset.getDate("regdate"));
				b.setStartterm(rset.getDate("startterm"));
				b.setStatus(rset.getString("status"));
				b.setTinfo(rset.getString("tinfo"));
				b.setTitle(rset.getString("title"));
				b.setType(rset.getString("type"));				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return b;
	}
	public List<Board> selectNoticeBoard(Connection conn) {
		List<Board> boardList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectNoticeBoard");
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Board b = new Board();
				b.setBdid(rset.getInt("bdid"));
				b.setContent(rset.getString("content"));
				b.setEndterm(rset.getDate("endterm"));
				b.setImg(rset.getString("img"));
				b.setRegdate(rset.getDate("regdate"));
				b.setStartterm(rset.getDate("startterm"));
				b.setStatus(rset.getString("status"));
				b.setTinfo(rset.getString("tinfo"));
				b.setTitle(rset.getString("title"));
				b.setType(rset.getString("type"));
				boardList.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return boardList;
	}
	public List<Board> selectEventBoard(Connection conn) {
		List<Board> boardList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectEventBoard");
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Board b = new Board();
				b.setBdid(rset.getInt("bdid"));
				b.setContent(rset.getString("content"));
				b.setEndterm(rset.getDate("endterm"));
				b.setImg(rset.getString("img"));
				b.setRegdate(rset.getDate("regdate"));
				b.setStartterm(rset.getDate("startterm"));
				b.setStatus(rset.getString("status"));
				b.setTinfo(rset.getString("tinfo"));
				b.setTitle(rset.getString("title"));
				b.setType(rset.getString("type"));
				boardList.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return boardList;
	}
	public List<Local> selectLocal(Connection conn) {
		List<Local> localList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectLocal");
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Local l = new Local();
				l.setLid(rset.getInt("lid"));
				l.setLname(rset.getString("lname"));
				localList.add(l);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return localList;
	}
	public List<Theater> selectTheater(Connection conn, int lid) {
		List<Theater> theaterList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectTheater");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, lid);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Theater t = new Theater();
				t.setLid(rset.getInt("lid"));
				t.setAddr(rset.getString("addr"));
				t.setTid(rset.getInt("tid"));
				t.setName(rset.getString("name"));
				t.setTel(rset.getString("tel"));
				theaterList.add(t);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return theaterList;
	}
	public int insertNotice(Connection conn, Board b) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("insertNotice");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, b.getType());
			pstmt.setString(2, b.getTitle());
			pstmt.setString(3, b.getContent());
			pstmt.setString(4, b.getImg());
			pstmt.setString(5, b.getTinfo());
			pstmt.setDate(6, b.getStartterm());
			pstmt.setDate(7, b.getEndterm());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return result;
	}
	public int insertEvent(Connection conn, Board b) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("insertEvent");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, b.getType());
			pstmt.setString(2, b.getTitle());
			pstmt.setString(3, b.getContent());
			pstmt.setString(4, b.getImg());
			pstmt.setString(5, b.getTinfo());
			pstmt.setDate(6, b.getStartterm());
			pstmt.setDate(7, b.getEndterm());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return result;
	}
	public int selectNoticeCnt(Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectNoticeCnt");
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("cnt");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return result;
	}
	public List<Board> selectNoticeBoard(Connection conn, int cPage, int onePage) {
		List<Board> boardList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectNoticeListPaging");
		
		try {
			pstmt = conn.prepareStatement(query);
			//cPage=1 이면, 1-5
			//cPage=2 이면, 6-10
			//cPage=3 이면, 11-15
			//cPage=4 이면, 15-20
			pstmt.setInt(1, (cPage-1)*onePage +1);
			pstmt.setInt(2, cPage*onePage);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Board b = new Board();
				b.setBdid(rset.getInt("bdid"));
				b.setContent(rset.getString("content"));
				b.setEndterm(rset.getDate("endterm"));
				b.setImg(rset.getString("img"));
				b.setRegdate(rset.getDate("regdate"));
				b.setStartterm(rset.getDate("startterm"));
				b.setStatus(rset.getString("status"));
				b.setTinfo(rset.getString("tinfo"));
				b.setTitle(rset.getString("title"));
				b.setType(rset.getString("type"));
				boardList.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return boardList;
	}
	public int updateNotice(Connection conn, Board b) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "";
		if(b.getType().equals("notice")) {
			query = prop.getProperty("updateNotice");
		}
		if(b.getType().equals("event")) {
			query = prop.getProperty("updateEvent");
		}
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, b.getType());
			pstmt.setString(2, b.getTitle());
			pstmt.setString(3, b.getContent());
			pstmt.setString(4, b.getImg());
			pstmt.setString(5, b.getTinfo());
			if(b.getType().equals("notice")) {
				pstmt.setInt(6, b.getBdid());
			}
			if(b.getType().equals("event")) {
				pstmt.setDate(6, b.getStartterm());
				pstmt.setDate(7, b.getEndterm());
				pstmt.setInt(8, b.getBdid());
			}
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return result;
	}
	public Board selectBoardBefore(Connection conn, int bdid) {
		Board b = new Board();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectBoardBefore");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,bdid);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				b.setBdid(rset.getInt("bdid"));
				b.setContent(rset.getString("content"));
				b.setEndterm(rset.getDate("endterm"));
				b.setImg(rset.getString("img"));
				b.setRegdate(rset.getDate("regdate"));
				b.setStartterm(rset.getDate("startterm"));
				b.setStatus(rset.getString("status"));
				b.setTinfo(rset.getString("tinfo"));
				b.setTitle(rset.getString("title"));
				b.setType(rset.getString("type"));				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return b;
	}
	public Board selectBoardAfter(Connection conn, int bdid) {
		Board b = new Board();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectBoardAfter");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,bdid);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				b.setBdid(rset.getInt("bdid"));
				b.setContent(rset.getString("content"));
				b.setEndterm(rset.getDate("endterm"));
				b.setImg(rset.getString("img"));
				b.setRegdate(rset.getDate("regdate"));
				b.setStartterm(rset.getDate("startterm"));
				b.setStatus(rset.getString("status"));
				b.setTinfo(rset.getString("tinfo"));
				b.setTitle(rset.getString("title"));
				b.setType(rset.getString("type"));				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return b;
	}
	public List<Board> selectEventBoardPresent(Connection conn, String pPage) {
		List<Board> boardList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectEventBoardPresent");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, pPage);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Board b = new Board();
				b.setBdid(rset.getInt("bdid"));
				b.setContent(rset.getString("content"));
				b.setEndterm(rset.getDate("endterm"));
				b.setImg(rset.getString("img"));
				b.setRegdate(rset.getDate("regdate"));
				b.setStartterm(rset.getDate("startterm"));
				b.setStatus(rset.getString("status"));
				b.setTinfo(rset.getString("tinfo"));
				b.setTitle(rset.getString("title"));
				b.setType(rset.getString("type"));
				boardList.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return boardList;
	}
	public List<Board> selectEventBoardLast(Connection conn, String lPage) {
		List<Board> boardList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectEventBoardLast");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, lPage);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Board b = new Board();
				b.setBdid(rset.getInt("bdid"));
				b.setContent(rset.getString("content"));
				b.setEndterm(rset.getDate("endterm"));
				b.setImg(rset.getString("img"));
				b.setRegdate(rset.getDate("regdate"));
				b.setStartterm(rset.getDate("startterm"));
				b.setStatus(rset.getString("status"));
				b.setTinfo(rset.getString("tinfo"));
				b.setTitle(rset.getString("title"));
				b.setType(rset.getString("type"));
				boardList.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return boardList;
	}
	
}
