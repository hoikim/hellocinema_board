package com.cinema.ticket.model.vo;

public class Ticket {
	private int bid;
	private int usid;
	private int shid;
	private int adult;
	private int child;
	private int teen;
	private int old;
	private int price;
	private String checked;
	private String use;
	private String seatnum;
	private String status;
	private String etc;
	private String regdate;
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ticket(int bid, int usid, int shid, int adult, int child, int teen, int old, int price, String checked,
			String use, String seatnum, String status, String etc, String regdate) {
		super();
		this.bid = bid;
		this.usid = usid;
		this.shid = shid;
		this.adult = adult;
		this.child = child;
		this.teen = teen;
		this.old = old;
		this.price = price;
		this.checked = checked;
		this.use = use;
		this.seatnum = seatnum;
		this.status = status;
		this.etc = etc;
		this.regdate = regdate;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public int getUsid() {
		return usid;
	}
	public void setUsid(int usid) {
		this.usid = usid;
	}
	public int getShid() {
		return shid;
	}
	public void setShid(int shid) {
		this.shid = shid;
	}
	public int getAdult() {
		return adult;
	}
	public void setAdult(int adult) {
		this.adult = adult;
	}
	public int getChild() {
		return child;
	}
	public void setChild(int child) {
		this.child = child;
	}
	public int getTeen() {
		return teen;
	}
	public void setTeen(int teen) {
		this.teen = teen;
	}
	public int getOld() {
		return old;
	}
	public void setOld(int old) {
		this.old = old;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getChecked() {
		return checked;
	}
	public void setChecked(String checked) {
		this.checked = checked;
	}
	public String getUse() {
		return use;
	}
	public void setUse(String use) {
		this.use = use;
	}
	public String getSeatnum() {
		return seatnum;
	}
	public void setSeatnum(String seatnum) {
		this.seatnum = seatnum;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEtc() {
		return etc;
	}
	public void setEtc(String etc) {
		this.etc = etc;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "Ticket [bid=" + bid + ", usid=" + usid + ", shid=" + shid + ", adult=" + adult + ", child=" + child
				+ ", teen=" + teen + ", old=" + old + ", price=" + price + ", checked=" + checked + ", use=" + use
				+ ", seatnum=" + seatnum + ", status=" + status + ", etc=" + etc + ", regdate=" + regdate + "]";
	}

}
