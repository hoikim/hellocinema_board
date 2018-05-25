package com.cinema.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cinema.admin.model.service.ManagerService;
import com.cinema.admin.model.vo.Manager;

/**
 * Servlet implementation class ManagerReg
 */
@WebServlet(name="MangerReg", urlPatterns= "/manager/managerReg")
public class ManagerReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		int tcode = Integer.parseInt(request.getParameter("tcode"));
		String photo = request.getParameter("photo");
		String mcode = request.getParameter("mcode");
		
		
		System.out.println(id);
		System.out.println(pw);
		System.out.println(name);
		
		
		Manager m = new Manager(0, tcode, id, pw, name, photo);
		
		
		
		
		int result = new ManagerService().insertManager(m);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
