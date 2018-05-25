package com.cinema.movie.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cinema.movie.model.service.MovieService;
import com.cinema.movie.model.vo.MovieData;
import com.google.gson.Gson;


/**
 * Servlet implementation class AjaxMovieRecommendActor
 */
@WebServlet({ "/AjaxMovieRecommendActor", "/movie/actor" })
public class AjaxMovieRecommendActor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Integer> temp = new ArrayList<>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxMovieRecommendActor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1.한글값 대비 인코딩처리
			request.setCharacterEncoding("utf-8");
			//response.setContentType("text/csv; charset=utf-8");
			
			
			String actor = request.getParameter("actor");
			System.out.println(actor);
			
			
			//3.업무로직
			List<MovieData> list = null;
			MovieData list2= null;

			list = new MovieService().recommendMovieActor(actor);
			
			
		////중복제거/////
			
		if(list.size()>0) {
			
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
				
		//////////////////// 두번째 클릭부터 중복제거  /////////////////////		
				
			}else {
				int mid= (list.get((int) (Math.random()*list.size())).getmId()); 
				System.out.println("새로 랜덤 값 뽑은 mid" +mid);
				
				label : for(int i = 0; i< temp.size(); i++) {  //중복검사:
					//System.out.println("이건 희운이  +"+temp.get(i));
					
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
