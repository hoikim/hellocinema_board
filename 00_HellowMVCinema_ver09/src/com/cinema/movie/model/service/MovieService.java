package com.cinema.movie.model.service;

import static com.cinema.common.JDBCTemplate.close;
import static com.cinema.common.JDBCTemplate.commit;
import static com.cinema.common.JDBCTemplate.getConnection;
import static com.cinema.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.cinema.movie.model.dao.MovieDAO;
import com.cinema.movie.model.vo.Movie;
import com.cinema.movie.model.vo.MovieData;

public class MovieService {

	public int autoInsertMoviesData(Movie m) {
		
		int result =0;
		Connection conn = getConnection();
		result = new MovieDAO().autoInsertMoviesData(conn, m);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		} 
		
		close(conn);
		
		return result;
	}

	public List<Movie> showMovies() {
		Connection conn =getConnection();
		List<Movie> mList = new MovieDAO().showMovies(conn); 
		
		if(mList != null) {
			System.out.println("바쁘구만");
		}else {
			System.out.println("널널하구만");
			
		}
		close(conn);
		
		return mList;
	}

	public int moviesAllCount() {
		
		Connection conn = getConnection();

		int count = new MovieDAO().moviesAllCount(conn);
		
		if(count>0) {
			System.out.println("성공적으로 가져왔어"+count);
		}else {
			System.out.println("실팬지 없는건지"+count );
		}
		return count;
	}

	public List<Movie> showMoivesPaging(int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<Movie> list = new MovieDAO().showMoivesPaging(conn, cPage, numPerPage);
		close(conn);
		return list;
	}

	public int movieProc(Movie m) {
		int result =0;
		Connection conn = getConnection();
		result = new MovieDAO().movieProc(conn, m);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		} 
		
		close(conn);
		
		return result;
	}

	public List<Movie> showMovieskey(String keyword) {
		Connection conn =getConnection();
		List<Movie> mList = new MovieDAO().showMovieskey(conn, keyword); 
		
		close(conn);
		
		return mList;
	}


	public Movie showMovieDetail(String mid) {
		Connection conn = getConnection();
		Movie m = new MovieDAO().showMovieDetail(conn, mid);
		
		return m;
	}

	public int insertDate(Date d) {
		Connection conn = getConnection();
		int result = new MovieDAO().showMovieDetail(conn, d);
		
		if(result > 0 ) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public int deleteMovie(String mid) {
		Connection conn = getConnection();
		int result = new MovieDAO().deleteMovie(conn, mid);
		
		if(result > 0 ) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

/* ------------recommenMovie 추천 영화-------------------------------*/
	
	public List<MovieData> recommendMovieGenre(String genre) {
		Connection conn= getConnection();
		List<MovieData> list = new MovieDAO().recommendMovieGenre(conn,genre);
		close(conn);
		return list;
	}

	public List<MovieData> recommendMovieDetail(String detailGenre, String datailGrade, String detailDirector,
			String detailActor) {
		Connection conn= getConnection();
		List<MovieData> list = new MovieDAO().recommendMovieDetail(conn,detailGenre, datailGrade, detailDirector,
				detailActor);
		close(conn);
		return list;
	}

	public List<MovieData> recommendMovieActor(String actor) {
		Connection conn= getConnection();
		List<MovieData> list = new MovieDAO().recommendMovieActor(conn,actor);
		close(conn);
		return list;
	}

	public List<MovieData> recommendMovieRandom() {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		List<MovieData> list = new MovieDAO().recommendMovieRandom(conn);
		close(conn);
		return list;
	}

	public List<MovieData> recommendMovieDirector(String director) {
		Connection conn= getConnection();
		List<MovieData> list = new MovieDAO().recommendMovieDirector(conn,director);
		close(conn);
		return list;
	}

	public List<MovieData> recommendMovieGrade(String grade) {
		Connection conn = getConnection();
		List<MovieData> list = new MovieDAO().recommenMovieGrade(conn,grade);
		close(conn);
		return list;
	}
 

}
