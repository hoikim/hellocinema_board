package com.cinema.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cinema.user.model.service.UserService;
import com.cinema.user.model.vo.User;
import com.google.gson.Gson;


/**
 * Servlet implementation class UserLogin
 */
@WebServlet(name="UserLogin", urlPatterns="/login/userlogin")
public class LoginUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//2.파라미터값 변수에 기록하기
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println("여기는 로그인 id = "+ id);
		System.out.println("여기는 로그인 pw = "+ pw);
		//쿠키관련
		String usaveId = request.getParameter("usaveId");
		
		System.out.println("usaveId=" + usaveId);
		
		//3. 비지니스 로직
		int result = new UserService().loginCheck(id, pw);
		
		//쿠키
		if(usaveId != null) {
			Cookie c = new Cookie("usaveId", id);
			c.setMaxAge(60*60*24*7); //유효기간을 초단위로 설정
			c.setPath("/"); //해당 도메인 전역에서 이 쿠키를 사용함.
			response.addCookie(c);
		}else{
			Cookie c = new Cookie("usaveId", id);
			c.setMaxAge(0);
			c.setPath("/");
			response.addCookie(c);
		}
		
		
		
		
		//4. 받은결과에 따라서 view단 분기
		
		String view= "";
		String msg = "";
		String loc = "/";
		

		String Referer = request.getHeader("Referer");
		String Origin = request.getHeader("Origin");
		String url = request.getRequestURL().toString();
		String uri = request.getRequestURI();
		//크롬외 브라우져 용
		if(Origin ==null) {
			Origin = url.replace(uri, "");
		}
		
		loc = Referer.replace(Origin + request.getContextPath(), "");
		
		
		if(result == UserService.LOGIN_OK) {
			view ="/";
			//회원정보 가져오기
			
			User u = new UserService().selectUser(id);

			//세션생성
			//세션이 존재하면, 해당세션을 리턴, 없으면 새로 생성해서 리턴.
			HttpSession session = request.getSession();
			
//			HttpSession session = request.getSession(true);
//			//세션이 존재하면, 해당세션을 리턴, 없으면 null리턴
//			HttpSession session = request.getSession(false);
			System.out.println("발급된 세션아이디 : " + session.getId());
			session.setAttribute("userSession", u);
			//세션타임아웃설정
			session.setMaxInactiveInterval(5*60);
			//리다이렉트
			//더이상 request를 이용할 필요 없음.
			
			response.setContentType("application/json; charset=utf-8");
			
			PrintWriter out = response.getWriter();
			out.println("성공");			
			
			
			
			//로그인이 실패한경우
		}else{
			view = "/WEB-INF/views/common/msg.jsp";
			
			if(result == UserService.WRONG_PASSWORD) {
				msg = "패스워드를 잘못 입력하셨습니다.";
			}else if(result == UserService.ID_NOT_EXIST){
				msg = "존재하지 않는 아이디 입니다.";
			}
			
			request.setAttribute("msg", msg);
			request.setAttribute("loc", loc);
			
			RequestDispatcher reqDispatcher = request.getRequestDispatcher(view);
			reqDispatcher.forward(request, response);
			
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
