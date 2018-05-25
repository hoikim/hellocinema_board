package com.cinema.board.model.service;

import static com.cinema.common.JDBCTemplate.close;
import static com.cinema.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.cinema.admin.model.vo.Local;
import com.cinema.board.model.dao.BoardDAO;
import com.cinema.board.model.vo.Board;
import com.cinema.theater.model.vo.Theater;

public class BoardService {

	public Board selectBoard(int bdid) {
		Connection conn = getConnection();
		Board b = new BoardDAO().selectBoard(conn,bdid);
		close(conn);
		return b;
	}
	public List<Theater> selectTheater(int lid) {
		Connection conn = getConnection();
		List<Theater> list = new BoardDAO().selectTheater(conn, lid);
		close(conn);
		return list;
	}
	public List<Local> selectLocal() {
		Connection conn = getConnection();
		List<Local> list = new BoardDAO().selectLocal(conn);
		close(conn);
		return list;
	}

	public List<Board> selectNoticeBoard() {
		Connection conn = getConnection();
		List<Board> boardList = new BoardDAO().selectNoticeBoard(conn);
		close(conn);
		return boardList;
	}

	public List<Board> selectEventBoard() {
		Connection conn = getConnection();
		List<Board> boardList = new BoardDAO().selectEventBoard(conn);
		close(conn);
		return boardList;
	}

	public int insertNotice(Board b) {
		Connection conn = getConnection();
		int result = new BoardDAO().insertNotice(conn,b);
		close(conn);
		return result;
	}

	public int insertEvent(Board b) {
		Connection conn = getConnection();
		int result = new BoardDAO().insertEvent(conn,b);
		close(conn);
		return result;
	}

	public int selectNoticeCnt() {
		Connection conn = getConnection();
		int result = new BoardDAO().selectNoticeCnt(conn);
		close(conn);
		return result;
	}

	public List<Board> selectNoticeBoard(int cPage, int onePage) {
		Connection conn = getConnection();
		List<Board> boardList = new BoardDAO().selectNoticeBoard(conn, cPage, onePage);
		close(conn);
		return boardList;
	}

	public int updateNotice(Board b) {
		Connection conn = getConnection();
		int result = new BoardDAO().updateNotice(conn,b);
		close(conn);
		return result;
	}

	public Board selectBoardBefore(int bdid) {
		Connection conn = getConnection();
		Board b = new BoardDAO().selectBoardBefore(conn,bdid);
		close(conn);
		return b;
	}
	public Board selectBoardAfter(int bdid) {
		Connection conn = getConnection();
		Board b = new BoardDAO().selectBoardAfter(conn,bdid);
		close(conn);
		return b;
	}

	public List<Board> selectEventBoardPresent(String pPage) {
		Connection conn = getConnection();
		List<Board> boardList = new BoardDAO().selectEventBoardPresent(conn, pPage);
		close(conn);
		return boardList;
	}
	public List<Board> selectEventBoardLast(String lPage) {
		Connection conn = getConnection();
		List<Board> boardList = new BoardDAO().selectEventBoardLast(conn, lPage);
		close(conn);
		return boardList;
	}


	

}
