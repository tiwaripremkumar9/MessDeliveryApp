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
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "FOOD")
@Getter
@NoArgsConstructor
@Setter
public class Food {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FOOD_ID")
	private int id;
	@Column(name = "FOOD_DESC")
	@NotBlank
	@Size(min = 20, max = 50)
	private String description;
	@Column(name = "FOOD_AVAIL")
	@NotNull
	private Boolean availability;
	@ManyToMany
	@JoinTable(name = "FOOD_ORDERS",
			joinColumns = {@JoinColumn(name = "FOOD_ID")},
			inverseJoinColumns = {@JoinColumn(name="ORDERS_ID")})
	private Set<Order> orders;
	@ManyToOne
	@JoinColumn(name = "food_mess")
	/*
	 * When dealing with complex objects that have nested properties requiring validation, 
	 * we can use the @Valid annotation along with validation annotations to ensure that both the top-level object 
	 * and its nested properties are properly validated.
	 */
	@Valid
	private Mess mess;
	
	public Food(int id, String description, Boolean availibity) {
		this.id = id;
		this.description = description;
		this.availability = availibity;
	}
}
