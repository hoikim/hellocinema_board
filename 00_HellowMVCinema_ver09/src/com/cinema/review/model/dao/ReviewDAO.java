package com.cinema.review.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.cinema.review.model.vo.Review;

import static com.cinema.common.JDBCTemplate.*;

public class ReviewDAO {
private Properties prop = new Properties();
	
	public ReviewDAO() {
		String fileName=ReviewDAO.class.getResource("/sql/review/review-query.properties").getPath();
		// /는 classes
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int insertReview(Connection conn, Review rv) {
		PreparedStatement pstmt=null;
		String query = prop.getProperty("insertReview");
		int result =0;

		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, rv.getContent());
			pstmt.setInt(2, rv.getStarScore());
			pstmt.setInt(3, rv.getUsid());
			pstmt.setInt(4, rv.getMid());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int updateReview(Connection conn, Review r) {
		int result =0;
		
		PreparedStatement pstmt=null;
		String query = prop.getProperty("updateReview");
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, r.getStarScore());
			pstmt.setString(2, r.getContent());
			pstmt.setInt(3, r.getRvid());
			
			result = pstmt.executeUpdate();
			
			System.out.println("result@reviewDAO updateReview="+result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public List<Review> selectReview(Connection conn, int mid) {
		List<Review> list =null;
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		String query = prop.getProperty("selectReview");
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, mid);
			list = new ArrayList<>();
			rset = pstmt.executeQuery();
			 while(rset.next()) {
			  Review r = new Review(rset.getInt("rvid"),  rset.getString("content"),rset.getInt("grade"),
					  rset.getInt("usid"),rset.getInt("mid"),rset.getDate("regdate"),rset.getString("id"),null);
			  list.add(r);
				  
			  }
			 
			 System.out.println("list@reviewDAO selectReview ="+list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int deleteReview(Connection conn, int rvid) {
		int result =0;
		
		PreparedStatement pstmt=null;
		String query = prop.getProperty("deleteReview");
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, rvid);
			result = pstmt.executeUpdate();
			
			System.out.println("result@reviewDAO deleteReview="+result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int selectReviewCount(Connection conn, int mid) {
		int totalReview =0;
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		String query=prop.getProperty("selectReviewCount");
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, mid);
			rset=pstmt.executeQuery();
			rset.next();
			totalReview=rset.getInt("cnt");
			System.out.println("totalReview@ReviewDAO="+totalReview);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return totalReview;
	}

	public List<Review> selectReview(Connection conn, int cPage, int numPerPage, int mid) {
		List<Review> list = null;
		PreparedStatement pstmt=null;
		ResultSet rset =null;
		String query = prop.getProperty("selectReviewListByPaging");
		try {
				pstmt = conn.prepareStatement(query);
				System.out.println("cPage="+cPage+"numPerPage="+numPerPage+"mid="+mid);
				//(공식2)시작 rownum과 마지막 rownum을 구하는 공식
				pstmt.setInt(1, mid);
				pstmt.setInt(2, (numPerPage*cPage)-(numPerPage-1)); //회진이꺼 numPerPage*(cPage-1) + 1
				pstmt.setInt(3, (numPerPage*cPage));
				
				rset=pstmt.executeQuery();
				list=new ArrayList<>();
				while(rset.next()) {
					Review r =new Review();
					r.setUsid(rset.getInt("usid"));
					r.setRvid(rset.getInt("rvid"));
					r.setMid(rset.getInt("mid"));
					r.setContent(rset.getString("content"));
					r.setId(rset.getString("id"));
					r.setStarScore(rset.getInt("grade"));
					r.setRegDate(rset.getDate("regdate"));
					list.add(r);
					System.out.println("r="+r);
				}
				System.out.println("list@ReivewDAO.selectReview="+list);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
	
	return list;
		
	}

}
