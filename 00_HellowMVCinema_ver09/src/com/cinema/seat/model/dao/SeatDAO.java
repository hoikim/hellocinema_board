package com.cinema.seat.model.dao;

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

import com.cinema.movie.model.vo.Movie;
import com.cinema.seat.model.vo.Seat;

public class SeatDAO {

	private Properties prop = new Properties();
	public SeatDAO() {
		URL fileUrl = SeatDAO.class.getResource("/sql/seat/seat-query.properties");
		String fileName = fileUrl.getPath();
		try {
			prop.load(new FileReader(fileName));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Seat> seatList(Connection conn, int tid) {
		List<Seat> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		String query = prop.getProperty("seatList");

		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, tid);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Seat s = new Seat();
				s.setSid(rs.getInt("SID"));
				s.setTid(rs.getInt("TID"));
				s.setName(rs.getString("NAME"));
				s.setShape(rs.getString("SHAPE"));
				s.setEtc(rs.getString("ETC"));
				list.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			
		}
		return list;
	}

	public int insertList(Connection conn, Seat seat) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("seatInsert");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, seat.getTid());
			pstmt.setString(2, seat.getName());
			pstmt.setString(3, seat.getShape());
			pstmt.setString(4, seat.getEtc());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int updateList(Connection conn, Seat seat) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("seatUpdate");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, seat.getName());
			pstmt.setString(2, seat.getShape());
			pstmt.setString(3, seat.getEtc());
			pstmt.setInt(4, seat.getSid());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public Map<Integer, Seat> seatListMap(Connection conn, int tid) {
		Map<Integer, Seat> mapList = new HashMap<>();
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		String query = prop.getProperty("seatList");

		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, tid);
			
			rs = pstmt.executeQuery();
			int num = 0;
			while(rs.next()) {
				Seat s = new Seat();
				s.setSid(rs.getInt("SID"));
				s.setTid(rs.getInt("TID"));
				s.setName(rs.getString("NAME"));
				s.setShape(rs.getString("SHAPE"));
				s.setEtc(rs.getString("ETC"));
				mapList.put(num, s);
				num++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			
		}
		return mapList;
	}

	public Seat showSidSeat(Connection conn, String sid) {
		Seat seat = new Seat();
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		String query = prop.getProperty("showSidSeat");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, sid);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				seat.setSid(rs.getInt("SID"));
				seat.setTid(rs.getInt("TID"));
				seat.setName(rs.getString("NAME"));
				seat.setShape(rs.getString("SHAPE"));
				seat.setEtc(rs.getString("ETC"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			
		}
		return seat;
		
	}

}
