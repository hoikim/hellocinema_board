package com.cinema.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cinema.theater.model.service.TheaterService;
import com.cinema.theater.model.vo.Theater;
import com.google.gson.Gson;

/**
 * Servlet implementation class ManagerTheater
 */
@WebServlet("/manager/theater")
public class ManagerTheater extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("여기는 띠어터");
		
		
		if(request.getParameter("type") != null) {
			String type = request.getParameter("type");
			String theaterNo = request.getParameter("theaterNo");
			System.out.println(type);
			System.out.println(theaterNo);
			System.out.println("여기는 띠어터"+type.equals("selectTheater"));
			
			if(type.equals("selectTheater")) {
				response.setContentType("application/json; charset=utf-8");
				Theater t =new TheaterService().selectTheater(theaterNo);
				new Gson().toJson(t, response.getWriter());
			}else if(type.equals("insertTheater")){
				String name = request.getParameter("name");
				int local = Integer.parseInt(request.getParameter("local"));
				String addr = request.getParameter("addr");
				String tel = request.getParameter("tel");
				
				
				Theater t = new Theater();
				t.setName(name);
				t.setLid(local);
				t.setAddr(addr);
				t.setTel(tel);
				
				int result = new TheaterService().insertTheater(t);
				
				System.out.println("인서트 리절트"+result);
				
			}else if(type.equals("showAllTheater")) {
				response.setContentType("application/json; charset=utf-8");
				List<Theater> tlist = new TheaterService().showAllTheater();
				new Gson().toJson(tlist, response.getWriter());
				
			}
		}else {
	
		request.getRequestDispatcher("/WEB-INF/views/manager/theater.jsp").forward(request, response);;
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
