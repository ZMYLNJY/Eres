package com.se.erest.entity;

import java.io.Serializable;

public class Menu_item implements Serializable{
	private int item_id;
	private Category category;
	private String item_name;
	private float item_price;
	private String item_photo;
	private String item_description;
	private int item_discount;
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public float getItem_price() {
		return item_price;
	}
	public void setItem_price(float item_price) {
		this.item_price = item_price;
	}
	public String getItem_photo() {
		return item_photo;
	}
	public void setItem_photo(String item_photo) {
		this.item_photo = item_photo;
	}
	public String getItem_description() {
		return item_description;
	}
	public void setItem_description(String item_description) {
		this.item_description = item_description;
	}
	public int getItem_discount() {
		return item_discount;
	}
	public void setItem_discount(int item_discount) {
		this.item_discount = item_discount;
	}

	



}
