package com.cinema.review.model.service;

import java.sql.Connection;
import java.util.List;

import com.cinema.review.model.dao.ReviewDAO;
import com.cinema.review.model.vo.Review;
import static com.cinema.common.JDBCTemplate.*;

public class ReviewService {

	public int insertReview(Review rv) {
		Connection conn = getConnection();
		int result = new ReviewDAO().insertReview(conn,rv);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

	public int updateReview(Review r) {
		Connection conn = getConnection();
		int result = new ReviewDAO().updateReview(conn,r);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

	public List<Review> selectReview(int mid) {
		Connection conn =getConnection();
		List<Review> list = new ReviewDAO().selectReview(conn,mid);
		close(conn);
		return list;
	}

	public int deleteReview(int rvid) {
		Connection conn = getConnection();
		int result = new ReviewDAO().deleteReview(conn,rvid);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

	public int selectReviewCount(int mid) {
		Connection conn= getConnection();
		int total = new ReviewDAO().selectReviewCount(conn,mid);
		
		return total;
	}

	public List<Review> selectReview(int cPage, int numPerPage, int mid) {
		Connection conn = getConnection();
		List<Review> list = new ReviewDAO().selectReview(conn, cPage,numPerPage,mid);
		close(conn);
		return list;
	}

}
