package com.cinema.admin.model.vo;

import java.util.Date;

public class Manager {
	private int nid;
	private int tid;
	private String id;
	private String pw;
	private String name;
	private String photo;
	private Date regdate;
	
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manager(int nid, int tid, String id, String pw, String name, String photo) {
		super();
		this.nid = nid;
		this.tid = tid;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.photo = photo;
	}
	public Manager(int nid, int tid, String id, String pw, String name, String photo, Date regdate ) {
		super();
		this.nid = nid;
		this.tid = tid;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.photo = photo;
		this.regdate = regdate;
	}
	
	
	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getNid() {
		return nid;
	}

	public void setNid(int nid) {
		this.nid = nid;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "Manager [nid=" + nid + ", tid=" + tid + ", id=" + id + ", pw=" + pw + ", name=" + name + ", photo="
				+ photo + "]";
	}
	
	
}
