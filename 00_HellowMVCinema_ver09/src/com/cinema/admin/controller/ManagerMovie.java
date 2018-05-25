package com.cinema.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.cinema.admin.model.vo.Manager;
import com.cinema.common.MyFileRenamePolicy;
import com.cinema.movie.model.service.MovieService;
import com.cinema.movie.model.vo.Movie;
import com.google.gson.Gson;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class ManagerMovie
 */
@WebServlet("/manager/movie")
public class ManagerMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("type") != null) {
			String type = request.getParameter("type");
			Manager m = (Manager) request.getSession().getAttribute("managerSession");
			System.out.println(type);

			if(type.equals("showMovieListKey")) {
				String keyword = request.getParameter("keyword");
				List<Movie> mList = new MovieService().showMovieskey(keyword);
				
				response.setContentType("application/json; charset=utf-8");
				new Gson().toJson(mList, response.getWriter());
				
			} else if(type.equals("showMovieList")) {
				List<Movie> mList = new MovieService().showMovies();
				
				response.setContentType("application/json; charset=utf-8");
				new Gson().toJson(mList, response.getWriter());
				
			}  else if(type.equals("delMovie")) {
				String mid = request.getParameter("mid");
				int result = new MovieService().deleteMovie(mid);
				
				response.setContentType("application/json; charset=utf-8");
				new Gson().toJson(result, response.getWriter());
				
			}
		}else {
		
		
		String view ="/WEB-INF/views/manager/movie.jsp";
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
