package com.cinema.admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cinema.admin.model.vo.Manager;
import com.cinema.price.model.service.PriceService;
import com.cinema.price.model.vo.Price;
import com.cinema.seat.model.service.SeatService;
import com.cinema.seat.model.vo.Seat;
import com.google.gson.Gson;

/**
 * Servlet implementation class ManagerPrice
 */
@WebServlet("/manager/price")
public class ManagerPrice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerPrice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if(request.getParameter("type") != null) {
			String type = request.getParameter("type");
			Manager m = (Manager) request.getSession().getAttribute("managerSession");
			System.out.println(type);

			if(type.equals("setPrice")) {
				
				Price price = new Price();
				
				int result = new PriceService().setPrice(price);
				
				
			} else if(type.equals("getPrice")) {
				
				List<Price> pList = new PriceService().getPrice();
				
				response.setContentType("application/json; charset=utf-8");
				new Gson().toJson(pList, response.getWriter());
				
			} else if(type.equals("getPriceETC")) {
				
				String etc = request.getParameter("etc");
				Price price =  new PriceService().getPriceETC(etc);
				
				response.setContentType("application/json; charset=utf-8");
				new Gson().toJson(price, response.getWriter());
				
			}else if(type.equals("modifyPrice")) {
				
			}else if(type.equals("deletePrice")) {
				
			}
		}else {
			
			String view ="/WEB-INF/views/manager/price.jsp";
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
