package com.cinema.theater.model.service;

import static com.cinema.common.JDBCTemplate.close;
import static com.cinema.common.JDBCTemplate.commit;
import static com.cinema.common.JDBCTemplate.getConnection;
import static com.cinema.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.cinema.seat.model.dao.SeatDAO;
import com.cinema.theater.model.dao.TheaterDAO;
import com.cinema.theater.model.vo.Theater;

public class TheaterService {

  public Theater selectTheater(String theaterNo) {
		Connection conn = getConnection();
		Theater t = new TheaterDAO().selectTheater(conn, theaterNo);
		close(conn);
		return t;
	}

public List<Theater> showAllTheater() {
	Connection conn = getConnection();
	List<Theater> tlist = new TheaterDAO().showAllTheater(conn);
	close(conn);
	return tlist;
}

public int insertTheater(Theater t) {
	Connection conn = getConnection();
	
	int result = new TheaterDAO().insertTheater(conn, t);
	
	if(result > 0 ) commit(conn);
	else rollback(conn);
	close(conn);
	return result;
}

public List<Theater> selectTheaterLocalNo(String localNo) {
	Connection conn = getConnection();
	List<Theater> tlist = new TheaterDAO().selectTheaterLocalNo(conn, localNo);
	close(conn);
	return tlist;
}

}
