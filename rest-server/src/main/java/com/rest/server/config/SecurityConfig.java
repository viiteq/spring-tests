package com.rest.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("bill").password("abc123").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("tom").password("abc123").roles("USER");
    }
     
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http
		.authorizeRequests()
			.anyRequest().authenticated()
			.and()
			.httpBasic()
			.and()
			.sessionManagement().sessionCreationPolicy( SessionCreationPolicy.STATELESS );
//    	BasicAuthenticationEntryPoint basic = new BasicAuthenticationEntryPoint();
//    	basic.setRealmName(REALM);
//    	http.csrf().disable()
//	    	.authorizeRequests()
//	    	.antMatchers("/*").hasRole("ADMIN")
//	    	.and().httpBasic().realmName(REALM)//.authenticationEntryPoint(basic)
//	    	.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);//We don't need sessions to be created.
    }
     
}
