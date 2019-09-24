package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class GraphController   {
	
	@Autowired
	GraphDao dao;
	
	@GetMapping(value = "/")
	public  String getServiceCheck() {
		return "Service Running Perfectly";
	}
	
	@GetMapping(value = "/user")
	public  User getUser() {
		
		User user = dao.getMasterTags();
		return  user;
	}
	

}
