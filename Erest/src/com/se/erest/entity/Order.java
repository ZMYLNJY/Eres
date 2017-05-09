package com.se.erest.entity;

import java.io.Serializable;

public class Order implements Serializable{
	private int order_id;
	private Table table;
	private Cashier cashier;
	private Waiter waiter;
	private String order_opentime;
	private String order_closetime;
	private float order_price;
	private float discount;
	private float order_realprice;
	private String order_note;
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public Table getTable() {
		return table;
	}
	public void setTable(Table table) {
		this.table = table;
	}
	public Cashier getCashier() {
		return cashier;
	}
	public void setCashier(Cashier cashier) {
		this.cashier = cashier;
	}
	public Waiter getWaiter() {
		return waiter;
	}
	public void setWaiter(Waiter waiter) {
		this.waiter = waiter;
	}
	public String getOrder_opentime() {
		return order_opentime;
	}
	public void setOrder_opentime(String order_opentime) {
		this.order_opentime = order_opentime;
	}
	public String getOrder_closetime() {
		return order_closetime;
	}
	public void setOrder_closetime(String order_closetime) {
		this.order_closetime = order_closetime;
	}
	public float getOrder_price() {
		return order_price;
	}
	public void setOrder_price(float order_price) {
		this.order_price = order_price;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public float getOrder_realprice() {
		return order_realprice;
	}
	public void setOrder_realprice(float order_realprice) {
		this.order_realprice = order_realprice;
	}
	public String getOrder_note() {
		return order_note;
	}
	public void setOrder_note(String order_note) {
		this.order_note = order_note;
	}

	


	


}
