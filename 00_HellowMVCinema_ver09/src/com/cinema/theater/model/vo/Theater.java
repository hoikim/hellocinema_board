package com.cinema.theater.model.vo;

public class Theater {
	private int tid;
	private int nid;
	private int lid;
	private String name;
	private String addr;
	private String tel;
	public Theater() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Theater(int tid, int nid, int lid, String name, String addr, String tel) {
		super();
		this.tid = tid;
		this.nid = nid;
		this.lid = lid;
		this.name = name;
		this.addr = addr;
		this.tel = tel;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "Theater [tid=" + tid + ", nid=" + nid + ", lid=" + lid + ", name=" + name + ", addr=" + addr + ", tel="
				+ tel + "]";
	}
	
	
}
