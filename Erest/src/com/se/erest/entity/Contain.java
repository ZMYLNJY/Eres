package com.se.erest.entity;

import java.io.Serializable;

public class Contain implements Serializable{
	private Order order;
	private Menu_item menu_item;
	private int item_amount;
	private String item_note;
	private int item_status;
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Menu_item getMenu_item() {
		return menu_item;
	}
	public void setMenu_item(Menu_item menu_item) {
		this.menu_item = menu_item;
	}
	public int getItem_amount() {
		return item_amount;
	}
	public void setItem_amount(int item_amount) {
		this.item_amount = item_amount;
	}
	public String getItem_note() {
		return item_note;
	}
	public void setItem_note(String item_note) {
		this.item_note = item_note;
	}
	public int getItem_status() {
		return item_status;
	}
	public void setItem_status(int item_status) {
		this.item_status = item_status;
	}



}
