package com.example.controller;

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
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.SpringDao;
import com.example.model.Activity;
import com.example.model.ActivityOccurence;
import com.example.model.Employee;
import com.example.model.EmployeeJson;
import com.example.model.INsertActivity;
import com.example.model.InsertEmployee;
import com.example.model.Last7Day;
import com.example.services.SpringService;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@RestController
@RequestMapping("/")
public class GraphController {

	@Autowired
	@Qualifier("ugcMongo")
	MongoDatabase ugcDatabase;

	@Autowired
	SpringService service;

	@GetMapping(value = "/get/details")
	public Last7Day getDetails() {

		return service.getServiceCheck();
	}

	@GetMapping(value = "/add/content")
	public String addContent() {

		service.addInMongo();

		return "asdfsf";
	}

}
