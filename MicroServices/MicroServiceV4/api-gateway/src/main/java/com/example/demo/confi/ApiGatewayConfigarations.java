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
		
	Function<PredicateSpec, Buildable<Route>> routeFuction=p->p.path("/get")
			.uri("http://httpbin.org:80");
	return rb.routes().route(routeFuction).build();
		
	}
}
