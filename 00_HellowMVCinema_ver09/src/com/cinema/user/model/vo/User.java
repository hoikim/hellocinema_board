package com.cinema.user.model.vo;

import java.util.Date;

public class User {
	private int usid;
	private String id;
	private String pw;
	private String name;
	private String birth;
	private String phone;
	private String email;
	private int lv;
	private String gender;
	private Date regdate;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int usid, String id, String pw, String name, String birth, String phone, String email, int lv,
			String gender, Date regdate) {
		super();
		this.usid = usid;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.birth = birth;
		this.phone = phone;
		this.email = email;
		this.lv = lv;
		this.gender = gender;
		this.regdate = regdate;
	}
 
	public User(String id, String pw, String name, String birth, String phone, String email, String gender) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.birth = birth;
		this.phone = phone;
		this.email = email;
		this.gender = gender;
	}
	public int getUsid() {
		return usid;
	}
	public void setUsid(int usid) {
		this.usid = usid;
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
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getLv() {
		return lv;
	}
	public void setLv(int lv) {
		this.lv = lv;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "User [usid=" + usid + ", id=" + id + ", pw=" + pw + ", name=" + name + ", birth=" + birth + ", phone="
				+ phone + ", email=" + email + ", lv=" + lv + ", gender=" + gender + ", regdate=" + regdate + "]";
	}
	
	
}
