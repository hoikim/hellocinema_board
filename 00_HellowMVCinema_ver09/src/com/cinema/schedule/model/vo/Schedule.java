package com.cinema.schedule.model.vo;

import java.sql.Date;
import java.util.List;

public class Schedule {
	private int shid;
	private int rid;
	private int mid;
	private int lseat;
	private String seat;
	private String time;
	private String endtime;
	private String regdate;
	public Schedule() {
	}
	public Schedule(int shid, int rid, int mid, int lseat, String seat, String time, String endtime, String regdate) {
		super();
		this.shid = shid;
		this.rid = rid;
		this.mid = mid;
		this.lseat = lseat;
		this.seat = seat;
		this.time = time;
		this.endtime = endtime;
		this.regdate = regdate;
	}
	public int getShid() {
		return shid;
	}
	public void setShid(int shid) {
		this.shid = shid;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public int getLseat() {
		return lseat;
	}
	public void setLseat(int lseat) {
		this.lseat = lseat;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "Schedule [shid=" + shid + ", rid=" + rid + ", mid=" + mid + ", lseat=" + lseat + ", seat=" + seat
				+ ", time=" + time + ", endtime=" + endtime + ", regdate=" + regdate + "]";
	}
	
}
