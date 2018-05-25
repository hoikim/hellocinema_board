package com.cinema.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Calendar;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.cinema.admin.model.vo.Manager;
import com.cinema.room.model.service.RoomService;
import com.cinema.room.model.vo.Room;
import com.cinema.schedule.model.service.ScheduleService;
import com.cinema.schedule.model.vo.Schedule;
import com.cinema.seat.model.service.SeatService;
import com.cinema.seat.model.vo.Seat;
import com.google.gson.Gson;

/**
 * Servlet implementation class ManagerSchedule
 */
@WebServlet("/manager/schedule")
public class ManagerSchedule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if(request.getParameter("type") != null) {
			String type = request.getParameter("type");
			Manager m = (Manager) request.getSession().getAttribute("managerSession");
			if(type.equals("selectSchedule")) {
				if(m.getId() != null) {
					Map<Integer, Seat> seatListMap = new SeatService().seatListMap(m.getTid());
					response.setContentType("application/json; charset=utf-8");
					
					JSONObject json = new JSONObject();
					json.put("seat", seatListMap);
					//new Gson().toJson(json, response.getWriter());
					
					
					System.out.println(json);
					PrintWriter out =  response.getWriter();
					out.println(json);
					

				}
			}else if(type.equals("insertSchedule")) {
				
				System.out.println("여기는 insertSchedule 로 들어온겁니다.");
	/*			#  1       2        3        4           5         6         7         8
				#SHID     RID      MID      SEAT       LSEAT      TIME    ENDTIME    REGDATE
				#NUMBER   NUMBER   NUMBER   VARCHAR    VARCHAR    DATE    DATE       DATE		*/					
				int rid = Integer.parseInt(request.getParameter("rid"));
				int mid = Integer.parseInt(request.getParameter("mid"));
				//int lseat = Integer.parseInt(request.getParameter("lseat"));
				String seat = request.getParameter("seat");
				String time = request.getParameter("time");
				String endtime = request.getParameter("endtime");
				

				Schedule sch = new Schedule();
				sch.setRid(rid);
				sch.setMid(mid);
				//sch.setLseat(lseat);
				sch.setSeat(seat);
				sch.setTime(time);
				sch.setEndtime(endtime);
				
				
				System.out.println(sch);
				
				int result = new ScheduleService().insertSchedule(sch);
				
				response.setContentType("application/json; charset=utf-8");
				new Gson().toJson(result, response.getWriter());
				
				
				
			}
			
			
		}else {
			System.out.println("스케쥴 타입이 없네요 ");
			request.getRequestDispatcher("/WEB-INF/views/manager/schedule.jsp").forward(request, response);;
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
