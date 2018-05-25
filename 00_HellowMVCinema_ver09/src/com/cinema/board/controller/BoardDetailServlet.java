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
import com.cinema.board.model.vo.Board;

/**
 * Servlet implementation class BoardDetailServlet
 */
@WebServlet("/board/boardDetail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bdid = Integer.parseInt(request.getParameter("bdid"));
		
		Board b = new BoardService().selectBoard(bdid);
		Board bb = new BoardService().selectBoardBefore(bdid);
		Board ba = new BoardService().selectBoardAfter(bdid);
		List<Local> localList = new BoardService().selectLocal();
		
		
		request.setAttribute("localList", localList);
		request.setAttribute("selectBoard", b);
		request.setAttribute("selectBoardBefore", bb);
		request.setAttribute("selectBoardAfter", ba);
		
		String uPage="detail";
		try {
			uPage = request.getParameter("uPage");
		} catch (NullPointerException e) {
			uPage="detail";
		}
		
		//관리자가 아닌경우 
		Manager sessionManager = (Manager)request.getSession(true).getAttribute("managerSession");
		
		
		String view="";
		if(sessionManager != null) {
			if("update".equals(uPage)) {
				RequestDispatcher reqDispatcher = request.getRequestDispatcher("/WEB-INF/views/manager/boardUpdate.jsp");
				reqDispatcher.forward(request,response);			
			} else {
				RequestDispatcher reqDispatcher = request.getRequestDispatcher("/WEB-INF/views/manager/boardDetail.jsp");
				reqDispatcher.forward(request,response);	
			}
		}else{
			RequestDispatcher reqDispater = request.getRequestDispatcher("/WEB-INF/views/common/boardDetail.jsp");
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
