package com.rest.server.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.rest.server.RestController;
import com.rest.server.service.RestService;

@Configuration
@EnableWebMvc
public class RestConfiguration {

	@Bean
	public RestController controller() {
		return new RestController();
	}
	
	@Bean
	@Qualifier("helloRest")
	public RestService service() {
		return new RestService();
	}

	@Autowired
	private DataSource dataSource;
	
	@Bean
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(dataSource);
	}
}
