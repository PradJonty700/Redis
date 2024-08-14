package com.example.demo_redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_redis.model.Person;
import com.example.demo_redis.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	PersonRepository personRepository;
	
	public void create(Person person) {
		personRepository.set(person);
		
	}
}
