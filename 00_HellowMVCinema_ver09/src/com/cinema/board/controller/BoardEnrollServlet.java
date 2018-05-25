package com.cinema.board.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.cinema.board.model.service.BoardService;
import com.cinema.board.model.vo.Board;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class BoardEnrollServlet
 */
@WebServlet("/board/boardEnroll")
public class BoardEnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardEnrollServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "공지사항작성오류[form:enctype]");
			request.setAttribute("loc", "/board/boardView");
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
			return;
		}
		
		String saveDirectory = getServletContext().getRealPath("/upload/board");
		System.out.println("saveDirectory="+saveDirectory);
		
		int maxPostSize = 1024*1024*10;
		
		MultipartRequest multiReq = new MultipartRequest(request, saveDirectory, maxPostSize, "UTF-8", new DefaultFileRenamePolicy());
		
		int bdid = 0;
		String title = multiReq.getParameter("title");
		String filePath = null;
		String type = multiReq.getParameter("type");
		String local = null;
		String theater = null;
		String content = multiReq.getParameter("content");
		String startterm= null;
		String endterm= null;
		String view = "/WEB-INF/views/common/msg.jsp";
		String old_file = null;
		
		if(type.equals("notice")) {
			local = multiReq.getParameter("local");
			theater = multiReq.getParameter("theater");
			filePath = multiReq.getFilesystemName("up_notice_file");
			Board b = new Board();
			b.setContent(content);
			b.setImg(filePath);
			b.setTinfo("전체");
			if(!"".equals(local) && !"".equals(theater)) {
				b.setTinfo(local+"/"+theater);				
			} 
			if("".equals(theater)) {
				b.setTinfo(local);		
			}
			if(local==null && theater==null) {
				b.setTinfo("전체");
			}
			b.setTitle(title);
			b.setType(type);
			
			
			int result = new BoardService().insertNotice(b);
			if(result>0) {
				request.setAttribute("msg", "공지사항이 작성 되었습니다.");
				request.setAttribute("loc", "/board/boardView");
			} else {
				request.setAttribute("msg", "공지사항이 작성 되지 않았습니다.");
				request.setAttribute("loc", "/board/boardView");
			}
		}
		if(type.equals("event")) {
			filePath = multiReq.getFilesystemName("up_event_file");
			endterm = multiReq.getParameter("endterm");
			startterm = multiReq.getParameter("startterm");
			Board b = new Board();
			b.setContent(content);
			b.setEndterm(Date.valueOf(endterm));
			b.setStartterm(Date.valueOf(startterm));
			b.setImg(filePath);
			b.setTitle(title);
			b.setType(type);
			int result =new BoardService().insertEvent(b);
			if(result>0) {
				request.setAttribute("msg", "이벤트가 작성 되었습니다.");
				request.setAttribute("loc", "/board/boardView");	
			} else {
				request.setAttribute("msg", "이벤트가 작성 되지 않았습니다.");
				request.setAttribute("loc", "/board/boardView");
			}
		}
		if(type.equals("updateNotice")) {
			local = multiReq.getParameter("local");
			theater = multiReq.getParameter("theater");
			filePath = multiReq.getFilesystemName("up-notice-file");
			bdid = Integer.parseInt(multiReq.getParameter("bdid"));
			old_file = multiReq.getParameter("old_file");
			System.out.println("확인 : " + filePath);
			System.out.println("확인 : " + old_file);
			//실제 업로드된 파일 존재 여부
			File f = multiReq.getFile("up-notice-file");
			//f의 null여부와 파일 사이즈를 체크
			if(f!=null && f.length()>0) {
				//첨부한 파일이 있는 경우, 기존 파일은 삭제 처리함.
				File delFile = new File(saveDirectory+"/"+old_file);
				boolean bool = delFile.delete();
				System.out.println(bool?"파일 삭제 성공!!!":"파일삭제실패!");
			} else {
				//첨부한 파일이 없는 경우
				filePath = old_file;
			}
			System.out.println("확인 : " + filePath);
			
			Board b = new Board();
			b.setBdid(bdid);
			b.setContent(content);
			b.setImg(filePath);
			b.setImg(filePath);
			b.setTinfo("전체");
			if(!"".equals(local) && !"".equals(theater)) {
				b.setTinfo(local+"/"+theater);				
			}
			if("".equals(theater)) {
				b.setTinfo(local);		
			}
			if(local==null && theater==null) {
				b.setTinfo("전체");
			}
			b.setTitle(title);
			b.setType("notice");
			
			int result = new BoardService().updateNotice(b);
			if(result>0) {
				request.setAttribute("msg", "공지사항이 수정 되었습니다.");
				request.setAttribute("loc", "/board/boardDetail?bdid="+bdid);
			} else {
				request.setAttribute("msg", "공지사항이 수정 되지 않았습니다.");
				request.setAttribute("loc", "/board/boardDetail?bdid="+bdid);
			}
		}
		if(type.equals("updateEvent")) {
			filePath = multiReq.getFilesystemName("up-notice-file");
			bdid = Integer.parseInt(multiReq.getParameter("bdid"));
			endterm = multiReq.getParameter("endterm");
			startterm = multiReq.getParameter("startterm");
			old_file = multiReq.getParameter("old_file");
			System.out.println(startterm);
			System.out.println(endterm);
			//실제 업로드된 파일 존재 여부
			File f = multiReq.getFile("up-notice-file");
			//f의 null여부와 파일 사이즈를 체크
			if(f!=null && f.length()>0) {
				//첨부한 파일이 있는 경우, 기존 파일은 삭제 처리함.
				File delFile = new File(saveDirectory+"/"+old_file);
				boolean bool = delFile.delete();
				System.out.println(bool?"파일 삭제 성공!!!":"파일삭제실패!");
			} else {
				//첨부한 파일이 없는 경우
				filePath = old_file;
			}
			System.out.println("확인 : " + filePath);
			
			Board b = new Board();
			b.setBdid(bdid);
			b.setContent(content);
			b.setImg(filePath);
			b.setTitle(title);
			b.setType("event");
			b.setStartterm(Date.valueOf(startterm));
			b.setEndterm(Date.valueOf(endterm));
			
			int result = new BoardService().updateNotice(b);
			
			if(result>0) {
				request.setAttribute("msg", "이벤트가 수정 되었습니다.");
				request.setAttribute("loc", "/board/boardView");
			} else {
				request.setAttribute("msg", "이벤트가 수정 되지 않았습니다.");
				request.setAttribute("loc", "/board/boardView");
			}
		}
		
		RequestDispatcher reqDispatcher = request.getRequestDispatcher(view);
		reqDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
