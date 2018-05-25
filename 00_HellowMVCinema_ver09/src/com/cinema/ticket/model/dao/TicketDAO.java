package com.cinema.ticket.model.dao;

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.cinema.ticket.model.vo.Ticket;


public class TicketDAO {
	
	private Properties prop = new Properties();
	public TicketDAO() {
		URL fileUrl = TicketDAO.class.getResource("/sql/ticket/ticket-query.properties");
		String fileName = fileUrl.getPath();
		
		try {
			prop.load(new FileReader(fileName));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Ticket selectTicket(Connection conn, String TicketNo) {
		
		Ticket ticket =null;
		PreparedStatement pstmt =null;
		
		ResultSet rs = null;
		
		String query = prop.getProperty("TicketSelect");
		System.out.println(TicketNo);
		System.out.println(query);
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, TicketNo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ticket= new Ticket();
				ticket.setBid(rs.getInt("BID"));
				ticket.setUsid(rs.getInt("USID"));
				ticket.setShid(rs.getInt("SHID"));
				ticket.setAdult(rs.getInt("ADULT"));
				ticket.setChild(rs.getInt("CHILD"));
				ticket.setTeen(rs.getInt("TEEN"));
				ticket.setOld(rs.getInt("OLD"));
				ticket.setPrice(rs.getInt("PRICE"));
				ticket.setChecked(rs.getString("CHECKED"));
				ticket.setUse(rs.getString("USE"));
				ticket.setSeatnum(rs.getString("SEATNUM"));
				ticket.setStatus(rs.getString("STATUS"));
				ticket.setEtc(rs.getString("ETC"));
				ticket.setRegdate(rs.getString("REGDATE"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ticket;
	}

	public List<Ticket> showAllTicket(Connection conn) {
		List<Ticket> tlist = new ArrayList<>();
		PreparedStatement pstmt =null;
		
		ResultSet rs = null;
		
		String query = prop.getProperty("showAllTicket");
		
		
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Ticket ticket= new Ticket();
				ticket.setBid(rs.getInt("BID"));
				ticket.setUsid(rs.getInt("USID"));
				ticket.setShid(rs.getInt("SHID"));
				ticket.setAdult(rs.getInt("ADULT"));
				ticket.setChild(rs.getInt("CHILD"));
				ticket.setTeen(rs.getInt("TEEN"));
				ticket.setOld(rs.getInt("OLD"));
				ticket.setPrice(rs.getInt("PRICE"));
				ticket.setChecked(rs.getString("CHECKED"));
				ticket.setUse(rs.getString("USE"));
				ticket.setSeatnum(rs.getString("SEATNUM"));
				ticket.setEtc(rs.getString("ETC"));
				ticket.setStatus(rs.getString("STATUS"));
				ticket.setRegdate(rs.getString("REGDATE"));
				tlist.add(ticket);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tlist;
	}

	public int insertTicket(Connection conn, Ticket ticket) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("insertTicket");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(2, ticket.getUsid());
			pstmt.setInt(3, ticket.getShid());
			pstmt.setInt(4, ticket.getAdult());
			pstmt.setInt(5, ticket.getChild());
			pstmt.setInt(6, ticket.getTeen());
			pstmt.setInt(7, ticket.getOld());
			pstmt.setInt(8, ticket.getPrice());
			pstmt.setString(9, ticket.getChecked());
			pstmt.setString(10, ticket.getUse());
			pstmt.setString(11, ticket.getSeatnum());
			pstmt.setString(12, ticket.getEtc());
			pstmt.setString(13, ticket.getStatus());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public List<Ticket> selectTicketLocalNo(Connection conn, String localNo) {
		List<Ticket> tlist = new ArrayList<>(); 
		PreparedStatement pstmt =null;
		
		ResultSet rs = null;
		
		String query = prop.getProperty("selectTicketLocalNo");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, localNo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Ticket ticket = new Ticket();
				ticket.setBid(rs.getInt("BID"));
				ticket.setUsid(rs.getInt("USID"));
				ticket.setShid(rs.getInt("SHID"));
				ticket.setAdult(rs.getInt("ADULT"));
				ticket.setChild(rs.getInt("CHILD"));
				ticket.setTeen(rs.getInt("TEEN"));
				ticket.setOld(rs.getInt("OLD"));
				ticket.setPrice(rs.getInt("PRICE"));
				ticket.setChecked(rs.getString("CHECKED"));
				ticket.setUse(rs.getString("USE"));
				ticket.setSeatnum(rs.getString("SEATNUM"));
				ticket.setEtc(rs.getString("ETC"));
				ticket.setStatus(rs.getString("STATUS"));
				ticket.setRegdate(rs.getString("REGDATE"));
				tlist.add(ticket);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tlist;
	}

	public List<Ticket> selectTicketUserId(Connection conn, int userId) {
		List<Ticket> tlist = new ArrayList<>(); 
		PreparedStatement pstmt =null;
		
		ResultSet rs = null;
		
		String query = prop.getProperty("selectTicketUserId");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, userId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Ticket ticket = new Ticket();
				ticket.setBid(rs.getInt("BID"));
				ticket.setUsid(rs.getInt("USID"));
				ticket.setShid(rs.getInt("SHID"));
				ticket.setAdult(rs.getInt("ADULT"));
				ticket.setChild(rs.getInt("CHILD"));
				ticket.setTeen(rs.getInt("TEEN"));
				ticket.setOld(rs.getInt("OLD"));
				ticket.setPrice(rs.getInt("PRICE"));
				ticket.setChecked(rs.getString("CHECKED"));
				ticket.setUse(rs.getString("USE"));
				ticket.setSeatnum(rs.getString("SEATNUM"));
				ticket.setEtc(rs.getString("ETC"));
				ticket.setStatus(rs.getString("STATUS"));
				ticket.setRegdate(rs.getString("REGDATE"));
				tlist.add(ticket);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tlist;
	}
	
	
	
	public List<Map<String, String>> selectTicketUserIdMap(Connection conn, int userId) {
		List<Map<String, String>> tlist = new ArrayList<>(); 
		Map<String, String> m = null;
		PreparedStatement pstmt =null;
		
		ResultSet rs = null;
		
		String query = prop.getProperty("selectTicketUserId");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, userId);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				m = new HashMap<>();
				
				m.put("BID", rs.getString("BID"));
				m.put("USID", rs.getString("USID"));
				m.put("SHID", rs.getString("SHID"));
				m.put("ADULT", rs.getString("ADULT"));
				m.put("CHILD", rs.getString("CHILD"));
				m.put("TEEN", rs.getString("TEEN"));
				m.put("OLD", rs.getString("OLD"));
				m.put("PRICE", rs.getString("PRICE"));
				m.put("CHECKED", rs.getString("CHECKED"));
				m.put("SEATNUM", rs.getString("SEATNUM"));
				m.put("ETC", rs.getString("ETC"));
				m.put("STATUS", rs.getString("STATUS"));
				m.put("REGDATE", rs.getString("TREGDATE"));
				m.put("STIME", rs.getString("STIME"));
				m.put("TNAME", rs.getString("TNAME"));
				m.put("RNAME", rs.getString("RNAME"));
				m.put("MNAME", rs.getString("MNAME"));
				m.put("POSTER", rs.getString("POSTER"));
				tlist.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return tlist;
	}

	public int selectTicketUserIdCount(Connection conn, int userId) {
		int totalMember=0;

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectTicketUserIdCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, userId);
			rset = pstmt.executeQuery();
			
			rset.next();
			totalMember = rset.getInt("cnt");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return totalMember;
	}

	public List<Map<String, String>> selectTicketUserIdPage(Connection conn, int cPage, int numPerPage, int userId) {
		List<Map<String, String>> tlist = new ArrayList<>(); 
		Map<String, String> m = null;
		PreparedStatement pstmt =null;
		
		ResultSet rs = null;
		
		String query = prop.getProperty("selectTicketUserIdPage");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,  userId);
			pstmt.setInt(2, numPerPage*(cPage-1) + 1);
			pstmt.setInt(3, cPage*numPerPage);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				m = new HashMap<>();
				
				m.put("BID", rs.getString("BID"));
				m.put("USID", rs.getString("USID"));
				m.put("SHID", rs.getString("SHID"));
				m.put("ADULT", rs.getString("ADULT"));
				m.put("CHILD", rs.getString("CHILD"));
				m.put("TEEN", rs.getString("TEEN"));
				m.put("OLD", rs.getString("OLD"));
				m.put("PRICE", rs.getString("PRICE"));
				m.put("CHECKED", rs.getString("CHECKED"));
				m.put("SEATNUM", rs.getString("SEATNUM"));
				m.put("ETC", rs.getString("ETC"));
				m.put("STATUS", rs.getString("STATUS"));
				m.put("REGDATE", rs.getString("TREGDATE"));
				m.put("STIME", rs.getString("STIME"));
				m.put("TNAME", rs.getString("TNAME"));
				m.put("RNAME", rs.getString("RNAME"));
				m.put("MNAME", rs.getString("MNAME"));
				m.put("POSTER", rs.getString("POSTER"));
				tlist.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	finally {
			close(rs);
			close(pstmt);
		}
		return tlist;
		
	}

	public int insertTicketMap(Connection conn, Map<String, String> map) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("insertTicket");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1,     Integer.parseInt(map.get("usid")	));
			pstmt.setInt(2,     Integer.parseInt(map.get("schedule")	));
			pstmt.setInt(3,     Integer.parseInt(map.get("adult")	));
			pstmt.setInt(4,     Integer.parseInt(map.get("child")	));
			pstmt.setInt(5,     Integer.parseInt(map.get("teen")	));
			pstmt.setInt(6,     Integer.parseInt(map.get("old")		));
			pstmt.setInt(7,     Integer.parseInt(map.get("price")	));
			pstmt.setString(8,                   map.get("seatnum") );
			pstmt.setString(9,                   map.get("etc")		);
			pstmt.setString(10,                  map.get("seat") 	);
			result = pstmt.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int selectTicketPageCount(Connection conn) {
		int totalMember=0;

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectTicketPageCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			rset.next();
			totalMember = rset.getInt("cnt");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return totalMember;
	}

