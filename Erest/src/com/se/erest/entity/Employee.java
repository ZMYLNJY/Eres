package com.se.erest.entity;

import java.io.Serializable;

public class Employee implements Serializable{
	private int id;
	private Manager manager;
	private String schedule;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

}
