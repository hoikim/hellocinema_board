package com.cinema.movie.model.dao;
import static com.cinema.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.cinema.movie.model.vo.Movie;
import com.cinema.movie.model.vo.MovieData;




public class MovieDAO {
	private Properties prop = new Properties();
	public MovieDAO() {
		URL fileUrl = MovieDAO.class.getResource("/sql/movie/movie-query.properties");
		String fileName = fileUrl.getPath();
		
		try {
			prop.load(new FileReader(fileName));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public int autoInsertMovies(Connection conn, Movie m) {
		int result = 0; 
		
		PreparedStatement pstmt = null;
		String query = prop.getProperty("autoInsertMovies");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getMid());
			pstmt.setString(2, m.getName());
			pstmt.setString(3, m.getPoster());
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				result += autoInsertMoviesData(conn, m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int autoInsertMoviesData(Connection conn, Movie m) {
		int result = 0; 
		
		//mid, name, ename, grade, time, director, actor, genre, 
		//story, reldate, poster, subimg, trailer, regdate : default
		
		PreparedStatement pstmt = null;
		String query = prop.getProperty("autoInsertMoviesData");
		
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getMid());
			pstmt.setString(2, m.getName());
			pstmt.setString(3, m.getEname());
			pstmt.setString(4, m.getGrade());
			pstmt.setInt(5, m.getRuntime());
			pstmt.setString(6, m.getDirector());
			pstmt.setString(7, m.getActor());
			pstmt.setString(8, m.getGenre());
			pstmt.setString(9, m.getStory());
			pstmt.setString(10, m.getReldate());
			pstmt.setString(11, m.getPoster());
			pstmt.setString(12, m.getSubimg());
			pstmt.setString(13, m.getTrailer());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}	
	
	public List<Movie> showMovies(Connection conn) {
		List<Movie> mlist = new ArrayList<>(); 
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		String query = prop.getProperty("showMoviesStatus");

		
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			//mid, name, ename, grade, time, director, actor, genre, 
			//story, reldate, poster, subimg, trailer, regdate : default
			
			while(rs.next()) {
				Movie m = new Movie();
				m.setMid(rs.getString("MID"));
				m.setName(rs.getString("NAME"));
				m.setEname(rs.getString("ENAME"));
				m.setGrade(rs.getString("GRADE"));
				m.setRuntime(rs.getInt("RUNTIME"));
				m.setDirector(rs.getString("DIRECTOR"));
				m.setActor(rs.getString("ACTOR"));
				m.setGenre(rs.getString("GENRE"));
				m.setStory(rs.getString("STORY"));
				m.setReldate(rs.getString("RELDATE"));
				m.setPoster(rs.getString("POSTER"));
				m.setSubimg(rs.getString("SUBIMG"));
				m.setTrailer(rs.getString("TRAILER"));
				m.setRegdate(rs.getString("REGDATE"));
				mlist.add(m);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return mlist;
	}


	public int moviesAllCount(Connection conn) {
		int count=0;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		String query = prop.getProperty("moviesAllCount");

		
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			//mid, name, ename, grade, time, director, actor, genre, 
			//story, reldate, poster, subimg, trailer, regdate : default
			
			if(rs.next()){
				count = rs.getInt("CNT");
			}
			
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} finally {
				close(rs);
				close(pstmt);
				
		}
		return count;
	}


	public List<Movie> showMoivesPaging(Connection conn, int cPage, int numPerPage) {
		List<Movie> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		String query = prop.getProperty("selectMoivesPage");
		System.out.println(query);
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, numPerPage*(cPage-1) + 1);
			pstmt.setInt(2, cPage*numPerPage);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Movie m = new Movie();
				m.setMid(rs.getString("MID"));
				m.setName(rs.getString("NAME"));
				m.setEname(rs.getString("ENAME"));
				m.setGrade(rs.getString("GRADE"));
				m.setRuntime(rs.getInt("RUNTIME"));
				m.setDirector(rs.getString("DIRECTOR"));
				m.setActor(rs.getString("ACTOR"));
				m.setGenre(rs.getString("GENRE"));
				m.setStory(rs.getString("STORY"));
				m.setReldate(rs.getString("RELDATE"));
				m.setPoster(rs.getString("POSTER"));
				m.setSubimg(rs.getString("SUBIMG"));
				m.setTrailer(rs.getString("TRAILER"));
				m.setRegdate(rs.getString("REGDATE"));
				list.add(m);
			}
			
			System.out.println("여기 갯수"+list.size());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		
		return list;
	}


