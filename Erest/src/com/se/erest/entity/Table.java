package com.se.erest.entity;

import java.io.Serializable;

public class Table implements Serializable{
	private int table_id;
	private Waiter waiter;
	private Busboy busboy;
	private int table_state;
	
	public int getTable_id() {
		return table_id;
	}
	public void setTable_id(int table_id) {
		this.table_id = table_id;
	}
	public int getTable_state() {
		return table_state;
	}
	public void setTable_state(int table_state) {
		this.table_state = table_state;
	}
	public Waiter getWaiter() {
		return waiter;
	}
	public void setWaiter(Waiter waiter) {
		this.waiter = waiter;
	}
	public Busboy getBusboy() {
		return busboy;
	}
	public void setBusboy(Busboy busboy) {
		this.busboy = busboy;
	}


}
