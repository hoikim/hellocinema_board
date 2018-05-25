package com.cinema.theater.cotroller;

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
 * Servlet implementation class UserTheater
 */
@WebServlet("/userTheater")
public class UserTheater extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserTheater() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("여기는 띠어터");
		
		
		if(request.getParameter("type") != null) {
			response.setContentType("application/json; charset=utf-8");
			String type = request.getParameter("type");
			String theaterNo = request.getParameter("theaterNo");
			String localNo = request.getParameter("LocalNo");
			
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
				
				
			}else if(type.equals("showAllTheater")) {
				response.setContentType("application/json; charset=utf-8");
				List<Theater> tlist = new TheaterService().showAllTheater();
				new Gson().toJson(tlist, response.getWriter());
				
			}else if(type.equals("showTheaterLID")) {
	
				List<Theater> tlist = new TheaterService().selectTheaterLocalNo(localNo);
				new Gson().toJson(tlist, response.getWriter());
				
				
			}
		}else {
		
	
		request.getRequestDispatcher("/WEB-INF/views/user/theater.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
