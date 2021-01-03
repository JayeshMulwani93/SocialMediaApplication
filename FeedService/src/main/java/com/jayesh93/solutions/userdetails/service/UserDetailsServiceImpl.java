package com.jayesh93.solutions.userdetails.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.jayesh93.solutions.posts.response.Response;
import com.jayesh93.solutions.userdetails.model.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Response<User> getUserFollowers(Long userId) {
		HashMap<String, String> pathParams = new HashMap<>();
		pathParams.put("userId", userId.toString());
		String url = UriComponentsBuilder.fromUriString("http://user-service/v1/users/{userId}/followers")
				.queryParam("page", 0).queryParam("size", 1000).build(pathParams).toString();
		return restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<Response<User>>() {
		}, pathParams).getBody();
	}

}