package com.cinema.ticket.model.service;

import static com.cinema.common.JDBCTemplate.close;
import static com.cinema.common.JDBCTemplate.commit;
import static com.cinema.common.JDBCTemplate.getConnection;
import static com.cinema.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.cinema.ticket.model.dao.TicketDAO;
import com.cinema.ticket.model.vo.Ticket;

public class TicketService {

  public Ticket selectTicket(String TicketNo) {
		Connection conn = getConnection();
		Ticket t = new TicketDAO().selectTicket(conn, TicketNo);
		close(conn);
		return t;
	}

public List<Ticket> showAllTicket() {
	Connection conn = getConnection();
	List<Ticket> tlist = new TicketDAO().showAllTicket(conn);
	close(conn);
	return tlist;
}

public int insertTicket(Ticket t) {
	Connection conn = getConnection();
	
	int result = new TicketDAO().insertTicket(conn, t);
	
	if(result > 0 ) commit(conn);
	else rollback(conn);
	close(conn);
	return result;
}

public List<Ticket> selectTicketLocalNo(String localNo) {
	Connection conn = getConnection();
	List<Ticket> tlist = new TicketDAO().selectTicketLocalNo(conn, localNo);
	close(conn);
	return tlist;
}

public List<Ticket> selectTicketUserId(int userId) {
	Connection conn = getConnection();
	List<Ticket> tlist = new TicketDAO().selectTicketUserId(conn, userId);
	close(conn);
	
	return tlist;
	

}

public List<Map<String, String>> selectTicketUserIdMap(int userId) {
	Connection conn = getConnection();
	List<Map<String, String>> tlist = new TicketDAO().selectTicketUserIdMap(conn, userId);
	close(conn);
	
	return tlist;
	

}

public int selectTicketUserIdCount(int userId) {
	Connection conn = getConnection();
	int totalMember = new TicketDAO().selectTicketUserIdCount(conn, userId);
	close(conn);
	return totalMember;
}


public List<Map<String, String>> selectTicketUserIdPage(int cPage, int numPerPage, int userId) {
	Connection conn = getConnection();
	List<Map<String, String>> tlist = new TicketDAO().selectTicketUserIdPage(conn, cPage, numPerPage, userId);
	close(conn);
	
	return tlist;
}

public int reservation(Map<String, String> map) {
	Connection conn = getConnection();
	
	int result = new TicketDAO().insertTicketMap(conn, map);
	
	if(result > 0 ) commit(conn);
	else rollback(conn);
	close(conn);
	return result;
}

public int selectTicketPageCount() {
	Connection conn = getConnection();
	int totalMember = new TicketDAO().selectTicketPageCount(conn);
	close(conn);
	return totalMember;
}

public List<Map<String, String>> selectTicketPage(int cPage, int numPerPage) {

	Connection conn = getConnection();
	List<Map<String, String>> tlist = new TicketDAO().selectTicketPage(conn, cPage, numPerPage);
	close(conn);
	
	return tlist;
}
}
