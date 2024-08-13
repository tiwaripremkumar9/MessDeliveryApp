package com.techviz.app.pojos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="MESS")
@Getter
@Setter
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

	@Override
	public String toString() {
		return "Mess [id=" + id + ", messName=" + messName + ", address=" + address + ", owner=" + owner + ", phone="
				+ phone + "]";
	}
	
	

}
