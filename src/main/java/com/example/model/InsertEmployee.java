package com.example.model;

import org.bson.Document;

public class InsertEmployee extends MongoObject{

	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public InsertEmployee()
	{}
	public  InsertEmployee(Long id) {
		this.id = id;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Document getMongoDocument() {
		Document d = new Document().append("employeeId", this.id);
		return d;
	}
}
