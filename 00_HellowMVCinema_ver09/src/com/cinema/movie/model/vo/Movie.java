package com.cinema.movie.model.vo;


public class Movie {

	private String mid; //영화코드
	private String name; //영화이름
	private String ename; //영문이름
	private String grade; //등급
	private String type;
	private int runtime; //러닝타임
	private String reldate; //개봉년월일
	private String genre; // *장르코드  : 장르테이블 참조 
	private String actor; //연기자 
	private String director; //감독
	private String staff; //staff
	private String story; //줄거리 내용
	private String poster; //포스터 주소
	private String subimg; //서브이미지 주소
	private String trailer; //영상주소
	private String regdate; //등록일자
	private String status;

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Movie(String mid, String name, String ename, String grade, String type, int runtime, String reldate, String prddate,
			String genre, String actor, String director, String staff, String story,
			String poster, String subimg, String trailer, String regdate) {
		super();
		this.mid = mid;
		this.name = name;
		this.ename = ename;
		this.grade = grade;
		this.type = type;
		this.runtime = runtime;
		this.reldate = reldate;
		this.genre = genre;
		this.actor = actor;
		this.director = director;
		this.staff = staff;
		this.story = story;
		this.poster = poster;
		this.subimg = subimg;
		this.trailer = trailer;
		this.regdate = regdate;
	}
	public Movie(String name, String ename, String grade, int runtime,  String type, String reldate, String prddate, String genre,
			String actor, String director, String staff, String story, String poster, String subimg,
			String trailer, String status) {
			this.name = name;
			this.ename = ename;
			this.grade = grade;
			this.type = type;
			this.runtime = runtime;
			this.reldate = reldate;
			this.genre = genre;
			this.actor = actor;
			this.director = director;
			this.staff = staff;
			this.story = story;
			this.poster = poster;
			this.subimg = subimg;
			this.trailer = trailer;
			this.status = status;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
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
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getRuntime() {
		return runtime;
	}
	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}
	public String getReldate() {
		return reldate;
	}
	public void setReldate(String reldate) {
		this.reldate = reldate;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getStaff() {
		return staff;
	}
	public void setStaff(String staff) {
		this.staff = staff;
	}
	public String getStory() {
		return story;
	}
	public void setStory(String story) {
		this.story = story;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getSubimg() {
		return subimg;
	}
	public void setSubimg(String subimg) {
		this.subimg = subimg;
	}
	public String getTrailer() {
		return trailer;
	}
	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Movie [mid=" + mid + ", name=" + name + ", ename=" + ename + ", grade=" + grade + ", runtime=" + runtime
				+ ", reldate=" + reldate + ", genre=" + genre + ", actor=" + actor
				+ ", director=" + director + ", staff=" + staff + ", story=" + story + ", poster=" + poster
				+ ", subimg=" + subimg + ", trailer=" + trailer + ", regdate=" + regdate + ", status=" + status +"]";
	}
	
	
	
}
