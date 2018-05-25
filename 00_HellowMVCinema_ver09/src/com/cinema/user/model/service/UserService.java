package com.cinema.user.model.service;

import static com.cinema.common.JDBCTemplate.*;

import java.sql.Connection;

import com.cinema.user.model.dao.UserDAO;
import com.cinema.user.model.vo.User;

public class UserService {
	
	public static final int LOGIN_OK = 1;
	public static final int WRONG_PASSWORD = 0;
	public static final int ID_NOT_EXIST = -1;
	
	public int joinUser(User u) {
		Connection conn = getConnection();
		int result = new UserDAO().joinUser(conn, u);
		
		//트랜잭션 처리
		if(result>0) commit(conn);
		else rollback(conn);
		
		return result;
	}

	public int loginCheck(String id, String pw) {
		Connection conn = getConnection();
		int result = new UserDAO().loginCheck(conn, id, pw);
		close(conn);
		return result;
	}

	public User selectUser(String id) {
		Connection conn = getConnection();
		User u = new UserDAO().selectUser(conn, id);
		close(conn);
		
		return u;
	}

}
