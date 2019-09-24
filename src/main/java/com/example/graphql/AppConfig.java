package com.example.graphql;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@EnableScheduling
@EnableAsync
@EnableTransactionManagement
@ComponentScan(basePackages = { "com.example" })
public class AppConfig implements WebMvcConfigurer {
//	@Value("${application.key}")
//	private String APPLICATION_KEY;
//
//	@Bean(name = "applicationKey")
//	public String applicationKey() {
//		return APPLICATION_KEY;
//	}

	  @Bean
	    public DataSource getDataSource() {
		  DataSource source = new DataSource();
		  source.setDriverClassName("org.postgresql.Driver");
		  source.setUrl("jdbc:postgresql://womaniya-test.chlaevmryxtx.ap-south-1.rds.amazonaws.com:5432/womaniya_master");
	       source.setUsername("testwomaniya");
	       source.setPassword("testwomaniyaconew");
	        return source;
	    }
//	@Bean(name = "readDataSources")
//	public List<DataSource> getWomaniyaReadReplicaMasterDs() {
//		List<DataSource> dataSource = getDsLocator().getWomaniyaReadReplicaMasterDs();
//		return dataSource;
//	}

	/*
	 * @Bean(name = "readDataSources") public DataSource
	 * getWomaniyaReadReplicaMasterDs() { DataSource dataSource =
	 * getDsLocator().getWomaniyaReadReplicaMasterDs(); return dataSource; }
	 */




}
