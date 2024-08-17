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
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
	@NotBlank
	@Size(min = 5, max = 25)
	private String messName;
	@Enumerated(EnumType.STRING)
	@Column(name = "mess_locality", nullable = false)
	@NotNull
	private Locality locality;
	@NotBlank
	@NotNull
	private long phone;
	@OneToMany(mappedBy = "mess", cascade = CascadeType.ALL)
	@NotEmpty
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
