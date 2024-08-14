package com.example.demo_redis.dto;

import java.util.UUID;

import com.example.demo_redis.model.Address;
import com.example.demo_redis.model.Person;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Builder

public class PersonCreateRequest {

	@NotBlank
	private String name;
	
	private String age;
	
	private Address address;

	// generation a dto from a model
	//generating a random id using uuid.randomUUDId(
	
	public Person to() {
		return Person.builder()
				.name(this.name)
				.address(this.address)
				.id(UUID.randomUUID().toString())
				.build();
				}
}
