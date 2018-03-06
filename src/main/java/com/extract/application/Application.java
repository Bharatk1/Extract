package com.extract.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dto.DtoRequest;
import dto.DtoResponse;

@RestController
@SpringBootApplication
public class Application {	
	@Autowired
	UserRepository user;
	
	@Autowired
	DtoResponse us;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}
	
	@RequestMapping(value="/new",method = RequestMethod.POST)
	public boolean home(@RequestBody DtoRequest name){
	
	us.setName(name.getName());
	us.setId(name.getId());
	us.setAge(name.getAge());
	user.save((us));
	return true;
	}
}
