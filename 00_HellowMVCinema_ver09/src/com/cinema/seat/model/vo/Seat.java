package com.cinema.seat.model.vo;

public class Seat {

	private int sid;
	private int tid;
	private String name;
	private String shape;
	private String etc;
	public Seat() {
	}
	public Seat(int sid, int tid, String name, String shape, String etc) {
		super();
		this.sid = sid;
		this.tid = tid;
		this.name = name;
		this.shape = shape;
		this.etc = etc;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShape() {
		return shape;
	}
	public void setShape(String shape) {
		this.shape = shape;
	}
	public String getEtc() {
		return etc;
	}
	public void setEtc(String etc) {
		this.etc = etc;
	}
	@Override
	public String toString() {
		return "Seat [sid=" + sid + ", tid=" + tid + ", name=" + name + ", shape=" + shape + ", etc=" + etc + "]";
	}
	
	
}
