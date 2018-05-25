package com.cinema.review.model.vo;

import java.sql.Date;

public class Review {
	private int rvid;
	private String content;
	private int starScore;
	private int usid; //유저 아이디 코드 
	private int mid;
	private Date regDate;
	private String id; //유저의 실제 아이디
	private String profile;
	
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public Review(String content, int starScore, int usid, int mid) {
		super();
		this.content = content;
		this.starScore = starScore;
		this.usid = usid;
		this.mid = mid;
	}



	public Review(int rvid, String content, int starScore, int usid, int mid, Date regDate, String id,
			String profile) {
		super();
		this.rvid = rvid;
		this.content = content;
		this.starScore = starScore;
		this.usid = usid;
		this.mid = mid;
		this.regDate = regDate;
		this.id = id;
		this.profile = profile;
	}



	@Override
	public String toString() {
		return "rvid=" + rvid + ", content=" + content + ", starScore=" + starScore + ", usid=" + usid
				+ ", mid=" + mid + ", regDate=" + regDate + ", id=" + id + ", profile=" + profile;
	}



	public int getRvid() {
		return rvid;
	}

	public void setRvid(int rvid) {
		this.rvid = rvid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getStarScore() {
		return starScore;
	}

	public void setStarScore(int starScore) {
		this.starScore = starScore;
	}

	public int getUsid() {
		return usid;
	}

	public void setUsid(int usid) {
		this.usid = usid;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}
	

}
