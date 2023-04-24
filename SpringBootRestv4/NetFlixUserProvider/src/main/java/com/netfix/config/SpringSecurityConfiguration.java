package com.netfix.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		//1. All request you provide it gets authunticated
		http.authorizeHttpRequests(auth->auth.anyRequest().authenticated());
		//2. If request is not authenticated it will show you a web page
		http.httpBasic();
		//3. post put it will check for csrf certificate
		http.csrf().disable();
		return http.build();
		
	}

}
