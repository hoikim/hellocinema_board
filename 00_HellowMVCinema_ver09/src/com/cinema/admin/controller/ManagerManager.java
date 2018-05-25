package com.cinema.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cinema.admin.model.service.ManagerService;
import com.cinema.admin.model.vo.Manager;
import com.google.gson.Gson;

/**
 * Servlet implementation class Manager
 */
@WebServlet("/manager/manager")
public class ManagerManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "/WEB-INF/views/manager/manager.jsp";
		String type = request.getParameter("type");
		if(type!=null) {
		String tid = request.getParameter("theaterNo");
		response.setContentType("application/json; charset=utf-8");
		Manager m =new ManagerService().selectManagerTid(tid);
		new Gson().toJson(m, response.getWriter());
		}else {
			request.getRequestDispatcher(view).forward(request, response);
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
