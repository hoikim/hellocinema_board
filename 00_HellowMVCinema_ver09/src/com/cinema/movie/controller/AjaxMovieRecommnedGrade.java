package com.cinema.movie.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.cinema.movie.model.service.MovieService;
import com.cinema.movie.model.vo.MovieData;

/**
 * Servlet implementation class AjaxMovieRecommnedGrade
 */
@WebServlet({ "/AjaxMovieRecommnedGrade", "/movie/recommendGrade" })
public class AjaxMovieRecommnedGrade extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Integer> temp = new ArrayList<>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxMovieRecommnedGrade() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1.한글값 대비 인코딩처리
		request.setCharacterEncoding("utf-8");
		
		String grade = request.getParameter("grade");
		System.out.println(grade);
		
		//3.업무로직
		List<MovieData> list = null;
		MovieData list2= null;
		list = new MovieService().recommendMovieGrade(grade);
		System.out.println("무비 서블릿 " + list);
		
		
	////중복제거/////
		
		if(temp.size() == 0 ){
			int first = (list.get((int) (Math.random()*list.size())).getmId());
			temp.add(first); 
			
			for(int i=0; i<list.size(); i++) {
				if(first==list.get(i).getmId()) {
					list2=list.get(i);
					System.out.println();
				}
			}
			System.out.println("처음 뽑은 mid" + temp.get(0));
			
		}else { 
			int mid= (list.get((int) (Math.random()*list.size())).getmId()); 
			System.out.println("새로 랜덤 값 뽑은 mid" +mid);
			
			
			label : for(int i = 0; i< temp.size(); i++) {  //중복검사:
			
				if(temp.get(i) == mid) {
					mid= (list.get((int) (Math.random()*list.size())).getmId());
					System.out.println("for문 앞에 mid" +mid);
					i=-1;
				}
				System.out.println("if문 바깥에 i" +i);
				if(temp.size()>=list.size()) {
					temp.clear();
					break label;
				}
			}
			temp.add(mid);
			System.out.println("for문 바깥에 temo" +temp);
			for(int i=0; i<list.size(); i++) {
				if(mid==list.get(i).getmId()) {
					list2=(list.get(i));
					System.out.println("중복 제거한 후에 list" +list2);
				}
			}
			
		}
		
		response.setContentType("application/json; charset=utf-8");
		
		new Gson().toJson(list2, response.getWriter());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
