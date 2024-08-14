package com.example.demo_redis.repository;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo_redis.model.Person;

import io.lettuce.core.dynamic.domain.Timeout;

@Repository
public class PersonRepository {

	@Autowired
	RedisTemplate<String, Person> redisTemplate;
	
	private static final Integer PERSON_VALUE_EXPIRY = 1; // will expiry the person object from the redis server.
	private static final String PERSON_KEY_PREFIX = "person::";
	
	 public void set(Person person){
	        this.redisTemplate.opsForValue().set(getKey(person.getId()), person, PERSON_VALUE_EXPIRY, TimeUnit.DAYS);
	    }
	
	    private String getKey(String personId){
	        return PERSON_KEY_PREFIX + personId;
	    }

}
