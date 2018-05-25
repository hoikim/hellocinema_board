package com.cinema.schedule.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cinema.schedule.model.service.ScheduleService;
import com.cinema.schedule.model.vo.Schedule;
import com.google.gson.Gson;

/**
 * Servlet implementation class SchedulerCommon
 */
@WebServlet("/schedulerCommon")
public class SchedulerCommon extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String date = request.getParameter("showDate");
		String room = request.getParameter("room");
		
		System.out.println(date+"날짜");
		System.out.println(room+"방번호");
		List<Schedule> list = new ScheduleService().seletcScheduleDateList(date, room);
		
		response.setContentType("application/json; charset=utf-8");
		new Gson().toJson(list, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
