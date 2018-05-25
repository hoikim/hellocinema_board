package com.cinema.local.model.service;

import static com.cinema.common.JDBCTemplate.close;
import static com.cinema.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.cinema.admin.model.vo.Local;
import com.cinema.local.model.dao.LocalDAO;

public class LocalService {
	public List<Local> selectLocalList() {
		Connection conn = getConnection();
		List<Local> llist = new LocalDAO().LocalList(conn);
		close(conn);
		return llist;
	}
}