	public List<Map<String, String>> selectTicketPage(Connection conn, int cPage, int numPerPage) {
		List<Map<String, String>> tlist = new ArrayList<>(); 
		Map<String, String> m = null;
		PreparedStatement pstmt =null;
		
		ResultSet rs = null;
		
		String query = prop.getProperty("selectTicketPage");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, numPerPage*(cPage-1) + 1);
			pstmt.setInt(2, cPage*numPerPage);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				m = new HashMap<>();
				
				m.put("BID", rs.getString("BID"));
				m.put("USID", rs.getString("USID"));
				m.put("SHID", rs.getString("SHID"));
				m.put("ADULT", rs.getString("ADULT"));
				m.put("CHILD", rs.getString("CHILD"));
				m.put("TEEN", rs.getString("TEEN"));
				m.put("OLD", rs.getString("OLD"));
				m.put("PRICE", rs.getString("PRICE"));
				m.put("CHECKED", rs.getString("CHECKED"));
				m.put("SEATNUM", rs.getString("SEATNUM"));
				m.put("ETC", rs.getString("ETC"));
				m.put("STATUS", rs.getString("STATUS"));
				m.put("REGDATE", rs.getString("TREGDATE"));
				m.put("STIME", rs.getString("STIME"));
				m.put("TNAME", rs.getString("TNAME"));
				m.put("RNAME", rs.getString("RNAME"));
				m.put("MNAME", rs.getString("MNAME"));
				m.put("POSTER", rs.getString("POSTER"));
				tlist.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	finally {
			close(rs);
			close(pstmt);
		}
		return tlist;
	}

}
