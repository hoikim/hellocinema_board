package com.cinema.movie.model.vo;

import java.sql.Date;

public class MovieData {
	private int mId;
	private String name;
	private String ename;
	private String grade;
	private int runtime;
	private String director;
	private String actor;
	private String genre;
	private String story;
	private Date relDate;
	private String poster;
	private String subImg;
	private String trailer;
	private Date regDate;
	
	
	public MovieData(int mId, String name, String ename, String grade, int runtime, String director, String actor,
			String genre, String story, Date relDate, String poster, String subImg, String trailer, Date regDate) {
		
		this.mId = mId;
		this.name = name;
		this.ename = ename;
		this.grade = grade;
		this.runtime = runtime;
		this.director = director;
		this.actor = actor;
		this.genre = genre;
		this.story = story;
		this.relDate = relDate;
		this.poster = poster;
		this.subImg = subImg;
		this.trailer = trailer;
		this.regDate = regDate;
	}


	public MovieData() {}


	public int getmId() {
		return mId;
	}


	public void setmId(int mId) {
		this.mId = mId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEname() {
		return ename;
	}


	public void seteName(String ename) {
		this.ename = ename;
	}


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}


	public int getRuntime() {
		return runtime;
	}


	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}


	public String getDirector() {
		return director;
	}


	public void setDirector(String director) {
		this.director = director;
	}


	public String getActor() {
		return actor;
	}


	public void setActor(String actor) {
		this.actor = actor;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public String getStory() {
		return story;
	}


	public void setStory(String story) {
		this.story = story;
	}


	public Date getRelDate() {
		return relDate;
	}


	public void setRelDate(Date relDate) {
		this.relDate = relDate;
	}


	public String getPoster() {
		return poster;
	}


	public void setPoster(String poster) {
		this.poster = poster;
	}


	public String getSubImg() {
		return subImg;
	}


	public void setSubImg(String subImg) {
		this.subImg = subImg;
	}


	public String getTrailer() {
		return trailer;
	}


	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}


	public Date getRegDate() {
		return regDate;
	}


	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}


	@Override
	public String toString() {
		return "Moive [mId=" + mId + ", name=" + name + ", eName=" + ename + ", grade=" + grade + ", runtime=" + runtime
				+ ", director=" + director + ", actor=" + actor + ", genre=" + genre + ", story=" + story + ", relDate="
				+ relDate + ", poster=" + poster + ", subImg=" + subImg + ", trailer=" + trailer + ", regDate="
				+ regDate + "]";
	}


	
	
	
	
	
	
	
	
	
}
