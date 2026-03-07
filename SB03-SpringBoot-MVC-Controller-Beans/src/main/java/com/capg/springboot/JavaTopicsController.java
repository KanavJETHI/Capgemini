package com.capg.springboot;
import java.util.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JavaTopicsController {
	@RequestMapping("login.spring")
	public String loginValid() {
		return "Welcome to SpringBoot Application";
	}
	
	
	@RequestMapping("kanav.spring")
	public String kanavValid() {
		return "Welcome to SpringBoot Application Kanav";
	}
	
	@RequestMapping("/javatopics")
	public List getAllTopics() {
		return Arrays.asList( (new JavaTopics("SpringBoot", "SpringMVC", "Spring")),
				(new JavaTopics("JPA", "Hibernate", "JDBC")),
				(new JavaTopics("ReactJS", "JavaScript", "Web Development"))
);
	}
	
	
	
	
	
	
}
