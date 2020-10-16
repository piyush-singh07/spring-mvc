package com.crs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.crs.controllers,"
		+ "com.crs.daoimpl,"
		+ "com.crs.serviceimpl,"
		+ "com.crs.util,"
		+ "com.crs.models,"
		+"com.crs.exceptions"
		)
@PropertySource(value="classpath:config.properties")
public class WebConfig extends WebMvcConfigurerAdapter {
	

	@Autowired
	private Environment env;

	
	@Bean(name = "jdbcTemplate")
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		return jdbcTemplate;
	}

	
	@Bean
	public DriverManagerDataSource dataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("driver.classname"));
		dataSource.setUrl(env.getProperty("driver.url"));
		dataSource.setUsername(env.getProperty("driver.username"));
		dataSource.setPassword(env.getProperty("driver.password"));
		return dataSource;
	}
	
	 
}
