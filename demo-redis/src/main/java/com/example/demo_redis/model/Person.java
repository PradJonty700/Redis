package com.example.demo_redis.model;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Person {
	
	
	private String id;
	private String name;
	private String age;
	private Address address;

}
