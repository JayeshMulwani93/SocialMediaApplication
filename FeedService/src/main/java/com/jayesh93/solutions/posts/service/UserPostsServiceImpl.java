package com.jayesh93.solutions.posts.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.jayesh93.solutions.model.Post;
import com.jayesh93.solutions.posts.request.PostsRequest;
import com.jayesh93.solutions.posts.response.Response;

@Service
public class UserPostsServiceImpl implements UserPostsService {

	@Autowired
	private RestTemplate restTemplate;

	@SuppressWarnings("unchecked")
	@Override
	public Response<Post> getPostsWithIds(Set<Long> posts, int page, int size) {
		PostsRequest postsRequest = new PostsRequest(posts);

		String url = UriComponentsBuilder.fromUriString("http://media-service/v1/posts/lookup")
				.queryParam("page", page)
				.queryParam("size", size)
				.build()
				.toString();

		return restTemplate.postForObject(url, postsRequest, Response.class);
	}
}