package com.techviz.app.pojos;

import jakarta.persistence.*;
@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "addr_id")
	private int id;
	@Column(name = "addr_line1")
	private String line1;
	@Column(name = "addr_line2")
	private String line2;
	@Column(name = "addr_line3")
	private String line3;
	@Enumerated(EnumType.STRING)
	private Locality locality;
	private int pincode;
	@ManyToOne
	@JoinColumn(name = "user")
	private User user;
	
	public Address(int id, String line1, String line2, String line3, int pincode, User user) {
		this.id = id;
		this.line1 = line1;
		this.line2 = line2;
		this.line3 = line3;
		this.pincode = pincode;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getLine3() {
		return line3;
	}

	public void setLine3(String line3) {
		this.line3 = line3;
	}

	public Locality getLocality() {
		return locality;
	}

	public void setLocality(Locality locality) {
		this.locality = locality;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", line1=" + line1 + ", line2=" + line2 + ", line3=" + line3 + ", pincode="
				+ pincode + ", user=" + user + "]";
	}
	
}
