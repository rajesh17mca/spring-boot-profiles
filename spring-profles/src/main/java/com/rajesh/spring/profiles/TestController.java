package com.rajesh.spring.profiles;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	Logger logger = LoggerFactory.getLogger(TestController.class);
	
    @Value("${my.greeting: Apple Greeting}")
    String greetingFromConfig;
    
    @Value("Apple Greeting")
    String staticGreetingCard;
    
    @Value("${my.list.values}")
    List<String> listValues;
    
    @Autowired
    private DBSettings dbSettings;
    
    @GetMapping("greeting")
    public String greetPeople() {
    	logger.info(dbSettings.getConnection() + dbSettings.getHost()+dbSettings.getPort());
        return dbSettings.getConnection() + dbSettings.getHost()+dbSettings.getPort();
    }
}