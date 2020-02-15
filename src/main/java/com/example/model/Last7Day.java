package com.example.model;

import java.util.List;

public class Last7Day {
	
	public List<ActivityOccurence> getAll_employee() {
		return all_employee;
	}

	public void setAll_employee(List<ActivityOccurence> all_employee) {
		this.all_employee = all_employee;
	}

	private List<ActivityOccurence> all_employee ;
	private List<Employee> today ;
	public List<Employee> getToday() {
		return today;
	}

	public void setToday(List<Employee> today) {
		this.today = today;
	}

}
