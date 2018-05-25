package com.cinema.review.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.cinema.review.model.service.ReviewService;
import com.cinema.review.model.vo.Review;

/**
 * Servlet implementation class ReviewDeleteServlet
 */
@WebServlet("/review/reviewDelete.do")
public class ReviewDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
		int rvid = Integer.parseInt(request.getParameter("rvid"));
	    int mid = Integer.parseInt(request.getParameter("mid"));
	
		int result = new ReviewService().deleteReview(rvid);
		
		//1. 파라미터 변수에 담기
		int cPage;
		try{
			cPage=Integer.parseInt(request.getParameter("cPage"));
		}catch(NumberFormatException e) {
			cPage=1;
			
		}
		//2. 비지니스로직
		int numPerPage =5;
		//2.1 전체 리뷰수
		int totalReview = new ReviewService().selectReviewCount(mid);
		//(공식1) totalPage
		//100건이면, totalPage = 20; 101건이면, totalPage=21;
//					int totalPage= totalMember%numPerPage==0? totalMember/numPerPage:(totalMember/numPerPage)+1;
//					int totalPage = (Integer)(totalMember / numPerPage) + (totalMember % numPerPage); //팀장님.
		int totalPage = (int)Math.ceil((double)totalReview/numPerPage);
		
		
		//2.2 페이징된 회원리스트 가져오기
		List<Review> list = new ReviewService().selectReview(cPage,numPerPage,mid);
		System.out.println("list@ReviewDeleteServlet="+list);
		
		//2.3 페이징바 만들기
		String pageBar="";
		int pageBarSize=5; //페이지바 페이지 갯수
		int pageNo=0;
		
		//(공식3) 시작페이지 구하기
		pageNo = (int)(Math.ceil(((double)cPage/pageBarSize)-1)*pageBarSize)+1;
		pageNo = ((cPage-1)/pageBarSize)*pageBarSize+1;
		
		//종료페이지 no 
		int pageEnd= pageNo+pageBarSize-1; //5,10,15,...

		//[이전]
		if(pageNo == 1) {
			
		}else {
			pageBar += "<a style='cursor:pointer' onclick=fn_showReviewList("+(pageNo-1)+","+mid+")><span>[이전]</span></a>";
			
		}
		//[pageNo]
		while(pageNo <= pageEnd && pageNo <=totalPage) {
			if(pageNo==cPage) {
				pageBar +="<span>"+pageNo+"</span>";
			}else {
				
				pageBar +="<a style='cursor:pointer' onclick=fn_showReviewList("+pageNo+","+mid+")><span>"+pageNo+"</span></a>";
			}
			
			pageNo++;
		}
		
		//[다음]
		if(pageNo > totalPage) {
			
		}else {
			pageBar += "<a style='cursor:pointer' onclick=fn_showReviewList("+pageNo+","+mid+")><span>[다음]</span></a>"; 
			//while문에서 이미 하나 큰 값이 되었음~
		}

	
		JSONArray jsonArr=new JSONArray();
		if(list.isEmpty()) {
			jsonArr.add("null");
			
			
		}
		else {
			for(Review r : list) {
				JSONObject jsonobj =new JSONObject();
				jsonobj.put("mid", r.getMid());
				jsonobj.put("usid", r.getUsid());
				jsonobj.put("rvid", r.getRvid());
				jsonobj.put("grade",r.getStarScore());
				jsonobj.put("content",r.getContent() );
				jsonobj.put("regdate", r.getRegDate().toString());
				jsonobj.put("id", r.getId());
				jsonobj.put("cPage", cPage);
				jsonobj.put("pageBar", pageBar);
				jsonArr.add(jsonobj);
				System.out.println("review"+r);
			}
			
		}
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().append(jsonArr.toJSONString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
