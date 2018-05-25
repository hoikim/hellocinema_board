package com.cinema.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.cinema.common.MyFileRenamePolicy;
import com.cinema.movie.model.service.MovieService;
import com.cinema.movie.model.vo.Movie;
import com.google.gson.Gson;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class ManagerMovie
 */
@WebServlet("/manager/moviemultipart")
public class ManagerMovieMultipart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
				if(!ServletFileUpload.isMultipartContent(request)) {
					request.setAttribute("msg", "게시판 작성오류[form:enctype]");
					request.setAttribute("loc","/board/boardList");
					System.out.println("에러-----------------------------------enc");
					return;
				}
				
				System.out.println("멀티파트 테스트중");
				//1.b saveDirectory
				String saveDirectory = getServletContext().getRealPath("/upload/movie");
				System.out.println("saveDirectory="+saveDirectory);
				
				//1.c maxPostSize
				int maxPostSize = 1024 * 1024 * 10;
				
				//1.d MultipartRequest객체생성 ==> 파일 rename정책 커스터마이징
				MultipartRequest multiReq = new MultipartRequest(request, saveDirectory, maxPostSize, "UTF-8", new MyFileRenamePolicy());
				
				//2. 파라미터 가져오기
				String mid = multiReq.getParameter("mid");
				String name = multiReq.getParameter("name");
				String ename = multiReq.getParameter("ename");
				String grade = multiReq.getParameter("grade");
				Integer runtime = Integer.parseInt(multiReq.getParameter("time"));
				String reldate = multiReq.getParameter("reldate");
				String genre = multiReq.getParameter("genre");
				String actor = multiReq.getParameter("actor");
				String director = multiReq.getParameter("director");
				String staff = multiReq.getParameter("staff");
				String story = multiReq.getParameter("story");
				String trailer = multiReq.getParameter("trailer");
				String renamedFileName = multiReq.getFilesystemName("file"); //실제시스템에 저장된 파일명
				String originalFileName = multiReq.getOriginalFileName("file"); //사용자가 업로드한 파일명
				
				String subimgName = multiReq.getFilesystemName("subfile");
				
				Movie movie = new Movie();
				
				movie.setMid(mid);
				movie.setName(name);
				movie.setEname(ename);
				movie.setGrade(grade);
				movie.setRuntime(runtime);
				movie.setReldate(reldate);
				movie.setGenre(genre);
				movie.setActor(actor);
				movie.setDirector(director);
				movie.setStaff(staff);
				movie.setStory(story);
				movie.setTrailer(trailer);
				if(mid != null && renamedFileName == null) {
					movie.setPoster(new MovieService().showMovieDetail(mid).getPoster());
				}else {
					movie.setPoster(renamedFileName);
				}
				movie.setSubimg(subimgName);
				movie.setStatus("Y");
				
				System.out.println("무비업로드 객체  : " + movie);
				int result = new MovieService().movieProc(movie);

//				String view = "/WEB-INF/views/manager/movie";
//				request.getRequestDispatcher(view).forward(request, response);
				
				response.setContentType("application/json; charset=utf-8");
				new Gson().toJson(result, response.getWriter());
				
			}
		
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
