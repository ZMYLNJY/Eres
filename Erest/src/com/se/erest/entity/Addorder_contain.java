package com.se.erest.entity;

import java.io.Serializable;

public class Addorder_contain implements Serializable{
	private Order order;
	private Add_order add_order;
	private Menu_item menu_item;
	private int addorder_amount;
	private int addorder_item_status;
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Add_order getAdd_order() {
		return add_order;
	}
	public void setAdd_order(Add_order add_order) {
		this.add_order = add_order;
	}
	public Menu_item getMenu_item() {
		return menu_item;
	}
	public void setMenu_item(Menu_item menu_item) {
		this.menu_item = menu_item;
	}
	public int getAddorder_amount() {
		return addorder_amount;
	}
	public void setAddorder_amount(int addorder_amount) {
		this.addorder_amount = addorder_amount;
	}
	public int getAddorder_item_status() {
		return addorder_item_status;
	}
	public void setAddorder_item_status(int addorder_item_status) {
		this.addorder_item_status = addorder_item_status;
	}
	

}
