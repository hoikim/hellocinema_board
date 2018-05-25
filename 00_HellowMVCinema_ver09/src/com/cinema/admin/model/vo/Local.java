package com.cinema.admin.model.vo;

public class Local {
	private int lid;
	private String lname;
	public Local() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Local(int lid, String lname) {
		super();
		this.lid = lid;
		this.lname = lname;
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	@Override
	public String toString() {
		return "Local [lid=" + lid + ", lname=" + lname + "]";
	}
	
}
