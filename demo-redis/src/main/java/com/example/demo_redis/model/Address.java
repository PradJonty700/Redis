package com.example.demo_redis.model;


import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {

	private String street;
	private String city;
	private String state;
	private String country;
	 
}
