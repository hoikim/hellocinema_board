package com.cinema.price.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cinema.admin.model.vo.Manager;
import com.cinema.price.model.service.PriceService;
import com.cinema.price.model.vo.Price;
import com.google.gson.Gson;

/**
 * Servlet implementation class PriceFront
 */
@WebServlet("/priceFront")
public class PriceFront extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("type") != null) {
			String type = request.getParameter("type");
			
			if(type.equals("kind")) {
				String[] persons = request.getParameterValues("persons[]");
				String kind = request.getParameter("kind");
				
				
				List<Price> pList = new PriceService().getPriceKind(kind);
				
				
				System.out.println("ㅇ"+persons);
				System.out.println("ㅇ"+pList);
				
				int adultPrice = 0;
				int teenPrice= 0;
				int childPrice = 0;
				int oldPrice =0;
				int totalPrice=0;
				
				for(Price p : pList) {
					if(p.getName().equals("adult")) {
						adultPrice = Integer.parseInt(persons[0]) * p.getPrice();
					}else if(p.getName().equals("teen")) {
						teenPrice = Integer.parseInt(persons[1]) * p.getPrice();
					}else if(p.getName().equals("child")) {
						childPrice = Integer.parseInt(persons[2]) * p.getPrice();
					}else if(p.getName().equals("old")) {
						oldPrice = Integer.parseInt(persons[3]) * p.getPrice();
					}
				}
				totalPrice = adultPrice+teenPrice+childPrice+oldPrice;
//				System.out.println(adultPrice);
//				System.out.println(teenPrice);
//				System.out.println(childPrice);
//				System.out.println(oldPrice);
				System.out.println(adultPrice+teenPrice+childPrice+oldPrice);
//				
				response.setContentType("application/json; charset=utf-8");
				new Gson().toJson(totalPrice, response.getWriter());
				
			} else if(type.equals("-----")) {
				
				
			} 
		}else {
			
			String view ="/WEB-INF/views/manager/msg.jsp";
			request.getRequestDispatcher(view).forward(request, response);
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
