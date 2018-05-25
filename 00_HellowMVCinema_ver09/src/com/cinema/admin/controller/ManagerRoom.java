package com.cinema.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Synthesizer;

import org.json.JSONObject;

import com.cinema.admin.model.vo.Manager;
import com.cinema.room.model.service.RoomService;
import com.cinema.room.model.vo.Room;
import com.cinema.seat.model.service.SeatService;
import com.cinema.seat.model.vo.Seat;
import com.cinema.theater.model.service.TheaterService;
import com.cinema.theater.model.vo.Theater;
import com.google.gson.Gson;

/**
 * Servlet implementation class ManagerRoom
 */
@WebServlet("/manager/room")
public class ManagerRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		if(request.getParameter("type") != null) {
			String type = request.getParameter("type");
			Manager m = (Manager) request.getSession().getAttribute("managerSession");
			if(type.equals("seatList")) {
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
			}else if(type.equals("insertRoom")) {
				int tid = Integer.parseInt(request.getParameter("tid"));
				int sid = Integer.parseInt(request.getParameter("sid"));
				String name = request.getParameter("name");
				String roomtype = request.getParameter("roomtype");
				String etc = request.getParameter("etc");
					
				Room room = new Room();
				room.setName(name);
				room.setTid(tid); //시어터 아이디
				room.setType(roomtype);
				room.setEtc(etc); //
				//room.setRid(rid); 
				room.setSid(sid); //시트아이디
				
				
				int result = new RoomService().insertList(room);
				response.setContentType("application/json; charset=utf-8");
				new Gson().toJson(result, response.getWriter());
				
			}else if(type.equals("showRoomList")) {
				int tid = Integer.parseInt(request.getParameter("tid"));
				List<Room> room = new RoomService().showRoomList(tid);
				System.out.println(room);
				
				response.setContentType("application/json; charset=utf-8");
				new Gson().toJson(room, response.getWriter());
			}
			
			
		}else {
			System.out.println("타입이 없네요 ");
			request.getRequestDispatcher("/WEB-INF/views/manager/room.jsp").forward(request, response);
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
