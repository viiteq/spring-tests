package com.rest.server.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.rest.server.BeanController;
import com.rest.server.CustomerController;
import com.rest.server.RestController;
import com.rest.server.service.BeanService;
import com.rest.server.service.RestService;
import com.rest.server.service.RestServiceImpl;

@Configuration
@EnableWebMvc
public class RestConfiguration {

	@Bean
	public RestController controller() {
		return new RestController();
	}
	
	@Bean
	public BeanController beanController() {
		return new BeanController();
	}
	
	@Bean
	public CustomerController custController() {
		return new CustomerController();
	}
	
	
	
	@Bean
	@Qualifier("helloRest")
	public RestService service() {
		return new RestServiceImpl();
	}
	
	@Bean
	public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	
	@Bean
	public BeanService beanService() {
		return new BeanService();
	}
}
