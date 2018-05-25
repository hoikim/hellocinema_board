package com.cinema.room.model.service;

import static com.cinema.common.JDBCTemplate.close;
import static com.cinema.common.JDBCTemplate.commit;
import static com.cinema.common.JDBCTemplate.getConnection;
import static com.cinema.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.cinema.room.model.dao.RoomDAO;
import com.cinema.room.model.vo.Room;
import com.cinema.seat.model.dao.SeatDAO;
import com.cinema.seat.model.vo.Seat;

public class RoomService {

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

	public int insertList(Room room) {
		Connection conn = getConnection();
		
		int result = new RoomDAO().insertList(conn, room);
		
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


	public List<Room> showRoomList(int tid) {
		Connection conn = getConnection();
		List<Room> list = new RoomDAO().showRoomList(conn, tid);
		close(conn);
		
		return list;
	}

}
