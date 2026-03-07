package com.capg.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
public class JavaTopicsController {
	
	@Autowired
	JavaTopicsService topicsService;
	
	@RequestMapping("login.spring")
	public String loginValid() {
		return "Welcome to SpringBoot Application";
	}
	
	@RequestMapping("/javatopics")
	public List getAllTopics() {
		return topicsService.getAllTopics();
	}
}
