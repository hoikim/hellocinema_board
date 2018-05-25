package com.cinema.schedule.model.dao;

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
import com.cinema.room.model.vo.Room;
import com.cinema.schedule.model.vo.Schedule;

public class ScheduleDAO {
	private Properties prop = new Properties();

	public ScheduleDAO() {
		URL fileUrl = ScheduleDAO.class.getResource("/sql/schedule/schedule-query.properties");
		String fileName = fileUrl.getPath();
		try {
			prop.load(new FileReader(fileName));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public int insertSchedule(Connection conn, Schedule sch) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertSchedule");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, sch.getRid());
			pstmt.setInt(2, sch.getMid());
			//pstmt.setInt(3, sch.getLseat());
			pstmt.setString(3, sch.getSeat());
			pstmt.setString(4, sch.getTime());
			pstmt.setString(5, sch.getEndtime());
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}


	public List<Schedule> selectScheduleQuery(Connection conn, String query) {
		
		List<Schedule> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			//mid, name, ename, grade, time, director, actor, genre, 
			//story, reldate, poster, subimg, trailer, regdate : default
			
			while(rs.next()) {
				Schedule sch = new Schedule();
				sch.setShid(rs.getInt("SHID"));
				sch.setRid(rs.getInt("RID"));
				sch.setMid(rs.getInt("MID"));
				sch.setLseat(rs.getInt("LSEAT"));
				sch.setSeat(rs.getString("SEAT"));
				sch.setTime(rs.getString("STIME"));
				sch.setEndtime(rs.getString("SENDTIME"));
/*				sch.setTime(String.valueOf(rs.getDate("TIME")));
				sch.setEndtime(String.valueOf(rs.getDate("ENDTIME")));*/
				sch.setRegdate(String.valueOf(rs.getDate("REGDATE")));
				list.add(sch);
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
	
	
 

	public List<Map<String, String>> selectScheduleQueryMap(Connection conn, String query) {
		
		List<Map<String, String>> schList = new ArrayList<>();
		Map<String, String> schMap = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			//mid, name, ename, grade, time, director, actor, genre, 
			//story, reldate, poster, subimg, trailer, regdate : default
			
			while(rs.next()) {
			    schMap = new HashMap<>();
				schMap.put("schedule", rs.getString("SHID"));
				schMap.put("tid", rs.getString("TID"));
				schMap.put("rid", rs.getString("RID"));
				schMap.put("sid", rs.getString("SID"));
				schMap.put("name", rs.getString("NAME"));
				schMap.put("rname", rs.getString("RNAME"));
				schMap.put("rtype", rs.getString("RTYPE"));
				schMap.put("mname", rs.getString("MNAME"));
				schMap.put("grade", rs.getString("GRADE"));
				schMap.put("poster", rs.getString("POSTER"));
				schMap.put("scnt", rs.getString("SCNT"));
				schMap.put("slcnt", rs.getString("SLCNT"));
				schMap.put("mreldate", rs.getString("MRELDATE"));
				schMap.put("stime", rs.getString("STIME"));
				schMap.put("sendtime", rs.getString("SENDTIME"));
				schMap.put("seat", rs.getString("SEAT"));
				
				schList.add(schMap);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return schList;
	}


	public List<Schedule> seletcScheduleDateList(Connection conn, String date, String room) {
		
		List<Schedule> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = prop.getProperty("scheduleListforDate");
		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, room);
			pstmt.setString(2, date);
			rs = pstmt.executeQuery();
			
			//mid, name, ename, grade, time, director, actor, genre, 
			//story, reldate, poster, subimg, trailer, regdate : default
			
			while(rs.next()) {
				Schedule sch = new Schedule();
				sch.setShid(rs.getInt("SHID"));
				sch.setRid(rs.getInt("RID"));
				sch.setMid(rs.getInt("MID"));
				sch.setLseat(rs.getInt("LSEAT"));
				sch.setTime(rs.getString("STARTTIME"));
				sch.setEndtime(rs.getString("ENDTIME"));
				list.add(sch);
			}
			System.out.println("ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ"+list);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
	}
	

}
