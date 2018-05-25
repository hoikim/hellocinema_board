package com.cinema.room.model.vo;

public class Room {
	private int rid;
	private int tid;
	private int sid;
	private String name;
	private String type;
	private String etc;
	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Room(int rid, int tid, int sid, String name, String type, String etc) {
		super();
		this.rid = rid;
		this.tid = tid;
		this.sid = sid;
		this.name = name;
		this.type = type;
		this.etc = etc;
	}

	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEtc() {
		return etc;
	}
	public void setEtc(String etc) {
		this.etc = etc;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Room [rid=" + rid + ", tid=" + tid + ", sid=" + sid + ", name=" + name + ", type=" + type + ", etc="
				+ etc + "]";
	}
	
	
	
}
