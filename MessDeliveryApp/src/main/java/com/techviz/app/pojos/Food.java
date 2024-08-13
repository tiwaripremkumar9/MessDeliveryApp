package com.techviz.app.pojos;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.core.sym.Name;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "FOOD")
@Getter
@Setter
public class Food {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FOOD_ID")
	private int id;
	@Column(name = "FOOD_DESC")
	private String description;
	@Column(name = "FOOD_AVAIL")
	private Boolean availibity;
	@ManyToMany
	@JoinTable(name = "FOOD_ORDERS",
			joinColumns = {@JoinColumn(name = "FOOD_ID")},
			inverseJoinColumns = {@JoinColumn(name="ORDERS_ID")})
	private Set<Order> orders;
	
	public Food(int id, String description, Boolean availibity) {
		this.id = id;
		this.description = description;
		this.availibity = availibity;
	}
}
