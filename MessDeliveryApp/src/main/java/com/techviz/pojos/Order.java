package com.techviz.pojos;

public class Order {
	
	private int id;
	private User user;
	private String orderDetail;
	private OrderStatus orderStatus;
	
	public Order(int id, User user, String orderDetail, OrderStatus status) {
		this.id = id;
		this.user = user;
		this.orderDetail = orderDetail;
		this.orderStatus = orderStatus;
	}
	
	
	
	

}
