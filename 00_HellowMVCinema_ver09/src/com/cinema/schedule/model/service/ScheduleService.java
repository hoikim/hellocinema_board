package com.cinema.schedule.model.service;

import static com.cinema.common.JDBCTemplate.close;
import static com.cinema.common.JDBCTemplate.commit;
import static com.cinema.common.JDBCTemplate.getConnection;
import static com.cinema.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.cinema.schedule.model.dao.ScheduleDAO;
import com.cinema.schedule.model.vo.Schedule;

public class ScheduleService {

	public int insertSchedule(Schedule sch) {
			Connection conn = getConnection();
			
			int result = new ScheduleDAO().insertSchedule(conn, sch);
			if(result > 0 ) commit(conn);
			else rollback(conn);
			close(conn);
			return result;
		}

	public List<Schedule> selectScheduleQuery(String query) {
		Connection conn = getConnection();
		List<Schedule> list = new ScheduleDAO().selectScheduleQuery(conn, query);
		
		close(conn);
		
		return list;
	}
	

	public List<Map<String, String>> selectScheduleQueryMap(String query) {
		Connection conn = getConnection();
		List<Map<String, String>> schList =new ScheduleDAO().selectScheduleQueryMap(conn, query);
		close(conn);
		
		return schList;
	}

	public List<Schedule> seletcScheduleDateList(String date, String room) {
		Connection conn = getConnection();
		List<Schedule> list = new ScheduleDAO().seletcScheduleDateList(conn, date, room);
		
		close(conn);
		
		return list;
	}

}
