package com.cinema.admin.model.service;

import static com.cinema.common.JDBCTemplate.*;
import static com.cinema.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.cinema.admin.model.dao.ManagerDAO;
import com.cinema.admin.model.vo.Local;
import com.cinema.admin.model.vo.Manager;


public class ManagerService {
	
	public static final int LOGIN_OK = 1;
	public static final int WRONG_PASSWORD = 0;
	public static final int ID_NOT_EXIST = -1;
	
	public int loginCheck(String id, String pw) {
		Connection conn = getConnection();
		int result = new ManagerDAO().loginCheck(conn, id, pw);
		close(conn);
		return result;
	}

	public Manager selectManager(String id) {
		Connection conn = getConnection();
		Manager m = new ManagerDAO().selectManager(conn, id);
		close(conn);
		
		return m;
	}

	public int insertManager(Manager m) {
		Connection conn = getConnection();
		int result = new ManagerDAO().insertMananger(conn, m);
		if(result> 0 ) commit(conn);
		else rollback(conn);
		
		close(conn);
		return result;
	}

	public int insertLocal(int code, String local) {
		Connection conn = getConnection();
		int result = new ManagerDAO().insertLocal(conn, code, local);
		if(result> 0 ) commit(conn);
		else rollback(conn);
		
		close(conn);
		return result;
	
	}
	
	public int deleteLocal(int code) {
		Connection conn = getConnection();
		int result = new ManagerDAO().deleteLocal(conn, code);
		if(result> 0 ) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

	public List<Local> selectLocalList() {
		Connection conn = getConnection();
		List<Local> llist = new ManagerDAO().selectLocalList(conn);
		close(conn);
		return llist;
	}

	public Manager selectManagerTid(String tid) {
		Connection conn = getConnection();
		Manager m = new ManagerDAO().selectManagerTid(conn, tid);
		close(conn);
		
		return m;
	}


}
