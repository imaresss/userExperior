package com.example.model;

import java.util.List;
import java.util.Map;

public class EmployeeJson {
	private Long employee;
	private Map<String, String> activties;
	public Long getEmployee() {
		return employee;
	}
	public void setEmployee(Long employee) {
		this.employee = employee;
	}
	public Map<String, String> getActivties() {
		return activties;
	}
	public void setActivties(Map<String, String> activties) {
		this.activties = activties;
	}
	
}
