package com.cinema.seat.model.service;

import static com.cinema.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.cinema.seat.model.dao.SeatDAO;
import com.cinema.seat.model.vo.Seat;

public class SeatService {

	public List<Seat> seatList(int tid) {
		Connection conn = getConnection();
		List<Seat> list = new SeatDAO().seatList(conn, tid);
		
		close(conn);
		
		return list;
	}
	
	
	public Map<Integer, Seat> seatListMap(int tid) {
		Connection conn = getConnection();
		Map<Integer, Seat> mapList = new SeatDAO().seatListMap(conn, tid);
		
		close(conn);
		
		return mapList;
	}

	public int insertList(Seat seat) {
		Connection conn = getConnection();
		
		int result = new SeatDAO().insertList(conn, seat);
		
		if(result > 0 ) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
		
	
	}

	public int updateList(Seat seat) {
		Connection conn = getConnection();
		
		int result = new SeatDAO().updateList(conn, seat);
		
		if(result > 0 ) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}


	public Seat showSidSeat(String sid) {
		Connection conn = getConnection();
		Seat seat = new SeatDAO().showSidSeat(conn, sid);
		close(conn);
			
		return seat;
	}

}
