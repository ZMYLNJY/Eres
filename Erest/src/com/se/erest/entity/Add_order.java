package com.se.erest.entity;

import java.io.Serializable;

public class Add_order implements Serializable{
	private int add_order_id;
	private Order order;
	private String add_order_opentime;
	private String add_order_note;
    private float add_order_price;
	public int getAdd_order_id() {
		return add_order_id;
	}
	public void setAdd_order_id(int add_order_id) {
		this.add_order_id = add_order_id;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public String getAdd_order_opentime() {
		return add_order_opentime;
	}
	public void setAdd_order_opentime(String add_order_opentime) {
		this.add_order_opentime = add_order_opentime;
	}
	public String getAdd_order_note() {
		return add_order_note;
	}
	public void setAdd_order_note(String add_order_note) {
		this.add_order_note = add_order_note;
	}
	public float getAdd_order_price() {
		return add_order_price;
	}
	public void setAdd_order_price(float add_order_price) {
		this.add_order_price = add_order_price;
	}


}
