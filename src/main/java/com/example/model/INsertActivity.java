package com.example.model;

import org.bson.Document;

public class INsertActivity extends MongoObject {

	private Long id;
	private String name;
	private Long time;
	private Long duration;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public  INsertActivity(long id , String name , Long time , Long duration) {
		// TODO Auto-generated constructor stub
		this.duration = duration;
		this.name = name;
		this.time = time;
		this.id = id;
	}
	
	@Override
	public Document getMongoDocument() {
		Document d = new Document().append("parentId", this.id).append("time", this.time).append("duration",
				this.duration).append("name", this.name);
		return d;
	}

}
