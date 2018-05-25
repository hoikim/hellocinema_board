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
 * Servlet implementation class SchdulerData
 */
@WebServlet("/schedule")
public class SchdulerData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String query = "";
		
		
		String theaterParameter = request.getParameter("theaters");
		String moviesParameter = request.getParameter("movies");
		String dateParameter = request.getParameter("date");
		
		
		
		if(theaterParameter != null) {
			query ="SELECT SHID, T.TID, R.RID, SID, T.NAME, R.NAME RNAME, R.TYPE RTYPE, M.NAME MNAME, M.GRADE, M.POSTER, (REGEXP_COUNT(SEAT,',')-REGEXP_COUNT(SEAT,',null')-REGEXP_COUNT(SEAT,',0')) SCNT,  REGEXP_COUNT(SEAT,',1') SLCNT, TO_CHAR(M.RELDATE, 'yyyy-mm-dd hh24') MRELDATE, TO_CHAR(S.TIME, 'yyyy-mm-dd hh24:mi:ss') STIME, TO_CHAR(S.ENDTIME, 'yyyy-mm-dd hh24:mi:ss') SENDTIME, S.SEAT"
			 + " FROM THEATER T, ROOM R, SCHEDULE S, MOVIEDATA M WHERE T.TID = R.TID AND R.RID = S.RID AND M.MID = S.MID AND R.TID IN("+theaterParameter+") AND S.MID IN("+moviesParameter+") AND TO_CHAR(S.TIME, 'yyyy-mm-dd hh24:mi:ss') LIKE '%"+dateParameter+"%' ORDER BY S.TIME";
			System.out.println(query);
			//List<Schedule> list = new ScheduleService().selectScheduleQuery(query);
			List<Map<String, String>> scList = new ScheduleService().selectScheduleQueryMap(query);
			
			System.out.println("하하하하하"+scList + scList.size());
			response.setContentType("application/json; charset=utf-8");
			new Gson().toJson(scList, response.getWriter());
		}else {
			response.setContentType("application/json; charset=utf-8");
			new Gson().toJson("test", response.getWriter());
		
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
