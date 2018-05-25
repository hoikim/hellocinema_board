package com.cinema.movie.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cinema.movie.model.service.MovieService;
import com.cinema.movie.model.vo.Movie;

/**
 * Servlet implementation class SingleMovieInsert
 */
@WebServlet("/singleMovieInsert")
public class SingleMovieInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		private String mid; //영화코드
//		private String name; //영화이름
//		private String ename; //영문이름
//		private String grade; //등급
//		private String type;
//		private String time; //러닝타임
//		private Date reldate; //개봉년월일
//		private String prddate; //제작년월일
//		private String genre; // *장르코드  : 장르테이블 참조 
//		private String actor; //연기자 
//		private String director; //감독
//		private String staff; //staff
//		private String story; //줄거리 내용
//		private String poster; //포스터 주소
//		private String subimg; //서브이미지 주소
//		private String trailer; //영상주소
//		private Date regdate; //등록일자
//		
		
		String name      =  request.getParameter("name");
		String ename     =  request.getParameter("ename");
		String grade     =  request.getParameter("grade");
		String time      =  request.getParameter("time");
		String type      =  request.getParameter("type");
		Date reldate	 =  null;
		Date prddate     =  null;
		String genre     =  request.getParameter("genre");
		String actor     =  request.getParameter("actor");
		String director  =  request.getParameter("director");
		String staff     =  request.getParameter("staff");
		String story     =  request.getParameter("story");
		String poster    =  request.getParameter("poster");
		String subimg    =  request.getParameter("subimg");
		String trailer   =  request.getParameter("trailer");
		String status   =  request.getParameter("status");

		
		
		if(!request.getParameter("reldate").equals("")){
			//reldate =  new Date(Long.parseLong(request.getParameter("reldate")));
			reldate = Date.valueOf(request.getParameter("reldate"));
		}
		if(!request.getParameter("prddate").equals("")){
			reldate =  new Date(Long.parseLong(request.getParameter("prddate")));
		}
		
		
		
		
		//Movie m = new Movie(name, ename, grade, time, type, reldate, prddate, genre, actor, director, staff, story, poster, subimg, trailer, status);
		
		
//		int result = new MovieService().movieProc(m);
//				
//		
//		
//		System.out.println(name);
//		
//		System.out.println(m);
// 
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