	public int movieProc(Connection conn, Movie m) {
	int result = 0; 
		
		//mid, name, ename, grade, time, director, actor, genre, 
		//story, reldate, poster, subimg, trailer, regdate : default
		
		CallableStatement cstmt =null;
		String query = prop.getProperty("movieProc");
		
		try {
			System.out.println(query);
			//pstmt = conn.prepareStatement(query);
			String mid = (m.getMid() != null ? m.getMid() : "0");
			cstmt = conn.prepareCall(query);
			

			cstmt.setString(1, mid);
			cstmt.setString(2, m.getName());
			cstmt.setString(3, m.getEname());
			cstmt.setString(4, m.getGrade());
			cstmt.setInt(5, m.getRuntime());
			cstmt.setString(6, m.getDirector());
			cstmt.setString(7, m.getActor());
			cstmt.setString(8, m.getGenre());
			cstmt.setString(9, m.getStory());
			cstmt.setString(10, m.getReldate());
			cstmt.setString(11, m.getPoster());
			cstmt.setString(12, m.getSubimg());
			cstmt.setString(13, m.getTrailer());
			cstmt.setString(14, m.getStatus());
			//result = pstmt.executeUpdate();
			result = cstmt.executeUpdate();
			//System.out.println(pstmt);
			//System.out.println(conn.prepareStatement(query).toString());
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(cstmt);
		}
		return result;
	}


	public List<Movie> showMovieskey(Connection conn, String keyword) {
		List<Movie> mlist = new ArrayList<>(); 
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		String query = prop.getProperty("showMovieskey");
		
		System.out.println("keyword");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,  "%"+keyword+"%");
			rs = pstmt.executeQuery();
			//mid, name, ename, grade, time, director, actor, genre, 
			//story, reldate, poster, subimg, trailer, regdate : default
			
			while(rs.next()) {
				Movie m = new Movie();
				m.setMid(rs.getString("MID"));
				m.setName(rs.getString("NAME"));
				m.setEname(rs.getString("ENAME"));
				m.setGrade(rs.getString("GRADE"));
				m.setRuntime(rs.getInt("RUNTIME"));
				m.setDirector(rs.getString("DIRECTOR"));
				m.setActor(rs.getString("ACTOR"));
				m.setGenre(rs.getString("GENRE"));
				m.setStory(rs.getString("STORY"));
				m.setReldate(rs.getString("RELDATE"));
				m.setPoster(rs.getString("POSTER"));
				m.setSubimg(rs.getString("SUBIMG"));
				m.setTrailer(rs.getString("TRAILER"));
				m.setRegdate(rs.getString("REGDATE"));
				mlist.add(m);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			
		}
		
