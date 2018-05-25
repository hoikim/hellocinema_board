package com.cinema.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.cinema.admin.model.vo.Manager;
@WebFilter("/manager/*")
public class ManagerFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) request).getSession();
		Manager m = (Manager)session.getAttribute("managerSession");
		System.out.println("여기는 매니져의 필터가 적용된 곳입니다.");
		System.out.println(m);
		if(m!=null) {
			System.out.println(m.getName());
		} else {
			System.out.println("메니져가 안담겼으니 팅겨내자");
			request.getRequestDispatcher("/managerLogin").forward(request, response);
			return;
			
		}
		

		
	
		
		
		chain.doFilter(request, response);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
