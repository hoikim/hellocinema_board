package com.cinema.movie.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDo
 */
@WebServlet("/test.do")
public class TestDo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static StringBuilder sb;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("test");
		
		
		String clientId = "k0A70wc908pjxWH9k3fi";
		String clientSecret = "Xnb73Ig0An";
		int display = 10;
		
		try {
		
		String text = URLEncoder.encode("아트메가", "utf-8");
		String apiURL = "https://openapi.naver.com/v1/search/movie.json?query=B";
		URL url = new URL(apiURL);
		
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestProperty("X-Naver-Client-Id", clientId);
        con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
        int responseCode = con.getResponseCode();
        BufferedReader br;
        
        
        if(responseCode == 200) {
        	br = new BufferedReader(new InputStreamReader(con.getInputStream()));

        }else {
        	br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
        }
        sb = new StringBuilder();
        String line;
        
        while((line=br.readLine()) !=null) {
        	sb.append(line+ "\n");
        	
        }
        br.close();
        con.disconnect();
        System.out.println("sbsbs"+sb);

		}catch(Exception e){
			System.out.println(e);
			
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