		return mlist;
	}


	public Movie showMovieDetail(Connection conn, String mid) {

		Movie movie = new Movie();
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		String query = prop.getProperty("showMovieDetail");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				movie.setMid(rs.getString("MID"));
				movie.setName(rs.getString("NAME"));
				movie.setEname(rs.getString("ENAME"));
				movie.setGrade(rs.getString("GRADE"));
				movie.setRuntime(rs.getInt("RUNTIME"));
				movie.setDirector(rs.getString("DIRECTOR"));
				movie.setActor(rs.getString("ACTOR"));
				movie.setGenre(rs.getString("GENRE"));
				movie.setStory(rs.getString("STORY"));
				movie.setReldate(rs.getString("TRELDATE"));
				movie.setPoster(rs.getString("POSTER"));
				movie.setSubimg(rs.getString("SUBIMG"));
				movie.setTrailer(rs.getString("TRAILER"));
				movie.setRegdate(rs.getString("REGDATE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return movie;
	}


	public int showMovieDetail(Connection conn, Date d) {
		PreparedStatement pstmt = null;
		String query = "insert into test values( to_date('2018-05-09 09:30' , 'yyyy-mm-dd hh24:mi') )";
		int result =0; 
		try {
			pstmt = conn.prepareStatement(query);
			 System.out.println("dd.toLocaleString()@DAO="+d.toLocaleString());
			//pstmt.setDate(1, d);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}


	public int deleteMovie(Connection conn, String mid) {
		PreparedStatement pstmt = null;
		String query = "DELETE FROM MOVIE WHERE MID = " + mid;
		int result =0; 
		
		try {
			pstmt = conn.prepareStatement(query);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	/* ------------recommenMovie 추천 영화-------------------------------*/


	public List<MovieData> recommendMovieGenre(Connection conn, String genre) {
		List<MovieData> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("recommendMovieGenre");
		
		
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, genre);
			
			rset = pstmt.executeQuery();
			list = new ArrayList<>();
			
			while(rset.next()) {
				MovieData md = new MovieData();
				md.setmId(rset.getInt("mid"));
				md.setName(rset.getString("name"));
				md.seteName(rset.getString("ename"));
				md.setGrade(rset.getString("grade"));
				md.setRuntime(rset.getInt("runtime"));
				md.setDirector(rset.getString("director"));
				md.setActor(rset.getString("actor"));
				md.setGenre(rset.getString("genre"));
				md.setStory(rset.getString("story"));
				md.setRelDate(rset.getDate("reldate"));
				md.setPoster(rset.getString("poster"));
				md.setSubImg(rset.getString("subimg"));
				md.setTrailer(rset.getString("trailer"));
				list.add(md);
				
			}
			
			System.out.println("list@movieDAO=" + list);
			System.out.println("여기 들어오니..??");
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return list;
	}


	public List<MovieData> recommendMovieDetail(Connection conn, String detailGenre, String datailGrade,
			String detailDirector, String detailActor) {
		List<MovieData> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("recommendMovieDetail");
		
		
		try {
			
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, detailGenre);
			pstmt.setString(2, detailDirector);
			pstmt.setString(3, detailActor);
			pstmt.setString(4, datailGrade);
			
			rset = pstmt.executeQuery();
			list = new ArrayList<>();
			
			while(rset.next()) {
				MovieData md = new MovieData();
				md.setmId(rset.getInt("mid"));
				md.setName(rset.getString("name"));
				md.seteName(rset.getString("ename"));
				md.setGrade(rset.getString("grade"));
				md.setRuntime(rset.getInt("runtime"));
				md.setDirector(rset.getString("director"));
				md.setActor(rset.getString("actor"));
				md.setGenre(rset.getString("genre"));
				md.setStory(rset.getString("story"));
				md.setRelDate(rset.getDate("reldate"));
				md.setPoster(rset.getString("poster"));
				md.setSubImg(rset.getString("subimg"));
				md.setTrailer(rset.getString("trailer"));
				list.add(md);
				
			}
			
			System.out.println("list@movieDAO=" + list);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}


	public List<MovieData> recommendMovieActor(Connection conn, String actor) {
		List<MovieData> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("recommendMovieActor");
		
		
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+actor+"%");
			
			rset = pstmt.executeQuery();
			list = new ArrayList<>();
			
			while(rset.next()) {
				MovieData md = new MovieData();
				md.setmId(rset.getInt("mid"));
				md.setName(rset.getString("name"));
				md.seteName(rset.getString("ename"));
				md.setGrade(rset.getString("grade"));
				md.setRuntime(rset.getInt("runtime"));
				md.setDirector(rset.getString("director"));
				md.setActor(rset.getString("actor"));
				md.setGenre(rset.getString("genre"));
				md.setStory(rset.getString("story"));
				md.setRelDate(rset.getDate("reldate"));
				md.setPoster(rset.getString("poster"));
				md.setSubImg(rset.getString("subimg"));
				md.setTrailer(rset.getString("trailer"));
				list.add(md);
				
			}
			
			System.out.println("list@movieDAO=" + list);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return list;
	}


	public List<MovieData> recommendMovieRandom(Connection conn) {
		List<MovieData> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("recommendMovieRandom");
		
		
		try {
			pstmt = conn.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			list = new ArrayList<>();
			
			while(rset.next()) {
				MovieData md = new MovieData();
				md.setmId(rset.getInt("mid"));
				md.setName(rset.getString("name"));
				md.seteName(rset.getString("ename"));
				md.setGrade(rset.getString("grade"));
				md.setRuntime(rset.getInt("runtime"));
				md.setDirector(rset.getString("director"));
				md.setActor(rset.getString("actor"));
				md.setGenre(rset.getString("genre"));
				md.setStory(rset.getString("story"));
				md.setRelDate(rset.getDate("reldate"));
				md.setPoster(rset.getString("poster"));
				md.setSubImg(rset.getString("subimg"));
				md.setTrailer(rset.getString("trailer"));
				list.add(md);
				
			}
			
			System.out.println("list@MovieDAO=" + list);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}


	public List<MovieData> recommendMovieDirector(Connection conn, String director) {
		List<MovieData> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("recommendMovieDirector");
		
		
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+director+"%");
			
			rset = pstmt.executeQuery();
			list = new ArrayList<>();
			
			while(rset.next()) {
				MovieData md = new MovieData();
				md.setmId(rset.getInt("mid"));
				md.setName(rset.getString("name"));
				md.seteName(rset.getString("ename"));
				md.setGrade(rset.getString("grade"));
				md.setRuntime(rset.getInt("runtime"));
				md.setDirector(rset.getString("director"));
				md.setActor(rset.getString("actor"));
				md.setGenre(rset.getString("genre"));
				md.setStory(rset.getString("story"));
				md.setRelDate(rset.getDate("reldate"));
				md.setPoster(rset.getString("poster"));
				md.setSubImg(rset.getString("subimg"));
				md.setTrailer(rset.getString("trailer"));
				list.add(md);
				
			}
			
			System.out.println("list@MovieDAO=" + list);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}


	public List<MovieData> recommenMovieGrade(Connection conn, String grade) {
		List<MovieData> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("recommenMovieGrade");
		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, grade);
			
			rset = pstmt.executeQuery();
			list = new ArrayList<>();
			
			while(rset.next()) {
				MovieData md = new MovieData();
				md.setmId(rset.getInt("mid"));
				md.setName(rset.getString("name"));
				md.seteName(rset.getString("ename"));
				md.setGrade(rset.getString("grade"));
				md.setRuntime(rset.getInt("runtime"));
				md.setDirector(rset.getString("director"));
				md.setActor(rset.getString("actor"));
				md.setGenre(rset.getString("genre"));
				md.setStory(rset.getString("story"));
				md.setRelDate(rset.getDate("reldate"));
				md.setPoster(rset.getString("poster"));
				md.setSubImg(rset.getString("subimg"));
				md.setTrailer(rset.getString("trailer"));
				list.add(md);
				
			}
			
			System.out.println("list@MovieDAO=" + list);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return list;
	}
	


}
