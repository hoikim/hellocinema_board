package com.cinema.movie.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.cinema.movie.model.service.MovieService;
import com.cinema.movie.model.vo.Movie;

/**
 * Servlet implementation class ShowMovieList
 */
@WebServlet("/movie/showMovieList")
public class ShowMovieList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String type = request.getParameter("type");
		if(type != null) {
			if(type.equals("pagingRequest")) {
			//1. 파라미터 변수에 담기
			int cPage;
			try {
				cPage = Integer.parseInt(request.getParameter("cPage"));
			}catch(NumberFormatException e) {
				cPage =1;
			}
			System.out.println("cPage="+cPage);
			
			//2.비지니스 로직
			
				//페이지당 멤버
			int numPerPage = 4;
				//전체게시물
			int totalMember = new MovieService().moviesAllCount();
				//(공식1) totalPage
				//100건이면, totalPage = 20, totalPage=21;
			//int totalPage = (Integer)(totalMember / numPerPage) + (totalMember % numPerPage);
			int totalPage = ((int)Math.ceil((double)(totalMember / numPerPage)));
					
			//2.2 페이징된 회원리스트 가져오기
			List<Movie> list = new MovieService().showMoivesPaging(cPage, numPerPage);
			
			//2.3 페이징바 만들기
			String pageBar = "";
			int pageBarSize = 5; //페이지바 페이지갯수
			int pageNo = ((cPage-1)/pageBarSize)*pageBarSize+1;
			int pageEnd =  pageNo + pageBarSize - 1; 
			


			

	
			pageBar +="<a href='javascript:void(0);' onclick='fn_showMovieList("+pageNo+")'>다음</a>";
			JSONArray jsonArr=new JSONArray();
			JSONObject paging =new JSONObject();
			paging.put("pageBar", 	pageBar);
			paging.put("cPage", 	cPage);
			jsonArr.add(paging);
			for(Movie m : list) {
				JSONObject jsonobj =new JSONObject();
				jsonobj.put("mid", 		m.getMid());
				jsonobj.put("name", 	m.getName());
				jsonobj.put("ename", 	m.getEname());
				jsonobj.put("grade",	m.getGrade());
				jsonobj.put("runtime",	m.getRuntime());
				jsonobj.put("director",	m.getDirector());
				jsonobj.put("actor", 	m.getActor());
				jsonobj.put("story", 	m.getStory());
				jsonobj.put("reldate", 	m.getReldate());
				jsonobj.put("poster", 	m.getPoster());
				jsonobj.put("subimg", 	m.getSubimg());
				jsonobj.put("trailer", 	m.getTrailer());
				jsonobj.put("regdate", 	m.getRegdate());
				jsonArr.add(jsonobj);
			}
			
	
				
	
			
			response.setContentType("application/json; charset=utf-8");
			response.getWriter().append(jsonArr.toJSONString());
			
			
			
			
			
			}else {

				
			} 
		}else {
			response.setContentType("text/html; charset=utf-8");
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("/WEB-INF/views/movie/movieList.jsp");
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
