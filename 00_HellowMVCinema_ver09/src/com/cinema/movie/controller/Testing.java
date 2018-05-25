package com.cinema.movie.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.cinema.common.MyFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;


/**
 * Servlet implementation class Testing
 */
@WebServlet("/testing")
public class Testing extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.파일업로드 로직
		//1.a multipart/form-data 여부 검사
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
		
 
		String name = multiReq.getParameter("name");
		System.out.println("아에이오우 아에이오우"+name);
		String renamedFileName = multiReq.getFilesystemName("file"); //실제시스템에 저장된 파일명
		String originalFileName = multiReq.getOriginalFileName("file"); //사용자가 업로드한 파일명
		
		System.out.println(renamedFileName);
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
