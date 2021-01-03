package com.jayesh93.solutions.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.jayesh93.solutions.model.User;
import com.jayesh93.solutions.model.UserDetails;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	@HystrixCommand(fallbackMethod = "getFallbackUserInfo"
//	, commandProperties = {
//			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000"),
//			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
//			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
//			@HystrixProperty(name = "circuitBreaker.sleepWindowInMillieconds", value = "5000") }
	)
	public UserDetails getUserInfo(Long userId) {
		return restTemplate.getForObject("http://user-service/v1/users/" + userId + "/details",
				UserDetails.class);
	}

	@Override
	public UserDetails getFallbackUserInfo(@PathVariable Long userId) {
		User user = new User();
		user.setId(userId);
		return new UserDetails(user);
	}
}
