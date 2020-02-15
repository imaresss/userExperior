package com.example.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.example.model.Activity;
import com.example.model.INsertActivity;
import com.example.model.InsertEmployee;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Repository
public class SpringDao {
	
	@Autowired
	@Qualifier("ugcMongo")
	MongoDatabase ugcDatabase;

	
	public List<Activity> getActivity()
	{
		MongoCollection<Document> collection = ugcDatabase.getCollection("activity");
		FindIterable<Document> feed = collection.find(new BasicDBObject("time",
				new BasicDBObject("$gte", System.currentTimeMillis() - 24 * 60 * 60 * 7 * 1000L)));
		List<Activity> acitivty = new ArrayList<>();

		for (Document doc : feed) {
			acitivty.add(new Activity(doc));

		}
		return acitivty;
	}
	
	public HashMap<Long, List<Activity>> getNextActivity(List<Activity> activity)
	{
		MongoCollection<Document> collection = ugcDatabase.getCollection("activity");
		FindIterable<Document> feed2 = collection.find(new BasicDBObject("time",
				new BasicDBObject("$gte", System.currentTimeMillis() - 24 * 60 * 60 * 1000L)));

		HashMap<Long, List<Activity>> map2 = new HashMap<>();

		for (Document doc : feed2) {
			Activity a = new Activity();
			a.setActivty(doc.getString("name"));
			a.setTime(doc.getLong("time"));
			if (!map2.containsKey(doc.getLong("parentId"))) {
				map2.put(doc.getLong("parentId"), new ArrayList<Activity>());

				map2.get(doc.getLong("parentId")).add(a);
			} else {

				map2.get(doc.getLong("parentId")).add(a);
			}
			activity.add(new Activity(doc));

		}
		
		return map2;
	}
	
	public boolean insertInEmployee(Long employeeId)
	{
		MongoCollection<Document> collection = ugcDatabase.getCollection("employee");
		InsertEmployee newEmployee = new InsertEmployee(employeeId);
		collection.insertOne(newEmployee.getMongoDocument());
		return true;
	}
	public boolean insertInActivity(Long employeeId , String name , Long time , Long duration)
	{
		MongoCollection<Document> collection = ugcDatabase.getCollection("activity");
		INsertActivity  activity = new INsertActivity(employeeId, name,time ,duration);
		collection.insertOne(activity.getMongoDocument());
		return true;
	}
}
