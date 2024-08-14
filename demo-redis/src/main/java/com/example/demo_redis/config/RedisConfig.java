package com.example.demo_redis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.example.demo_redis.model.Person;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Serializers;

@Configuration
public class RedisConfig {

	@Value("$(redis.host.url")
	String host;
	
	@Value("$(redis.host.port")
	Integer port;
	
	@Value("$(redis.auth.password")
	String password;
	
	@Bean
	public LettuceConnectionFactory getConnection() {
		
		RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration(host, port);
		configuration.setPassword(password);
		LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory(configuration);
		
		return lettuceConnectionFactory;
		
	}
	
	@Bean
	public RedisTemplate<String, Person> getTemplate(){ // key should be a string always
		RedisTemplate<String, Person> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(getConnection());
		redisTemplate.setKeySerializer(new StringRedisSerializer()); // java string to redis -> save
		redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
		return redisTemplate;
		
	}
	
	// template is created using which we can execute the commands
	// in that template we will be connecting to these configurations.
	
	
	
}
