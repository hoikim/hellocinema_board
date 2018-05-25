package com.cinema.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cinema.admin.model.service.ManagerService;
import com.cinema.admin.model.vo.Manager;
import com.cinema.seat.model.service.SeatService;
import com.cinema.seat.model.vo.Seat;
import com.google.gson.Gson;

/**
 * Servlet implementation class ManagerSeat
 */
@WebServlet("/manager/seat")
public class ManagerSeat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println();
	
		if(request.getParameter("type") != null) {
			String type = request.getParameter("type");
			Manager m = (Manager) request.getSession().getAttribute("managerSession");
			System.out.println(type);

			///////////////////////////////////////시트 셋팅 으로 넘어올경우 ////////////////////////////////////////////
			if(type.equals("seatSeting")) {
				String shape[] = request.getParameterValues("seatTotal[]");
				String name = request.getParameter("name");
				String etc = request.getParameter("etc");
				String shapes ="";
				int tid = m.getTid();
				
				
				for(String s : shape) {
					shapes += s+"|";
				}
				
				
				
				Seat seat = new Seat();
				seat.setShape(shapes);
				seat.setName(name);
				seat.setEtc(etc);
				seat.setTid(tid);
				
				int result = new SeatService().insertList(seat);
				response.setContentType("application/json; charset=utf-8");
				response.getWriter().println(result);
			///////////////////////////////////////시트 리스트로 넘어올경우 ////////////////////////////////////////////
			} else if(type.equals("seatList")) {
				
				if(m!=null) {
				List<Seat> seatList = new SeatService().seatList(m.getTid());
				
				response.setContentType("application/json; charset=utf-8");
				new Gson().toJson(seatList, response.getWriter());
				}else {
					//값이 없어서
					
				}
				///////////////////////////////////////업데이트로 넘어올경우 ////////////////////////////////////////////	
			} else if(type.equals("showSidSeat")) {
				String sid = request.getParameter("sid");
				System.out.println(sid);
				Seat seat = new SeatService().showSidSeat(sid);
				System.out.println(seat);
				response.setContentType("application/json; charset=utf-8");
				new Gson().toJson(seat, response.getWriter());
				///////////////////////////////////////업데이트로 넘어올경우 ////////////////////////////////////////////	
			}  else if(type.equals("updateSeatSeting")) {
				System.out.println("여긴 업데이트입니다.");
				String shape[] = request.getParameterValues("seatTotal[]");
				String name = request.getParameter("name");
				String etc = request.getParameter("etc");
				int sid = Integer.parseInt(request.getParameter("sid"));
				String shapes ="";
				int tid = m.getTid();
				
				for(String s : shape) {
					shapes += s+"|";
				}
				
				
				Seat seat = new Seat();
				seat.setSid(sid);
				seat.setShape(shapes);
				seat.setName(name);
				seat.setEtc(etc);
				seat.setTid(tid);
				
				System.out.println(seat);
				
				int result = new SeatService().updateList(seat);
				response.setContentType("application/json; charset=utf-8");
				response.getWriter().println(result);
			}
		}else {
		
		
		String view ="/WEB-INF/views/manager/seat.jsp";
		request.getRequestDispatcher(view).forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
