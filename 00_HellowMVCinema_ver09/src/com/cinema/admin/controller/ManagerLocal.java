package com.cinema.admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cinema.admin.model.service.ManagerService;
import com.cinema.admin.model.vo.Local;
import com.google.gson.Gson;

/**
 * Servlet implementation class LocalReg
 */
@WebServlet("/manager/local")
public class ManagerLocal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String type = request.getParameter("type");
		String view = ""; //request
		
		if(type!=null) {
			if(type.equals("list")) {
				System.out.println("리스트로 접근하셨습니다.");
				List<Local> list = new ManagerService().selectLocalList();
				System.out.println(list);
				response.setContentType("application/json; charset=utf-8");
				new Gson().toJson(list, response.getWriter());
				
			}else if(type.equals("insert")) {
				System.out.println("삽입으로 접근하셨습니다.");
				String local = request.getParameter("localName");
				int code = Integer.parseInt(request.getParameter("localCode"));
				
				int result = new ManagerService().insertLocal(code, local);
				
				System.out.println(result);
				System.out.println(local);
				
			}else if(type.equals("delete")) {
				System.out.println("삭제로 접근하셨습니다.");
				
				int code = Integer.parseInt(request.getParameter("localCode"));
				int result = new ManagerService().deleteLocal(code);
				
				
			}else {
				
				
			}
		}else {
			
			request.getRequestDispatcher("/WEB-INF/views/manager/local.jsp").forward(request, response);;
		}


		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
