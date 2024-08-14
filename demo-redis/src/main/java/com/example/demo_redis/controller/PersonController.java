package com.example.demo_redis.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_redis.dto.PersonCreateRequest;
import com.example.demo_redis.service.PersonService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	//PersonService personService;
	PersonService personService;

	/*
	 * String operations
	 * set -> post
	 * get -> get 
	 */
	
@PostMapping("/")
public void createPerson(@RequestBody @Valid PersonCreateRequest request)	{
	personService.create(request.to());
	

}
	
	/*
	 * 
	 * List operations
	 */
	
	/*
	 * 
	 * Hash Opeartions
	 */

}

