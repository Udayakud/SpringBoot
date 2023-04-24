package com.netfix.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netfix.model.Name;
import com.netfix.model.StudentNameV2;
import com.netfix.model.StudentNamev1;

@RestController
public class StudentController {
	//URI versioniong
	@GetMapping("/v1/student")
	public StudentNamev1  getStudentName() {
	 return new StudentNamev1("Rama swami");	
	}

	@GetMapping("/v2/student")
	public StudentNameV2  getStudentNamev2() {
	 return new StudentNameV2(new Name("Rama"," swami"));	
	}
	
	//Request Versioning
	@GetMapping(path="/student",params="version=1")
	public StudentNamev1  getStudentNameReqVer() {
	 return new StudentNamev1("Rama swami");	
	}
	
	@GetMapping(path="/student",params="version=2")
	public StudentNameV2  getStudentNamev2Req() {
	 return new StudentNameV2(new Name("Rama"," swami"));	
	}
	
	//Header versioning
	
	@GetMapping(path="/student/header",headers="STD-API-VERSION=1")
	public StudentNamev1  getStudentNameHeaderVer() {
	 return new StudentNamev1("Rama swami");	
	}
	
	@GetMapping(path="/student/header",headers="STD-API-VERSION=2")
	public StudentNameV2  getStudentNamev2hed() {
	 return new StudentNameV2(new Name("Rama"," swami"));	
	}
	
	
	//Media type version
	
	@GetMapping(path="/student/media",produces="application/vnd.company.app-v1+json")
	public StudentNamev1  getStudentNameMediaV1() {
	 return new StudentNamev1("Rama swami");	
	}
	
	@GetMapping(path="/student/media",produces="application/vnd.company.app-v2+json")
	public StudentNameV2  getStudentNamev2Med() {
	 return new StudentNameV2(new Name("Rama"," swami"));	
	}
	

}
