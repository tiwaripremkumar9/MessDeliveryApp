package com.techviz.app.pojos;

public class Food {
	
	private int id;
	private String description;
	private Boolean availibity;
	
	public Food(int id, String description, Boolean availibity) {
		this.id = id;
		this.description = description;
		this.availibity = availibity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getAvailibity() {
		return availibity;
	}

	public void setAvailibity(Boolean availibity) {
		this.availibity = availibity;
	}
}
