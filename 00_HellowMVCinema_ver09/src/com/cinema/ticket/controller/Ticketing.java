package com.cinema.ticket.controller;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class Ticketing
 */
@WebServlet("/ticketing")
public class Ticketing extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		User user = (User) request.getSession().getAttribute("userSession");
		String type= request.getParameter("type");
		String view = "";
		
		
		if(user != null) {
			String obj = request.getParameter("obj");
			String[] val = request.getParameterValues("val[]");
			
			Gson gson = new Gson(); 
			Map<String,String> map = new HashMap<String,String>();
			map = (Map<String, String>) gson.fromJson(obj, map.getClass());
			
			System.out.println(map);
			System.out.println(map.get("scnt"));
			
			int result = new TicketService().reservation(map);
			
			new Gson().toJson(result, response.getWriter());
			
			
			//List<Map<String, String>> list = new ArrayList<Map<String,String>>();
			//Map<String, String> m = new HashMap<>();
			
			
			
			//int result = new TicketService().reservation(list);
			
			//request.setAttribute("result", result);
			
		} else {
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
