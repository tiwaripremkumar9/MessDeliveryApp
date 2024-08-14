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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ORDERS")
@Getter
@Setter
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORDERS_ID")
	private int id;
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
	@Column(name="ORDERS_DETAIL")
	private String orderDetail;
	@Enumerated(EnumType.STRING)
	@Column(name="ORDERS_STATUS", nullable = false)
	private OrderStatus orderStatus;
	@OneToOne
	@JoinColumn(name = "ORDER_ADDR")
	private Address address;
	@ManyToMany(mappedBy = "orders", cascade = CascadeType.ALL)
	private List<Food> foods;
	@ManyToOne
	@JoinColumn(name = "mess")
	private Mess mess;
	
	public Order(int id, User user, String orderDetail, OrderStatus status) {
		this.id = id;
		this.user = user;
		this.orderDetail = orderDetail;
		this.orderStatus = orderStatus;
	}
	
	

}
