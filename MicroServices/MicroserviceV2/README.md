# SpringBoot

1. Replace RestTemplet code with FeignClient

2. Create a proxy object for the tax-details-service call it from the tax-caluclation-service and use it

for that 1st step is to add
Dependency in
<dependency>
<groupId>org.springframework.cloud</groupId>
<artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>

add --->
@EnableFeignClients on top of main class of tax-caluclation service and

in tax-caluclation-service create a proxy interface and code
