package com.cinema.user.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cinema.ticket.model.service.TicketService;
import com.cinema.user.model.service.UserService;
import com.cinema.user.model.vo.User;
import com.google.gson.Gson;

/**
 * Servlet implementation class Users
 */
@WebServlet("/users")
public class Users extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		User user = (User) request.getSession().getAttribute("userSession");
		String type= request.getParameter("type");
		String view = "";
		
		
		if(user != null) {
			String userId = request.getParameter("userid");
			User u = new UserService().selectUser(userId);
			request.setAttribute("user", u);
			
			if(type.equals("viewInfo")) {
				view = "/WEB-INF/views/user/info.jsp";
			}else if(type.equals("updateInfo")){
				view = "/WEB-INF/views/user/update.jsp";
				
			}else if(type.equals("viewTicket")) {
				
				
				//List<Ticket> tlist = new TicketService().selectTicketUserId(user.getUsid());
				//List<Map<String, String>> tlist = new TicketService().selectTicketUserIdMap(user.getUsid());
				
				
				int cPage;
				try {
					cPage = Integer.parseInt(request.getParameter("cPage"));
				}catch(NumberFormatException e) {
					cPage =1;
				}
				System.out.println("cPage="+cPage);
				
				int numPerPage = 5;
				int totalTicket = new TicketService().selectTicketUserIdCount(user.getUsid());
				
				int totalPage = (int)Math.ceil((double)totalTicket/numPerPage);						
				List<Map<String, String>> tlistp = new TicketService().selectTicketUserIdPage(cPage, numPerPage, user.getUsid());
				
				String pageBar = "";
				int pageBarSize = 5; //페이지바 페이지갯수

				int pageNo = ((cPage-1)/pageBarSize)*pageBarSize+1;
				int pageEnd =  pageNo + pageBarSize - 1; 
				
				//[이전]
				if(pageNo == 1) {
					
				}else {
					pageBar +="<a href=" +request.getContextPath()+"/users?type=viewTicket&cPage="+(pageNo-1)+"><span>[이전]</span></a>";
				}
				
				while(pageNo <= pageEnd && pageNo <= totalPage) {
					if(pageNo == cPage) {
						pageBar += "<span>" + pageNo + "</span>";
						
					}else {
						pageBar += "<a href="+request.getContextPath()+"/users?type=viewTicket&cPage="+pageNo+"><span>" + pageNo + "</span></a>";
					}
					pageNo++;
				}
				
				if(pageNo >= totalPage) {
					
				}else{
					pageBar +="<a href=" +request.getContextPath()+"/users?type=viewTicket&cPage="+(pageNo)+"><span>[다음]</span></a>";
				}
				
				
				
				
				
				
				
				
				
				
				
				
				System.out.println("tlist"+user.getUsid());
				request.setAttribute("tlist", tlistp);
				
				request.setAttribute("pageBar", pageBar);
				response.setContentType("application/json; charset=utf-8");
				String g = new Gson().toJson(tlistp);
				
				request.setAttribute("glist", g);
				
				view = "/WEB-INF/views/user/ticket.jsp";	
				
				
				
				
				
			
			}else {
				String msg ="잘못된 경로로 접근하셨습니다.";
				String loc = "/";
				view = "/WEB-INF/views/common/msg.jsp";
				
				request.setAttribute("msg", msg);
				request.setAttribute("loc", loc);
			}
			
		}else {
			String msg ="잘못된 경로로 접근하셨습니다.";
			String loc = "/";
			view = "/WEB-INF/views/common/msg.jsp";
			
			request.setAttribute("msg", msg);
			request.setAttribute("loc", loc);
		}
		
		request.getRequestDispatcher(view).forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
