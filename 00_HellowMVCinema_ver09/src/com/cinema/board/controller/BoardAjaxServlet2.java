package com.cinema.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cinema.board.model.service.BoardService;
import com.cinema.theater.model.vo.Theater;
import com.google.gson.Gson;

/**
 * Servlet implementation class ScheduleAjaxServlet1
 */
@WebServlet("/board/boardAjax2.do")
public class BoardAjaxServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardAjaxServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("utf-8");
		
		int lid =Integer.parseInt(request.getParameter("lid"));
		
		
		List <Theater> theaterList = new BoardService().selectTheater(lid); 
		
		
		response.setContentType("application/json; charset=utf-8");
		new Gson().toJson(theaterList, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
