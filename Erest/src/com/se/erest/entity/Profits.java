package com.se.erest.entity;

import java.io.Serializable;

public class Profits implements Serializable{
	private int profits_id;
	private String profits_time;
	private float profits_amount;
	public int getProfits_id() {
		return profits_id;
	}
	public void setProfits_id(int profits_id) {
		this.profits_id = profits_id;
	}
	public String getProfits_time() {
		return profits_time;
	}
	public void setProfits_time(String profits_time) {
		this.profits_time = profits_time;
	}
	public float getProfits_amount() {
		return profits_amount;
	}
	public void setProfits_amount(float profits_amount) {
		this.profits_amount = profits_amount;
	}




}
