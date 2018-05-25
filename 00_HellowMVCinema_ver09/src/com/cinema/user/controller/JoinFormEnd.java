package com.cinema.user.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cinema.user.model.service.UserService;
import com.cinema.user.model.vo.User;

/**
 * Servlet implementation class JoinUser
 */
@WebServlet(name="UserJoinEnd", urlPatterns="/user/joinend")
public class JoinFormEnd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String birth = request.getParameter("birth");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		
		System.out.println(id);
		int result =0;
		
		User u = new User(id, pw, name, birth, phone, email, gender);
		
		System.out.println(u);
		
		
		result = new UserService().joinUser(u);

		String view ="/WEB-INF/views/user/joinEnd.jsp";
		if(result > 0 ) {
			request.setAttribute("user", u);
			HttpSession session = request.getSession();
			session.setAttribute("userSession", u);
			
			
		}else {
			request.setAttribute("msg", "회원가입에 실패하였습니다.");
		}
		RequestDispatcher reqDispatcher = request.getRequestDispatcher("");
		reqDispatcher.forward(request, response);
		
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
