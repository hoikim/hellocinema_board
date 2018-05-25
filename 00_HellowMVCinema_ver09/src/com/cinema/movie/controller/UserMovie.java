package com.cinema.movie.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cinema.admin.model.vo.Manager;
import com.cinema.movie.model.service.MovieService;
import com.cinema.movie.model.vo.Movie;
import com.google.gson.Gson;

/**
 * Servlet implementation class Movie
 */
@WebServlet("/movie.do")
public class UserMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			List<Movie> mList = new MovieService().showMovies();
			response.setContentType("application/json; charset=utf-8");
			new Gson().toJson(mList, response.getWriter());
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
