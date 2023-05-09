package com.example.demo.confi;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfigarations {

	@Bean
	public RouteLocator gateWayRouter(RouteLocatorBuilder rb){
		
	return rb.routes().route(p->p.path("/tax-caluclation/**")
							.uri("lb://tax-caluclation"))
			.route(p->p.path("/tax-caluclation-new/**")
					  .filters(f->f.rewritePath("/tax-caluclation-new/(?<segment>.*)",
					  "/tax-caluclation/${segment}")) .uri("lb://tax-caluclation"))
					 .build();
	
	  
	 
		
	}
}
