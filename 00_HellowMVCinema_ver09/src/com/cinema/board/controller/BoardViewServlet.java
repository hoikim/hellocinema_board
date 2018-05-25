package com.cinema.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cinema.admin.model.vo.Local;
import com.cinema.admin.model.vo.Manager;
import com.cinema.board.model.service.BoardService;

/**
 * Servlet implementation class BoardViewServlet
 */
@WebServlet("/board/boardView")
public class BoardViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		List<Local> localList = new BoardService().selectLocal();
		
		
		request.setAttribute("localList", localList);
		
		
		int cPage;
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		} catch (NumberFormatException e) {
			cPage=1;
		}
		
		//관리자가 아닌경우 
		Manager sessionManager = (Manager)request.getSession(true).getAttribute("managerSession");
		
		
		String view="";
		if(sessionManager != null) {
			RequestDispatcher reqDispater = request.getRequestDispatcher("/WEB-INF/views/manager/board.jsp");
			reqDispater.forward(request, response);
		}else{
			RequestDispatcher reqDispater = request.getRequestDispatcher("/WEB-INF/views/common/event.jsp");
			reqDispater.forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
