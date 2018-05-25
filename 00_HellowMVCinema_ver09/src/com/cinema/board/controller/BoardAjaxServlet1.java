package com.cinema.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.cinema.board.model.service.BoardService;
import com.cinema.board.model.vo.Board;
import com.google.gson.Gson;

/**
 * Servlet implementation class BoardAjaxServlet1
 */
@WebServlet("/board/boardAjax1.do")
public class BoardAjaxServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardAjaxServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int cPage;
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		} catch (NumberFormatException e) {
			//cPage 파라미터가 값이 없거나, 부정 입력된 경우 대비 
			cPage=1;
		}
		System.out.println("cPage="+cPage);
		
		String type = request.getParameter("listType");
		List<Board> boardList= null;
		JSONArray jsonArr = new JSONArray();
		if(type.equals("noticeList")) {
			//boardList = new BoardService().selectNoticeBoard();
			
			//공지사항 전체 개수
			int noticeCnt = new BoardService().selectNoticeCnt();
			
			//한 페이지의 공지사항 개수
			int onePage = 5;
			
			//전체 페이지 개수
			int totalPage = (int)Math.ceil((double)noticeCnt/onePage);
			
			//페이징한 공지사항 가져오기
			boardList = new BoardService().selectNoticeBoard(cPage, onePage);
			System.out.println(boardList);
			
			//메뉴바 만들기s
			//메뉴바에 표시될 개수
			String pageBar = "";
			int pageBarSize = 5;
			
			//시작 페이지
			//cPage=1 -> 1
			//cPage=2 -> 6
			//cPage=3 -> 11
			int pageNo = ((cPage-1)/pageBarSize)*pageBarSize+1;
			
			//종료 페이지
			int pageEnd = pageNo + pageBarSize-1;
			
			//[이전]
			if(pageNo == 1) {
				
			} else {
				pageBar += "<a href="+request.getContextPath()+"/board/boardView?cPage="+(pageNo-1)+" id='"+(pageNo-1)+"' ><span>이전</span></a>";
			}
			//[pageNo]
			while(pageNo <= pageEnd && pageNo <= totalPage) {
				if(pageNo==cPage) {
					pageBar += "<span value='"+pageNo+"'>"+pageNo+"</span>";				
				} else {
					pageBar += "<a href="+request.getContextPath()+"/board/boardView?cPage="+pageNo+" id='"+pageNo+"' ><span value='"+pageNo+"'>"+pageNo + "</span></a>";
				}
				pageNo++;
			}
			
			//[다음]
			if(pageNo > totalPage) {
				
			} else {
				pageBar += "<a href="+request.getContextPath()+"/board/boardView?cPage="+(pageNo)+" id='"+pageNo+"' ><span>다음</span></a>";
			}
			
			for(Board b : boardList) {
				JSONObject jsonObj = new JSONObject();
				jsonObj.put("bdid", b.getBdid());
				jsonObj.put("content", b.getContent());
				jsonObj.put("img", b.getImg());
				jsonObj.put("regdate", b.getRegdate());
				jsonObj.put("tinfo", b.getTinfo());
				jsonObj.put("title", b.getTitle());
				jsonObj.put("type", b.getType());
				jsonObj.put("cPage",cPage);
				jsonObj.put("pageBar",pageBar);
				jsonArr.add(jsonObj);
			}
			
			/*JSONObject jsonObjPage = new JSONObject();
			jsonObjPage.put("cPage",cPage);
			jsonObjPage.put("pageBar",pageBar);
			jsonArr.add(jsonObjPage);*/
		}
		if(type.equals("eventList")) {
			String status = request.getParameter("status");
			
			if(status.equals("present")) {
				String pPage = request.getParameter("pPage");
				boardList = new BoardService().selectEventBoardPresent(pPage);				
			}
			if(status.equals("last")) {
				String lPage = request.getParameter("lPage");
				boardList = new BoardService().selectEventBoardLast(lPage);				
			}
			
			int cnt = 0;
			for(Board b : boardList) {
				JSONObject jsonObj = new JSONObject();
				jsonObj.put("bdid", b.getBdid());
				jsonObj.put("content", b.getContent());
				jsonObj.put("img", b.getImg());
				jsonObj.put("regdate", b.getRegdate());
				jsonObj.put("tinfo", b.getTinfo());
				jsonObj.put("title", b.getTitle());
				jsonObj.put("type", b.getType());
				jsonObj.put("endterm", b.getEndterm());
				jsonObj.put("startterm", b.getStartterm());
				jsonObj.put("order", cnt);
				cnt++;
				jsonArr.add(jsonObj);
			}
		}
		
		response.setContentType("application/json; charset=utf-8");
		new Gson().toJson(jsonArr, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
