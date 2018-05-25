package com.cinema.movie.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.cinema.movie.model.service.MovieService;
import com.cinema.movie.model.vo.Movie;


/**
 * Servlet implementation class InsertMovie
 */
@WebServlet("/insertmovie.do")
public class InsertMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//1. 정보들 가져오기 
	String data = request.getParameter("data");


	
	
	
	JSONArray array = new JSONArray(data);
	
	
	
	
	
	List<Movie> movieList = new ArrayList<>();
	
	for(Object o : array) {
		JSONObject ob = (JSONObject)o;
		Movie m = new Movie();
		
		//디테일 정보 가져오기
		JSONObject obj = (JSONObject) readJsonFromUrl("http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json?key=430156241533f1d058c603178cc3ca0e&movieCd="+ob.get("movieCd")).get("movieInfoResult");
		System.out.println( ((JSONArray)(ob.get("directors"))).length() );
		System.out.println("이건 개별로 가져온거 " + obj);
		obj = (JSONObject) obj.get("movieInfo");
		
		String mid = (String) obj.get("movieCd");
		String name = (String) obj.get("movieNm");
		String ename = (String) obj.get("movieNmEn");
		String time = (String) obj.get("showTm");
		String prddate =  (String) obj.get("prdtYear");
		String reldate = (String)obj.get("openDt");
		String prdtStatNm = (String) obj.get("prdtStatNm");
		String typeNm = (String) obj.get("typeNm");
		
		
		JSONArray nations =((JSONArray)obj.get("nations"));//
		JSONArray genres = ((JSONArray)obj.get("genres")); //
		JSONArray directors = ((JSONArray)obj.get("directors"));//
		JSONArray actors  = ((JSONArray)obj.get("actors"));//
		JSONArray showTypes = ((JSONArray)obj.get("showTypes"));//
		JSONArray companys = ((JSONArray)obj.get("companys"));//
		JSONArray audits  = ((JSONArray)obj.get("audits"));//
		JSONArray staffs = ((JSONArray)obj.get("staffs"));//
		
		JSONArray arrays = new JSONArray();
		
		
		arrays.put(nations);
		arrays.put(genres);
		arrays.put(directors);
		arrays.put(actors);
		arrays.put(showTypes);
		arrays.put(companys);
		arrays.put(audits);
		arrays.put(staffs);
//		
//		
//		for(int i=0; i<arrays.length(); i++) {
//			JSONArray type = ((JSONArray) arrays.get(i));
//			if(type.length() > 1) {
//				for(int j =0; j< type.length(); j++) {
//					Iterator itr = ((JSONObject)type.get(j)).keys();
//					while(itr.hasNext()) {
//						System.out.println(   ((JSONObject)type.get(j)).get(itr.next().toString())  );
//					}
//				}
//			}
//		}
		
		
		String nation = ""; 
		if(nations.length() > 0) {
			for(int i=0; i< nations.length(); i++) {
				if(i!=0) {
					nation += ",";
					nation += ((JSONObject) nations.get(i)).get("nationNm");
				} else {
					nation += ((JSONObject) nations.get(i)).get("nationNm");	
				}
			}
			System.out.println(nation);
		}
		
		String genre = ""; 
		if(genres.length() > 0) {
			for(int i=0; i< genres.length(); i++) {
				if(i!=0) {
					genre += ",";
					genre += ((JSONObject) genres.get(i)).get("genreNm");
				} else {
					genre += ((JSONObject) genres.get(i)).get("genreNm");
				}
			}
			System.out.println(genre);
		}
		
		String director = ""; 
		if(directors.length() > 0) {
			for(int i=0; i< directors.length(); i++) {
				if(i!=0) {
					director += ",";
					director += ((JSONObject) directors.get(i)).get("peopleNm");
				} else {
					director += ((JSONObject) directors.get(i)).get("peopleNm");
				}
			}
			System.out.println(genre);
		}
		
		String actor = ""; 
		if(actors.length() > 0) {
			for(int i=0; i< actors.length(); i++) {
				if(i!=0) {
					actor += ",";
					actor += ((JSONObject) actors.get(i)).get("peopleNm");
				} else {
					actor += ((JSONObject) actors.get(i)).get("peopleNm");
				}
			}
			System.out.println(actor);
		}
		String showType = "";
		if(showTypes.length() > 0) {
			for(int i=0; i< showTypes.length(); i++) {
				if(i!=0) {
					showType += ",";
					showType += ((JSONObject) showTypes.get(i)).get("showTypeNm");
				} else {
					showType += ((JSONObject) showTypes.get(i)).get("showTypeNm");
				}
			}
			System.out.println(showType);
			
		}
		String company = "";
		if(companys.length() > 0) {
			for(int i=0; i< companys.length(); i++) {
				if(i!=0) {
					company += ",";
					company += ((JSONObject) companys.get(i)).get("companyNm");
				} else {
					company += ((JSONObject) companys.get(i)).get("companyNm");
				}
			}
			System.out.println(company);
			
			
			
		}
		String audit = "";
		if(audits.length() > 0) {
			for(int i=0; i< audits.length(); i++) {
				if(i!=0) {
					audit += ",";
					audit += ((JSONObject) audits.get(i)).get("watchGradeNm");
				} else {
					audit += ((JSONObject) audits.get(i)).get("watchGradeNm");
				}
			}
			System.out.println(audit);
		}
		String staff = "";
		if(staffs.length() > 0) {
			for(int i=0; i< staffs.length(); i++) {
				if(i!=0) {
					staff += ",";
					staff += ((JSONObject) staffs.get(i)).get("peopleNm");
				} else {
					staff += ((JSONObject) staffs.get(i)).get("peopleNm");
				}
			}
			System.out.println(staff);
		}
		m.setMid(mid);
		m.setName(name);
		m.setEname(ename);
		//m.setRuntime(time);
		m.setReldate(reldate);
		//m.setPrddate(prddate);
		m.setGrade(audit);
		m.setGenre(genre);
		m.setActor(actor);
		m.setDirector(director);
		m.setStaff(staff);
		m.setType(showType);
		
		movieList.add(m);
	}
		
	
	for(Movie m : movieList) {
		int result = new MovieService().autoInsertMoviesData(m);
		System.out.println("결과 " + result);
	}
	

	
	//request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	private String jsonReadAll(Reader reader) throws IOException {

		StringBuilder sb = new StringBuilder();

		int cp;

		while ((cp = reader.read()) != -1) {

			sb.append((char) cp);

		}

		return sb.toString();

	}

	private JSONObject readJsonFromUrl(String url) throws IOException, JSONException {

		InputStream is = new URL(url).openStream();

		try {

		BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));

			String jsonText = jsonReadAll(rd);

			JSONObject json  = new JSONObject(jsonText);

			return json;

		} finally {

			is.close();

		}

	}
	
}
