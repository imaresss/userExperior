package com.example.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.constants.Constants;

import com.example.dao.SpringDao;
import com.example.model.Activity;
import com.example.model.ActivityOccurence;
import com.example.model.Employee;
import com.example.model.INsertActivity;
import com.example.model.InsertEmployee;
import com.example.model.Last7Day;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

@Service
public class SpringService {

	@Autowired
	SpringDao dao;
	
	public Last7Day getServiceCheck()
	{
		List<Activity> acitivty = dao.getActivity();
		HashMap<String, Long> map = new HashMap<>();

		for (Activity a : acitivty) {
			if (map.containsKey(a.getActivty())) {
				map.put(a.getActivty(), map.get(a.getActivty()) + 1);
			} else {
				map.put(a.getActivty(), 1L);
			}
		}

		Last7Day response = new Last7Day();
		List<ActivityOccurence> occurence = new ArrayList<>();
		for (Map.Entry<String, Long> entry : map.entrySet()) {
			ActivityOccurence occur = new ActivityOccurence();
			occur.setActivity(entry.getKey());
			occur.setOccurence(entry.getValue());
			occurence.add(occur);
		}
		response.setAll_employee(occurence);


		HashMap<Long, List<Activity>> map2 = dao.getNextActivity(acitivty);
		List<Employee> tActivity = new ArrayList<>();
		for (Map.Entry<Long, List<Activity>> entry : map2.entrySet()) {
			Employee e = new Employee();
			e.setEmployeeId(entry.getKey());
			e.setActivities(entry.getValue());
			tActivity.add(e);
		}

		response.setToday(tActivity);
		return response;
	}
	
	public void addInMongo()
	{
		File folder = new File(Constants.PATH);
		 File[] listOfFiles = folder.listFiles();


		    for (int i = 0; i < listOfFiles.length; i++) {
		    	 if (listOfFiles[i].isFile()) {
		    		 String fileName = listOfFiles[i].getName();
		    		 System.out.println("filename is "+ fileName);
		    		 if(fileName.contains(".json"))
		    		 {
		    				JSONParser parser = new JSONParser();
		    		try {
						Object obj = parser.parse(new FileReader(Constants.PATH+"/"+fileName));
						
						JSONObject jsonObject = (JSONObject) obj;
						Long employeeId = (Long) jsonObject.get("employee_id");

						dao.insertInEmployee(employeeId);
						JSONArray companyList = (JSONArray) jsonObject.get("activities");
						Iterator<JSONObject> iterator = companyList.iterator();
					
						while (iterator.hasNext()) {
							
							JSONObject object = iterator.next();
							dao.insertInActivity(employeeId, (String)object.get("name"),(Long) object.get("time") ,(Long)object.get("duration"));
				
						}
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}


		    		 }
		    	 }
		    }
	}
}
