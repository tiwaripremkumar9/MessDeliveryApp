package com.techviz.app.pojos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="MESS")
public class Mess {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "MESS_NAME")
	private String messName;
	@OneToOne
	private Address address;
	@OneToOne
	private User owner;
	private long phone;
	
	public Mess(int id, String messName, Address address, User owner, long phone) {
		this.id = id;
		this.messName = messName;
		this.address = address;
		this.owner = owner;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessName() {
		return messName;
	}

	public void setMessName(String messName) {
		this.messName = messName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Mess [id=" + id + ", messName=" + messName + ", address=" + address + ", owner=" + owner + ", phone="
				+ phone + "]";
	}
	
	

}
