package com.techviz.app.pojos;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="MESS")
@Getter
@NoArgsConstructor
@Setter
public class Mess {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "MESS_NAME")
	private String messName;
	@Enumerated(EnumType.STRING)
	@Column(name = "mess_locality", nullable = false)
	private Locality locality;
	private long phone;
	@OneToMany(mappedBy = "mess", cascade = CascadeType.ALL)
	private List<Food> foods;
//	@OneToMany
//	private List<Order> orders;
	
	public Mess(int id, String messName, Locality locality, long phone) {
		this.id = id;
		this.messName = messName;
		this.locality = locality;
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Mess [id=" + id + ", messName=" + messName + ", locality=" + locality + ", owner=" + ", phone="
				+ phone + "]";
	}
	
	

}
