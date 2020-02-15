package com.example.model;

import org.bson.Document;

public class Activity {


	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}
	private String activty;
	private long time;
	
	
	public String getActivty() {
		return activty;
	}

	public void setActivty(String activty) {
		this.activty = activty;
	}

	public Activity()
	{
		
	}
	public Activity(Document doc)
	{
		this.activty = doc.getString("name");
		this.time = doc.getLong("time");
	}
}
