package com.jayesh93.solutions.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jayesh93.solutions.model.Post;
import com.jayesh93.solutions.model.Response;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class UserPostsServiceImpl implements UserPostsService {

	@Autowired
	private RestTemplate restTemplate;

	@SuppressWarnings("unchecked")
	@Override
	@HystrixCommand(fallbackMethod = "getFallbackUserPosts"
//, commandProperties = {
//			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000"),
//			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
//			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
//			@HystrixProperty(name = "circuitBreaker.sleepWindowInMillieconds", value = "5000")}
	)
	public Response<Post> getUserPosts(Long userId) {
		return restTemplate.getForObject("http://media-service/v1/" + userId + "/posts", Response.class);
	}

	@Override
	public Response<Post> getFallbackUserPosts(Long userId) {
		return new Response<Post>();

	}
}
