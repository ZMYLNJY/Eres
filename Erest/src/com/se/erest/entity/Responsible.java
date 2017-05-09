package com.se.erest.entity;

import java.io.Serializable;

public class Responsible implements Serializable{
	private Cook cook;
	private Category category;
	public Cook getCook() {
		return cook;
	}
	public void setCook(Cook cook) {
		this.cook = cook;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

}
