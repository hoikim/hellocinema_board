package com.cinema.admin.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cinema.movie.model.service.MovieService;

/**
 * Servlet implementation class TEST
 */
@WebServlet("/testdo")
public class TEST extends HttpServlet {
	

	@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		long time2 = Long.parseLong(request.getParameter("time2"));
		
		String time = request.getParameter("time");
		
		
		Date.valueOf("2018-05-09 09:30");
		
		System.out.println("시간 :"+time);
		System.out.println("시간2 :"+time2);
		
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		  
		
		java.util.Date d = null;;
		Date dd = null;
		    try {
				d =  f.parse(time);
			    long milliseconds = d.getTime();
			    System.out.println("밀리세컨드"+milliseconds);
			    dd = new Date(milliseconds);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		
		    System.out.println("d   "+d);
		    System.out.println("dd   "+dd);
		    System.out.println("dd.toLocaleString()="+dd.toLocaleString());
		    System.out.println(f.format(dd));
//		System.out.println(d.getHours());
//		System.out.println(d.getMinutes());
		
		
		int result = new MovieService().insertDate(dd);
		
		
		System.out.println("결과"+result);
		
		Calendar cal = Calendar.getInstance();
		
		cal.setTime(d);
		//Hours
		cal.get(Calendar.HOUR);
		//Minute
		cal.get(Calendar.MINUTE);
		
		System.out.println(cal.getTime());
		System.out.println(cal.get(Calendar.HOUR));
		System.out.println(cal.get(Calendar.MINUTE));
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
