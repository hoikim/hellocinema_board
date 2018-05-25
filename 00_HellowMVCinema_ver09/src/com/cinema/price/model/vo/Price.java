package com.cinema.price.model.vo;

public class Price {
	private int pid;
	private String name;
	private int price;
	private String kind;
	private String etc;
	
	public Price() {
		super();
	}

	public Price(int pid, String name, int price, String kind, String etc) {
		super();
		this.pid = pid;
		this.name = name;
		this.price = price;
		this.kind = kind;
		this.etc = etc;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getEtc() {
		return etc;
	}

	public void setEtc(String etc) {
		this.etc = etc;
	}

	@Override
	public String toString() {
		return "Price [pid=" + pid + ", name=" + name + ", price=" + price + ", kind=" + kind + ", etc=" + etc + "]";
	}
	
	
}
