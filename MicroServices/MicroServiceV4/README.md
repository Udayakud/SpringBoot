# SpringBoot

What ever the i/p coming to the Microservice will get Routed through the API Gateway
simply to say API gate way is the entry point to all Microservices

Spring Cloud Gateway is a framework for building microservices-based applications. It provides support for routing and filtering incoming requests to microservices, as well as support for other common features needed to build a microservices architecture. It is typically used as an API Gateway in a microservices-based application.

Spring Cloud Gateway is important because it provides a simple, yet powerful way to route and manage network traffic to your applications. It is particularly well-suited for cloud native applications, as it is built on top of the Spring framework and uses a reactive, non-blocking architecture that can scale to handle a large number of concurrent requests.

Spring Cloud Gateway works by sitting between your API clients and your backend services. It acts as a reverse proxy, routing requests from clients to the appropriate backend service and then returning the service’s response back to the client. Spring Cloud Gateway uses a routing table to determine how to route incoming requests to the appropriate backend service. This routing table can be configured based on the incoming request’s path, host, and other request metadata.

Spring Cloud Gateway also provides a number of built-in filters that can be used to perform tasks such as authentication, rate limiting, and caching. These filters can be configured and combined to create custom request processing logic.

Updated URL and o/p after appling API-GAteWay

URL

http://localhost:8765/TAX-CALUCLATION/tax-caluclation/for/16/amount/17
{
"id": 1005,
"amount": 17,
"taxmultiple": 30,
"totalTaxCaluclated": 51,
"environment": "8000",
"for": 16
}

http://localhost:8765/TAX-DETAILS/tax-details/for/16

{
"id": 1005,
"taxmultiple": 30,
"environment": "8000",
"for": 16
}

==============================
application.properties
spring.cloud.gateway.discovery.locator.lower-case-service-id=true

http://localhost:8765/tax-details/tax-details/for/16

{
"id": 1005,
"taxmultiple": 30,
"environment": "8000",
"for": 16
}

more about the gateway configurations:

https://cloud.spring.io/spring-cloud-gateway/multi/multi__configuration.html
