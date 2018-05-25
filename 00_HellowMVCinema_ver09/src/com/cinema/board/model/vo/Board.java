package com.cinema.board.model.vo;

import java.sql.Date;

public class Board {
	private int bdid;
	private String type;
	private String title;
	private String content;
	private String img;
	private String tinfo;
	private String status;
	private Date regdate;
	private Date startterm;
	private Date endterm;
	
	public Board() {}

	public Board(int bdid, String type, String title, String content, String img, String tinfo, String status,
			Date regdate, Date startterm, Date endterm) {
		this.bdid = bdid;
		this.type = type;
		this.title = title;
		this.content = content;
		this.img = img;
		this.tinfo = tinfo;
		this.status = status;
		this.regdate = regdate;
		this.startterm = startterm;
		this.endterm = endterm;
	}

	public int getBdid() {
		return bdid;
	}

	public void setBdid(int bdid) {
		this.bdid = bdid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getTinfo() {
		return tinfo;
	}

	public void setTinfo(String tinfo) {
		this.tinfo = tinfo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public Date getStartterm() {
		return startterm;
	}

	public void setStartterm(Date startterm) {
		this.startterm = startterm;
	}

	public Date getEndterm() {
		return endterm;
	}

	public void setEndterm(Date endterm) {
		this.endterm = endterm;
	}

	@Override
	public String toString() {
		return "Board [bdid=" + bdid + ", type=" + type + ", title=" + title + ", content=" + content + ", img=" + img
				+ ", tinfo=" + tinfo + ", status=" + status + ", regdate=" + regdate + ", startterm=" + startterm
				+ ", endterm=" + endterm + "]";
	}
	
	
	
	
	
	
	
	
}
	
	
	
