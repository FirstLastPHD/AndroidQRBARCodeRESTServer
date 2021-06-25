package com.zps.qr.db;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.zps.qr.db.model.User;
import com.zps.qr.db.repository.UserRepository;




@SpringBootApplication
//@ComponentScan({"com.zps.qr.db.controller"})
public class CodeReaderServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeReaderServerApplication.class, args);
	}
	
	@Autowired
	private UserRepository repository;
	

	@PostConstruct
	public void initUsers()
	{
		   List<User> users = Stream.of(
	                new User(101, "xadmin", "xadminpassword", "xadmin@gmail.com"),
	                new User(102, "ashish", "ashishpassword", "ashish@gmail.com"),
	                new User(103, "gurpreet", "gurpreetpassword", "gurpreet@gmail.com"),
	                new User(104, "mohit", "mohitpassword", "mohit@gmail.com")
	        ).collect(Collectors.toList());
	        repository.saveAll(users);
	}
	
	

}
