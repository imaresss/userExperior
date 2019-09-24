package com.example.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;



@Repository
public class GraphDao extends NamedParameterJdbcDaoSupport {
	
	@Autowired
	private DataSource readDataSources;

	@PostConstruct
	private void initialize() {

		setDataSource(readDataSources);
	}

	
	public User getMasterTags() {
		
		try {
			return getJdbcTemplate().queryForObject("select * from users where id = 100",  new Object[] {  }, new BeanPropertyRowMapper<User>(User.class));
		} catch (Exception e) {
		e.printStackTrace();
		return new User();
		}
	}
}
