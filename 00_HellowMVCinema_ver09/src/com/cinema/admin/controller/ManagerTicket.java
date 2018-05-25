package com.cinema.admin.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cinema.ticket.model.service.TicketService;
import com.cinema.user.model.vo.User;
import com.google.gson.Gson;

/**
 * Servlet implementation class ManagerTicket
 */
@WebServlet("/manager/ticket")
public class ManagerTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type= request.getParameter("type");
		
		
		
		int cPage;
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		}catch(NumberFormatException e) {
			cPage =1;
		}
		System.out.println("cPage="+cPage);
		
		int numPerPage = 5;
		int totalTicket = new TicketService().selectTicketPageCount();
		
		int totalPage = (int)Math.ceil((double)totalTicket/numPerPage);						
		List<Map<String, String>> tlistp = new TicketService().selectTicketPage(cPage, numPerPage);
		
		String pageBar = "";
		int pageBarSize = 5; //페이지바 페이지갯수

		int pageNo = ((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd =  pageNo + pageBarSize - 1; 
		
		//[이전]
		if(pageNo == 1) {
			
		}else {
			pageBar +="<a href=" +request.getContextPath()+"/manager/ticket?type=viewTicket&cPage="+(pageNo-1)+"><span>[이전]</span></a>";
		}
		
		while(pageNo <= pageEnd && pageNo <= totalPage) {
			if(pageNo == cPage) {
				pageBar += "<span>" + pageNo + "</span>";
				
			}else {
				pageBar += "<a href="+request.getContextPath()+"/manager/ticket?type=viewTicket&cPage="+pageNo+"><span>" + pageNo + "</span></a>";
			}
			pageNo++;
		}
		
		if(pageNo >= totalPage) {
			
		}else{
			pageBar +="<a href=" +request.getContextPath()+"/manager/ticket?type=viewTicket&cPage="+(pageNo)+"><span>[다음]</span></a>";
		}
		
		
		request.setAttribute("tlist", tlistp);
		
		request.setAttribute("pageBar", pageBar);
		response.setContentType("application/json; charset=utf-8");
		String g = new Gson().toJson(tlistp);
		
		request.setAttribute("glist", g);
		
		
		
		
		request.getRequestDispatcher("/WEB-INF/views/manager/ticket.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
